package com.pdn.spark.sql.dataFrame

import com.pdn.spark.sql.beans.Student
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object T4_Rdd_DateFrame {
  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val spark: SparkSession = SparkSession.builder()
      .appName(this.getClass.getName)
      .master("local[2]")
      .getOrCreate()

    import spark.implicits._

    val df: DataFrame = spark.read
      .json("hdfs://LocalOne:9000/input/person.josn")
      .toDF("MyName", "MyAge")

    //
    val rdd: RDD[Row] = df.rdd

    rdd.map { row =>
      row.getLong(0)
    }.foreach(println)

    val value: RDD[Student] = spark.sparkContext.parallelize(List(Student("aa", 23), Student("bb", 24)))
    val dataFrame: DataFrame = value.toDF()
    dataFrame.createOrReplaceTempView("stu")
    spark.sql("select * from stu").show()

    spark.stop()
  }
}
