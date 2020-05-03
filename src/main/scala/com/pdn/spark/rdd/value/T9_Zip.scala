package com.pdn.spark.rdd.value

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T9_Zip {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    //    两个zip的分区数量必须一致。且分区里面元素数量的数量必须一致
    val valueOne: RDD[Int] = sc.parallelize(Array(1, 2, 3), 2)
    val valueTwo: RDD[Int] = sc.parallelize(Array(4, 5, 6), 2)
    val valueThere: RDD[String] = sc.parallelize(Array("aa", "bb", "cc", "dd"), 2)

    val value: RDD[(Int, Int)] = valueOne.zip(valueTwo)
    value.foreach(println)

    //两个zip的分区数量必须一致。此时分区里面元素数量不必保持一致
    val zipPartitions: RDD[(String, String)] = valueOne.zipPartitions(valueThere, true) {
      case (iterableA, iterableB) => {
        val iteratorA: Iterator[Int] = iterableA.toIterator
        val iteratorB: Iterator[String] = iterableB.toIterator
        Array((iteratorA.mkString("$"), iteratorB.mkString("$"))).iterator
      }
    }

    zipPartitions.foreach(println)

    sc.stop()
  }
}
