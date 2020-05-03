package com.pdn.spark.sql.hive

import java.io.File

import org.apache.spark.sql.SparkSession

object DateFrameFromHive {
  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

//    val warehouseLocation: String = new File("hdfs://192.168.28.200/warehouse").getAbsolutePath

    val spark: SparkSession = SparkSession.builder().appName(this.getClass.getSimpleName)
      .master("local[*]")
//      .config("dfs.client.use.datanode.hostname", "true")
//      .config("spark.sql.warehouse.dir", warehouseLocation)
      .enableHiveSupport().getOrCreate()

    spark.sql("select * from person").show()

    spark.stop()
  }
}
