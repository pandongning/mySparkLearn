package com.pdn.spark.sql.dataFrame

import com.pdn.spark.sql.beans.{Person, Student}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

import scala.collection.mutable

object T3_Rdd_To_DateSet {
  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val spark: SparkSession = SparkSession.builder()
      .appName(this.getClass.getName)
      .master("local[2]")
      .getOrCreate()

    import spark.implicits._

    val map: mutable.HashMap[String, String] = new mutable.HashMap[String, String]()

    val source: Dataset[String] = spark
      .read.options(map).textFile("file:///D:\\mySparkProject\\mySpark\\in\\a.txt")

    val sourceRdd: RDD[String] = source.rdd

    val studentRdd: RDD[Student] = sourceRdd.map(line => {
      val strings: Array[String] = line.split(",")
      Student(strings(0), strings(1).toInt)
    })

    val studentDataset: Dataset[Student] = studentRdd.toDS()

    studentDataset.createOrReplaceTempView("student")

    spark.sql(
      s"""
         |select name,sum(age) as countAge
         |from student
         |group by name
         |""".stripMargin)
      .show()

    //转换之后，则Rdd里面的元素类型和Dataset里面的元素类型一样
    val rdd: RDD[Student] = studentDataset.rdd
    rdd.map(x=>x.age).foreach(println)

    spark.stop()

  }
}
