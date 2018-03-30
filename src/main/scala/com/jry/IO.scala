package com.jry

import java.io._
import scala.io.Source
/**
  * Created by jiangry01 on 2018/3/14.
  */
object IO {
  def main(args: Array[String]): Unit = {
            //write2()
             read2()
  }

  /**
    * FileWriter
    */
  def write1(): Unit ={
    val out =new FileWriter("./resource/file1",true)
    for(i <- 0 to 15){
      out.write(i.toString)
    }
    out.close()
  }

  /**
    * RandomAcceFile
    */
  def write2(): Unit ={
     val randomAccessFile = new RandomAccessFile("./resource/file1","rw")
     val fileLength = randomAccessFile.length()
     println("打印文件长度:  "+ fileLength)
     randomAccessFile.seek(fileLength)  //指针指向文件末尾,否则会覆盖之前的文件
     for(i <- 'a' to 'g')  randomAccessFile.writeBytes(i.toString)
     randomAccessFile.close
  }

  /**
    * 基本的读取文件，按行读取
     */
  def read1(): Unit ={
      val file = Source.fromFile("./resource/file1")
      //val lines = file.getLines()
      //for(line <- lines) println("行:  "+line)

      //for (line <- file.getLines().toArray) println("file :  " + line)
      println(file.mkString(","))
  }

  def read2(): Unit ={
      val file = Source.fromFile("./resource/file1")
//      for (f <- file){
//          println(f.toString)
//      }
      val iter  = file.buffered
      while(iter.hasNext){
           var a = ""
           if((a==iter.head).equals("a")){
              println("!: " + iter.head)
           }else{
              println("错误数据....")
           }
      }
      file.close()
  }

}
