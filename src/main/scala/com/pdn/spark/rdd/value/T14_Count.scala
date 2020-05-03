package com.pdn.spark.rdd.value

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T14_Count {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    val valueOne: RDD[Int] = sc.parallelize(Array(1, 2, 3, 2), 2)

    val count: Long = valueOne.count()
    println(s"count=$count")

    //    Rdd里面，相同的元素出现的次数
    val valueMap: collection.Map[Int, Long] = valueOne.countByValue()
    println(valueMap)

    sc.stop()
  }
}
