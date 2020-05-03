package com.pdn.spark.rdd.累加器

import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

object T1_LongAccumulator {

  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val valueOne: RDD[(String, Int)] = sc.parallelize(List(("a", 3), ("a", 2), ("c", 4), ("b", 3)), 2)

    val count: LongAccumulator = sc.longAccumulator("count")
    println(count)

    sc.parallelize(Array(1, 2, 3, 4)).foreach(x => count.add(x))

    println(count.value)

    sc.stop()

  }
}
