package com.pdn.spark.rdd.缓存CheckPoint

import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object T1_Cache {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root")

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)

    val value: RDD[String] = sc.makeRDD(Array(1, 2))
      .map(ele => ele + "\t" + System.currentTimeMillis())
      .persist(StorageLevel.MEMORY_AND_DISK_SER)

    value.collect().foreach(println)
    value.collect().foreach(println)

    value.saveAsTextFile("hdfs://LocalOne:9000/outThere")

    sc.stop()

  }
}
