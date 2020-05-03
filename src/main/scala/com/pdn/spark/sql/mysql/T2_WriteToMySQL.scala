package com.pdn.spark.sql.mysql

import java.util.Properties

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, SparkSession}

object T2_WriteToMySQL {
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

    val struct: StructType =
      StructType(
        StructField("", IntegerType, nullable = true) ::
          StructField("name", StringType, nullable = false) ::
          StructField("c", IntegerType, nullable = false) :: Nil)
    val frame: DataFrame = spark.read.jdbc("jdbc:mysql://localhost:3306/mytest?serverTimezone=GMT%2B8", "a", properties)

    frame.createOrReplaceTempView("person")

    spark.sql(
      """
        |select id+1 from person
        |""".stripMargin).show()

    frame.show()

    frame.write.jdbc("jdbc:mysql://localhost:3306/mytest?serverTimezone=GMT%2B8", "e", properties)

    spark.close()
  }
}
