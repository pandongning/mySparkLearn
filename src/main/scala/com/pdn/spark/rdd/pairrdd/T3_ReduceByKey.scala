package com.pdn.spark.rdd.pairrdd

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T3_ReduceByKey {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)

    val soure: RDD[(Int, String)] = sc.parallelize(Array((1, "aaa"), (2, "bbb"), (2, "ccc"), (4, "ddd")), 3)

    val rs: RDD[(Int, String)] = soure.reduceByKey {
      case (stringOne, stringTwo) =>
        stringOne + "\t" + stringTwo
    }

    rs.foreach(println)

    sc.stop()
  }
}
