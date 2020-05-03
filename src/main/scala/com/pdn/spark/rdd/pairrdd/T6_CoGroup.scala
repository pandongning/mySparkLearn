package com.pdn.spark.rdd.pairrdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object T6_CoGroup {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("T6_CoGroup")

    val sc: SparkContext = new SparkContext(conf)
    val valueOne: RDD[(String, Int)] = sc.parallelize(List(("a", 3), ("a", 2), ("c", 4)), 2)
    val valueTwo: RDD[(String, String)] = sc.parallelize(List(("a", "aa1"), ("a", "aa2"), ("c", "cc")), 2)

    val value: RDD[(String, (Iterable[Int], Iterable[String]))] = valueOne.cogroup(valueTwo)

    value.foreach(println)
    sc.stop()
  }
}
