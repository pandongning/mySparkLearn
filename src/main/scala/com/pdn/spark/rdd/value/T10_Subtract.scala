package com.pdn.spark.rdd.value

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T10_Subtract {
  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    //    两个zip的分区数量必须一致。且分区里面元素数量的数量必须一致
    val valueOne: RDD[Int] = sc.parallelize(Array(1, 2, 3, 2), 2)
    val valueTwo: RDD[Int] = sc.parallelize(Array(2, 4, 5), 2)
    //1 3
    valueOne.subtract(valueTwo).foreach(println)

    sc.stop()
  }
}
