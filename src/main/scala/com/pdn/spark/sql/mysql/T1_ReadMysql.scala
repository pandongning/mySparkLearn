package com.pdn.spark.sql.mysql

import java.util.Properties

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object T1_ReadMysql {
  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.WARN)
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val conf: SparkConf = new SparkConf()
    val spark: SparkSession = SparkSession.builder()
      .master("local[*]").config(conf)
      .appName("T1_ReadMysql")
      .enableHiveSupport().getOrCreate()

    import spark.implicits._

    val properties: Properties = new Properties()
    properties.put("user", "root")
    properties.put("password", "root")
    val frame: DataFrame = spark.read.jdbc("jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT%2B8", "mytest.a", properties)

    frame.createOrReplaceTempView("person")

    //    frame里面的数据类型自动的和mysql数据库里面的数据类型保持一致
    spark.sql(
      """
        |select id+1 from person
        |""".stripMargin).show()

    frame.show()

    /**
     * +---+----+-----+
     * | id|name|score|
     * +---+----+-----+
     * |  1|   a|   23|
     * |  2|   b|   24|
     * |  3|   c|   25|
     * |  4|   a|   24|
     * +---+----+-----+
     */


    spark.close()
  }
}
