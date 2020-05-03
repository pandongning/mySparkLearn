package com.pdn.spark.stream

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object KafkaLinkSpark {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.WARN)

    System.setProperty("hadoop.home.dir", "C:\\Users\\pdn\\mySoft\\hadoop-2.7.2")
    val conf: SparkConf = new SparkConf().setAppName(this.getClass.getSimpleName).setMaster("local[*]")
    val ssc = new StreamingContext(conf, Seconds(5))

    ssc.checkpoint("file:///ck")

    val kafkaParams: Map[String, Object] = Map[String, Object](
      "bootstrap.servers" -> "LocalOne:9092,LocalTwo:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "pdnSparkStream2"
    )

    val topics: Array[String] = Array("first")

    val messages: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream(
      ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](topics, kafkaParams)
    )

    val lines: DStream[String] = messages.map(_.value)
    val words: DStream[String] = lines.flatMap(_.split(" "))

    val stateStream: DStream[(String, Int)] = words.map((_, 1)).updateStateByKey(updateFunc)


    stateStream.print()

    ssc.start()
    ssc.awaitTermination()

  }


  def updateFunc(values: Seq[Int], state: Option[Int]): Option[Int] = {
    val sum: Int = values.sum + state.getOrElse(0)
    Option(sum)
  }

}
