package com.pdn.spark.graph

import com.pdn.utils.SparkUtils
import org.apache.spark.graphx.{Edge, Graph, VertexId, VertexRDD}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object DemoOne {

  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root")

    val spark: SparkSession = SparkUtils.getSparkSession()

    val path: String = getClass.getClassLoader.getResource("data/demo1.dat").getPath
    import spark.implicits._

    val df: DataFrame = spark.read.option("header", value = true).csv("file://" + path)
    df.cache()

    val vertcies: RDD[(Long, String)] = df.rdd.flatMap(row => {
      val phone: String = row.getAs[String]("phone")
      val name: String = row.getAs[String]("name")
      val wx: String = row.getAs[String]("wx")
      Array(phone, name, wx)
        .filter(str => str != null)
        .map(str => (str.hashCode.toLong, str))
    })
    //    vertcies.take(30).foreach(println)

    val edges: RDD[Edge[String]] = df.rdd.flatMap(row => {
      val phone: String = row.getAs[String]("phone")
      val name: String = row.getAs[String]("name")
      val wx: String = row.getAs[String]("wx")
      val fields: Array[String] = Array(phone, name, wx)
        .filter(str => str != null)

      for (i <- 1 until fields.length) yield Edge(fields(0).hashCode.toLong, fields(i).hashCode.toLong, "")
    })

    val graph: Graph[String, String] = Graph(vertcies, edges)
    val connected: VertexRDD[VertexId] = graph.connectedComponents().vertices
//    connected.take(1).foreach(println)
    /**
     * (-1095633001,-1095633001)
     * (29003441,-1095633001)
     * (113568560,-1485777898)
     * (113568358,-1095633001)
     * (-1485777898,-1485777898)
     * (-1007898506,-1095633001)
     * (681286,-1485777898)
     * (-774337709,-1095633001)
     * (20977295,-1485777898)
     * (-774338670,-1485777898)
     * (208397334,-1485777898)
     * (20090824,-1095633001)
     * (38771171,-1095633001)
     */


    val resDF: Dataset[Row] = vertcies.join(connected).map(
      tp => (tp._2._2, tp._2._1))
      .toDF("gid", "id")
      .distinct()

    resDF.show(1)


//    resDF.coalesce(1).distinct().write.parquet("/spark/graphOut/DemoOneTestTwo")

    spark.close()
  }
}
