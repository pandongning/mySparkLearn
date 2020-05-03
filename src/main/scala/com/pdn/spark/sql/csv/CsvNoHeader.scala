package com.pdn.spark.sql.csv

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object CsvNoHeader {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val spark: SparkSession = SparkUtil.getSpark("csv")

    val map = Map("header" -> "true", "inferSchema" -> "true")
    val dataFrame: DataFrame = spark.read.options(map).csv("/input/person.josn")

    dataFrame.printSchema()
    dataFrame.show()
  }
}
