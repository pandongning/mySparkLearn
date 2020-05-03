package com.pdn.utils

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkUtils {
  def getSparkSession(appName: String = "app", master: String = "local[*]", cnfMap: Map[String, String] = Map.empty[String, String]): SparkSession = {
    val conf: SparkConf = new SparkConf()
    conf.setAll(cnfMap)
    SparkSession.builder().appName(appName).config(conf).master(master).getOrCreate()
  }
}
