package com.pdn.spark.sql.dataFrame

import com.pdn.spark.sql.beans.Student
import org.apache.spark.sql.{DataFrame, RelationalGroupedDataset, Row, SparkSession}

object T1_Json {

  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val spark: SparkSession = SparkSession.builder()
      .appName(this.getClass.getName)
      //      .enableHiveSupport()
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._

    val dataFrame: DataFrame = spark.read
      .json("hdfs://LocalOne:9000/input/person.josn")
      .toDF("MyName", "MyAge")

    /**
     * 可以看出spark自动的推荐每列的类型
     * root
     * |-- MyName: long (nullable = true)
     * |-- MyAge: string (nullable = true)
     * 但是也可以自己手动的指定类型信息，因为自动的推断，貌似浪费性能
     */
    dataFrame.printSchema()




    dataFrame.createOrReplaceTempView("person")


    spark.sql("select * from person").show()

    spark.stop()
  }
}
