package com.pdn.spark.sql.udf

import org.apache.spark.sql.{DataFrame, Dataset, SparkSession, TypedColumn}

object UdfAggregator {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val spark: SparkSession = SparkSession.builder()
      .appName(this.getClass.getName)
      .master("local[2]")
      .getOrCreate()

    import spark.implicits._

    val frame: DataFrame = spark.read.json("hdfs://LocalOne:9000/input/person.josn")
    val df: Dataset[Employee] = frame.as[Employee]

    df.createTempView("employee")


    // Convert the function to a `TypedColumn` and give it a name
    val averageSalary : TypedColumn[Employee, Double] = MyAverage.toColumn.name("average_salary")



    val result: Dataset[Double] = df.select(averageSalary)
    result.show()


    spark.stop()
  }
}
