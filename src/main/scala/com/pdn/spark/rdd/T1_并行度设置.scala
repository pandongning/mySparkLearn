package com.pdn.spark.rdd


import java.net.URL

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object T1_并行度设置 {
  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    val defaultParallelism: Int = sc.defaultParallelism
    println(s"parallelism=$defaultParallelism")

    val value: RDD[Int] = sc.makeRDD(Array(1, 2, 3))
    val partitions: Int = value.getNumPartitions
    println(partitions)


    val url: URL = getClass.getClassLoader.getResource("stu.csv")
    val localSource: RDD[String] = sc.textFile("file:///" + url.getPath)
    println(s"localSource=${localSource.getNumPartitions}")
    val localMap: RDD[String] = localSource.map(_.toLowerCase)
    println(s"localMap=$localMap")


    val source: RDD[String] = sc.textFile("hdfs://LocalOne:9000/input", 24)
    println(source.getNumPartitions)
    val hdfsMap: RDD[String] = source.map(_.toLowerCase)
    println(s"hdfsMap=${hdfsMap.getNumPartitions}")

    val value1: RDD[(String, Int)] = source.flatMap(_.split("_")).map((_, 1))
    println(s"value1=${value1.getNumPartitions}")
    //    shuffle操做的并行度为默认的值
    val value2: RDD[(String, Int)] = value1.reduceByKey(_ + _)
    println(s"${value2.getNumPartitions}")

    //   其并行度和其父依赖reduceByKey的并行度一致
    val value3: RDD[Int] = value2.map(_._2)
    println(value3.getNumPartitions)

    sc.stop()


  }
}
