package com.pdn.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val sparkConf: SparkConf = new SparkConf().setAppName("pdnLocalWordCount").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val lines: RDD[String] = sc.textFile("/root/input")

//    flatMap和map相比，去除了外层的array
//    val value: RDD[Array[String]] = lines.map(_.split("_"))
//    val value1: RDD[String] = lines.flatMap(_.split("_"))

    val words: RDD[String] = lines.flatMap(_.split(" "))
    val wordTuple: RDD[(String, Int)] = words.map((_, 1))
    //    reduceByKey表示将key相同的，对应的value值相加。
    val wordSum: RDD[(String, Int)] = wordTuple.reduceByKey(_ + _)
    wordSum.foreach(println(_))


    sc.stop()
  }
}