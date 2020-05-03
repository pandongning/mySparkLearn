package com.pdn.spark.rdd.value

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T2_Glom {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    val value: RDD[Int] = sc.parallelize(Array(1, 2, 3, 4), 3)
    val value1: RDD[Array[Int]] = value.glom()
//    1 2 4
    value1.map(x => x.max).foreach(println)


    sc.stop()

  }
}
