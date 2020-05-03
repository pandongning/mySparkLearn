package com.pdn.spark.rdd.缓存CheckPoint

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T2_Checkpoint {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    sc.setCheckpointDir("hdfs://LocalOne:9000/sparkCheckpoint")

    val value: RDD[String] = sc.makeRDD(Array(1, 2))
      .map(ele => ele + "\t" + System.currentTimeMillis())

//    对指定的算子进行checkpoint
    value.checkpoint()

    System.out.println("isCheckpointed:" + value.isCheckpointed)
    System.out.println("checkpoint:" + value.getCheckpointFile)

    value.foreach(println)

    System.out.println("isCheckpointed:" + value.isCheckpointed)
    System.out.println("checkpoint:" + value.getCheckpointFile)

    sc.stop()
  }
}
