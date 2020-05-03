package com.pdn.spark.rdd.value

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T13_Aggregate {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    val valueOne: RDD[Int] = sc.parallelize(Array(1, 2, 3, 2), 2)

    val flodSum: Int = valueOne.fold(100)((x: Int, y: Int) => x + y)

    //    实现和flod一样的效果。对valueOne里面的全部元素累加
    val aggSum: Int = valueOne.aggregate(100)(_ + _, _ + _)

    //   求valueOne里面所有元素的平均值，返回的U是一个Tuple类型的，
    //   第一个表示所有Rdd里面所有元素的总和
    //    第二个表示所有Rdd里面所有元素的个数总和
    //   点击到源码可以看出，zeroValue和x，W，V的类型全部为U。所以其三个为计算之后返回的值。
    //   y的类型为T，所以其是Rdd里面的元素类型。f
    //   (zeroValue: U)(seqOp: (U, T) => U, combOp: (U, U) => U): U
    val tuple: (Int, Int) = valueOne.aggregate(0, 0)((x, y) => (x._1 + y, x._2 + 1), (w, v) => (w._1 + v._1, (w._2 + v._2)))
    val avrage: Int = tuple._1 / tuple._2

    println(s"flodSum=$flodSum,aggSum=$aggSum,avrage=$avrage")

    sc.stop()
  }
}
