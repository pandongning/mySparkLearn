package com.pdn.spark.rdd.value

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object T6_Coalesce {
  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    val value: RDD[Int] = sc.parallelize(Array(1, 2, 3, 1), 3)



    println(value.coalesce(2).getNumPartitions)

    sc.stop()
  }
}
