package com.pdn.spark.graph

import com.pdn.utils.SparkUtils
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.sql.types.{DataTypes, StructType}
import org.apache.spark.sql.{DataFrame, SparkSession}

object DemoTwo {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root")

    val spark: SparkSession = SparkUtils.getSparkSession()

    val path: String = getClass.getClassLoader.getResource("data/demo1.dat").getPath
    import spark.implicits._

    val idmapping: collection.Map[String, Long] = spark.read.parquet("/spark/graphOut/DemoOneTestTwo")
      .rdd
      .map(row => {
        val gid: Long = row.getAs[Long]("gid")
        val id: String = row.getAs[String]("id")
        (id, gid)
      }).collectAsMap()


    val bc: Broadcast[collection.Map[String, Long]] = spark.sparkContext.broadcast(idmapping)

    val schema = new StructType()
      .add("phone", DataTypes.StringType)
      .add("name", DataTypes.StringType)
      .add("wx", DataTypes.StringType)
      .add("income", DataTypes.IntegerType)

    val df: DataFrame = spark.read.schema(schema).option("header", value = true).csv("file://" + path)
    df.cache()

    df.rdd.map(row => {
      val idmp: collection.Map[String, Long] = bc.value
      val phone: String = row.getAs[String]("phone")
      val name: String = row.getAs[String]("name")
      val wx: String = row.getAs[String]("wx")
      val income: Int = row.getAs[Int]("income")
      val strings: Array[String] = Array(phone, name, wx).filter(str => str != null)
      val strings1: Array[String] = strings.map(id => {
        val gidOption: Option[Long] = idmp.get(id)
        var gid: String = "未知"
        if (gidOption.isDefined) gid = gidOption.get + ""
        gid
      })
      val gid: String = strings1(0)
      Array(gid, phone, name, wx, income)
    }).take(10).foreach(array => println(array(0)+"\t"+array(1)))

    spark.close()


  }
}
