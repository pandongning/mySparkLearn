package com.pdn.spark.rdd.pairrdd

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T2_GroupByKey {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)

    val value: RDD[(Int, String)] = sc.parallelize(Array((1, "aaa"), (2, "bbb"), (2, "ccc"), (4, "ddd")), 3)

    value.sortByKey()
//    第一个参数Int表示key的类型。
    val groupByKey: RDD[(Int, Iterable[String])] = value.groupByKey()

    val rs: RDD[String] = groupByKey.map {
      case (key, values) => {
        val str: String = values.mkString("$")
        str + "\t" + key
      }
    }

    rs.foreach(println)

    sc.stop()
  }
}
