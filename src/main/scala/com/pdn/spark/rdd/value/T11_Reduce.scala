package com.pdn.spark.rdd.value

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T11_Reduce {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName("value").setMaster("local[*]")
    conf.set("spark.default.parallelism", "24")
    val sc: SparkContext = new SparkContext(conf)

    //    两个zip的分区数量必须一致。且分区里面元素数量的数量必须一致
    val valueOne: RDD[Int] = sc.parallelize(Array(1, 2, 3, 2), 2)

//    def reduce(f: (T, T) => T): T  x1是累加之后的值，x2是rdd里面一个元素
    val sum: Int = valueOne.reduce((x1: Int, x2: Int) => x1 + x2)

    val sumAll: Int = valueOne.treeReduce((x1: Int, x2: Int) => (x1 + x2))

    //    reduce里面不一定是要相加的逻辑
    val max: Int = valueOne.reduce((x1: Int, x2: Int) => {
      if (x1 > x2) x1 else x2
    })

    println(sum + "\t" + sumAll + "\t" + max)

    sc.stop()
  }
}
