package com.pdn.spark.rdd.partitioner

import org.apache.spark.{HashPartitioner, Partitioner, SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T1 {
  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)

    val pair: RDD[(String, Int)] = sc.makeRDD(Array(("a", 1), ("b", 2)))

    println(pair.partitioner.getOrElse("None"))

    val value: RDD[(String, Int)] = pair.partitionBy(new HashPartitioner(2))
    println(value.partitioner.getOrElse("None"))
    println(value.partitions)

    sc.stop()
  }
}
