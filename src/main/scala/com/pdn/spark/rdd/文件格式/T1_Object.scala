package com.pdn.spark.rdd.文件格式

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object T1_Object {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    System.setProperty("HADOOP_USER_NAME", "root");

    val sparkConf: SparkConf = new SparkConf().setAppName("MakeRdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val value: RDD[Car] = sc.makeRDD[Car](Array(new Car("benchi"), new Car("baoma")))

    value.saveAsObjectFile("hdfs://LocalOne:9000/sparkOutTwo")

    val carSource: RDD[Car] = sc.objectFile[Car]("hdfs://LocalOne:9000/sparkOutTwo")
    carSource.foreach(car => car.say())


    sc.stop()
  }
}

class Car(var name: String) extends Serializable {
  def say(): Unit = {
    println(name)
  }
}
