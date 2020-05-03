package com.pdn.spark.rdd.value

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T4_Filter {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    val value: RDD[(String, Int)] = sc.makeRDD(Array(("a", 1), ("a", 2), ("b", 1), ("b", 2)))

    value.filter {
      case (str, i) => str != "a"
    }.foreach(
      println
    )

    value.saveAsTextFile("hdfs://LocalOne:9000/spark/RddOut/two")

    sc.stop()
  }
}
