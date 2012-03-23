package com.example.stocks

object Market {
  val stocks = for (s <- 1 to 100) yield Stock((for (c <- 1 to 4) yield ('A' + Math.random*26).toChar).mkString)
}

case class Stock(name:String) {
  var history = randomHistory(System.currentTimeMillis - 600000, System.currentTimeMillis, Math.random * 500)
  def randomHistory(s:Long, e:Long, p:Double) : List[PricePoint] = if (s>=e) Nil else
    PricePoint(p, s) :: randomHistory(s + 3000, e, p * (0.95 + Math.random/10))
  def price = Math.round(history.last.price * 100.0) / 100.0
}

case class PricePoint(price: Double, time: Long)
