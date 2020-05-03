package com.pdn.spark.rdd.value

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T5_Distinct {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    val value: RDD[Int] = sc.makeRDD(Array(1, 2, 3, 1), 3)

    value.distinct().foreach(println)

    value.distinct(2).foreachPartition(x=>println(x.toList))

    sc.stop()
  }
}
