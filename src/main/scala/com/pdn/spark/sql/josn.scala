package com.pdn.spark.sql

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, SparkSession}

object josn {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.WARN)
    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val session: SparkSession = SparkSession.builder().master("local[*]").appName("json").getOrCreate()

    import session.implicits._

    session.read.json("/input/person.json").write.parquet("/out/parquet")

    val frame: DataFrame = session.read.parquet("/out/parquet")

    frame.toDF("name","age").createOrReplaceTempView("aa")

    session.sql("select name from aa").show()




  }
}
