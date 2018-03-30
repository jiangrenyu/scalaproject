package com.jry

import java.util.UUID

/**
  * Created by jiangry01 on 2018/3/15.
  */
object Distance {
  def main(args: Array[String]): Unit = {
      println(getDis(109.387964,24.341366,109.402548,24.296016))
      val list = Array()
      list.hashCode();

  }
  private def Rad(dDegree: Double) = dDegree * 3.14 / 180.0

  private def round(d: Double) = Math.floor(d + 0.5)

  def getDis(Longitude1: Double, Latitude1: Double, Longitude2: Double, Latitude2: Double): Double ={
    val dRadLat1 = Rad(Latitude1)
    val dRadLat2 = Rad(Latitude2)
    val a = dRadLat1 - dRadLat2
    val b = Rad(Longitude1) - Rad(Longitude2)
    val EARTH_RADIUS = 6371
    val dRad = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(dRadLat1) * Math.cos(dRadLat2) * Math.pow(Math.sin(b / 2), 2)))
    var dDistance = dRad * EARTH_RADIUS
    dDistance = round(dDistance * 10000) / 10000
    return Math.abs(dDistance * 1000)
  }
}
