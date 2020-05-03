package com.pdn.spark.rdd.pairrdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object T4_AggregateByKey {

  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)

    val value: RDD[(String, Int)] = sc.parallelize(List(("a", 3), ("a", 2), ("c", 4), ("b", 3), ("c", 6), ("c", 8)), 2)

    val maxSum: RDD[(String, Int)] = value.aggregateByKey(0)((x, y) => math.max(x, y), (w, v) => w + v)

    maxSum.foreach {
      case (key, sum) => println(key + "\t" + sum)
    }


    sc.stop()
  }
}
