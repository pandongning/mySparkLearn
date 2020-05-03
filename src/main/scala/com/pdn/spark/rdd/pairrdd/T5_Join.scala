package com.pdn.spark.rdd.pairrdd

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T5_Join {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)

    val valueOne: RDD[(String, Int)] = sc.parallelize(List(("a", 3), ("a", 2), ("c", 4), ("b", 3)), 2)
    val valueTwo: RDD[(String, String)] = sc.parallelize(List(("a", "aa1"), ("a", "aa2"), ("c", "cc"), ("b", "bb")), 2)

    val value: RDD[(String, (Int, String))] = valueOne.join(valueTwo)

//    join的时候可以使用广播变量，提高效率
    val valueOneBroadcast: Broadcast[RDD[(String, String)]] = sc.broadcast(valueTwo)
    valueOne.join(valueOneBroadcast.value)

    value.foreach(println)

    value.saveAsTextFile("/outTwo")

    sc.stop()
  }
}
