package com.pdn.spark.sql.udf

import org.apache.spark.sql.{Encoder, Encoders}
import org.apache.spark.sql.expressions.Aggregator

// 既然是强类型，可能有case类
case class Employee(age: Long, name: String)

case class Average(var sum: Long, var count: Long)

// Employee输入的每一条记录的类型，Average缓冲区里面的数据类型，Double返回的数据类型
object MyAverage extends Aggregator[Employee, Average, Double] {

  override def zero: Average = Average(0L, 0L)

  override def reduce(b: Average, a: Employee): Average = {
    b.sum += a.age
    b.count += 1
    b
  }

  override def merge(b1: Average, b2: Average): Average = {
    b1.sum += b2.sum
    b1.count += b2.count
    b1
  }

  override def finish(reduction: Average): Double = {
    reduction.sum / reduction.count
  }

  override def bufferEncoder: Encoder[Average] = {
    Encoders.product
  }

  override def outputEncoder: Encoder[Double] = {
    Encoders.scalaDouble
  }
}
