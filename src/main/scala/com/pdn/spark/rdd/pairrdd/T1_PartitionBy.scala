package com.pdn.spark.rdd.pairrdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object T1_PartitionBy {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)

    val value: RDD[(Int, String)] = sc.parallelize(Array((1, "aaa"), (2, "bbb"), (3, "ccc"), (4, "ddd")), 3)

    val value1: RDD[(Int, String)] = value.partitionBy(new org.apache.spark.HashPartitioner(2))
    println(value.getNumPartitions + value1.getNumPartitions)

    sc.stop()
  }
}
