package com.pdn.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

object MakeRdd {

  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.parallelize(List(1, 2, 3))
    val sum: LongAccumulator = sc.longAccumulator

    rdd.foreach {
      x => sum.add(x)
    }

    println(sum.value)

    sc.stop()

  }
}
