package com.pdn.spark.sql.csv

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object SparkUtil {
  def getSpark(app: String = "demo"): SparkSession = {
    Logger.getLogger("org").setLevel(Level.WARN)
    SparkSession.builder().appName(app).master("local[*]").getOrCreate()
  }
}
