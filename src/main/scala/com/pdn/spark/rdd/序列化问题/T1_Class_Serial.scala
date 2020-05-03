package com.pdn.spark.rdd.序列化问题

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object T1_Class_Serial {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "hdfs");

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)

    val valueOne: RDD[(String, Int)] = sc.parallelize(List(("a", 3), ("a", 2), ("c", 4), ("b", 3)), 2)

    //    valueOne.filter(myFilterTwo).foreach(println)
    //    valueOne.filter(new Search().myFilter).foreach(println)

    val value: RDD[(String, Int)] = new Search("a").contains(valueOne)
    value.foreach(println)

    sc.stop()
  }


  def myFilterTwo(tuple2: (String, Int)): Boolean = {
    tuple2._1 == "a"
  }
}


//此类需要被序列化
class Search(var query: String) extends Serializable {

  def myFilter(tuple2: (String, Int)): Boolean = {
    tuple2._1 == "a"
  }

  def contains(rdd: RDD[(String, Int)]): RDD[(String, Int)] = {
    rdd.filter(_._1.contains(this.query))
  }
}
