package com.pdn.spark.rdd

import org.apache.spark.rdd.RDD

class Search(query: String) extends Serializable {

  def isMatch(s: String): Boolean = {
    s.contains(query)
  }

  def getMatch1(rdd: RDD[String]): RDD[String] = {
    rdd.filter(isMatch)
  }

  def getMatch2(rdd: RDD[String]): RDD[String] = {
    rdd.filter(isMatch)
  }
}
