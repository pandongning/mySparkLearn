package com.pdn.spark.rdd.value

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object T3_GroupBy {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    val value: RDD[(String, Int)] = sc.makeRDD(Array(("a", 1), ("a", 2), ("b", 1), ("b", 2)))

    //    groupBy里面的函数用于指定根据那个字段进行聚合。
    //    此处是指定按照tuple里面的第一个字段聚合。第一个字段相同的放在一块
    val value1: RDD[(String, Iterable[(String, Int)])] = value.groupBy((tuple: (String, Int)) => tuple._1)

    value1.foreach {
      case (key, tuples) =>
        val iterator: Iterator[(String, Int)] = tuples.iterator
        while (iterator.hasNext) {
          println(key + "$$" + iterator.next())
        }
    }

    sc.stop()

  }
}
