package com.pdn.spark.rdd.value

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T12_Fold {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    //    两个zip的分区数量必须一致。且分区里面元素数量的数量必须一致
    val valueOne: RDD[Int] = sc.parallelize(Array(1, 2, 3, 2), 2)

    val rs: Int = valueOne.fold(100)((x, y) => x + y)
    val rsTwo: Int = valueOne.fold(100)((x, y) => {
      if (x > y) x else y
    })

    //    308	100
    println(rs + "\t" + rsTwo)

    sc.stop()
  }
}
