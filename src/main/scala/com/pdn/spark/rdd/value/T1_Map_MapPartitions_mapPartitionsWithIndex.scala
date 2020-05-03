package com.pdn.spark.rdd.value

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object T1_Map_MapPartitions_mapPartitionsWithIndex {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    val value: RDD[Int] = sc.parallelize(Array(1, 2, 3, 4), 3)
    val value1: RDD[Int] = value.map(_ * 2)
    println(value1.getNumPartitions) //3

    val value2: RDD[Int] = value.mapPartitions((x: Iterator[Int]) => x.map((_: Int) * 2))
    println(value2.getNumPartitions) //3

    value2.foreachPartition(x => println(x.mkString(",")))

    value.mapPartitionsWithIndex {
      case (index, datas) => {
        datas.map(x => (x, index))
      }
    }.foreach(println(_))

    sc.stop()
  }
}
