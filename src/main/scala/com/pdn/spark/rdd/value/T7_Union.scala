package com.pdn.spark.rdd.value

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T7_Union {
  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    val valueOne: RDD[Int] = sc.parallelize(Array(1, 2, 3, 1), 3)
    val valueTwo: RDD[Int] = sc.parallelize(Array(3, 4, 5), 2)
    val valueThere: RDD[String] = sc.parallelize(Array("aa", "ba"), 2)

    val value: RDD[Int] = valueOne.union(valueTwo)
    value.foreach(println)
    //进行union的两个rdd的元素类型必须相同
    //    valueOne.union(valueThere)

    sc.stop()
  }
}
