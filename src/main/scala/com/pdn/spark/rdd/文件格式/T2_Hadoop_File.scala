package com.pdn.spark.rdd.文件格式

import org.apache.spark.{SparkConf, SparkContext}

object T2_Hadoop_File {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)

//    sc.newAPIHadoopFile()

    sc.stop()
  }
}
