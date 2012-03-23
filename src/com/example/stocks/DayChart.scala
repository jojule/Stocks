package com.example.stocks

import org.vaadin.hezamu.canvas.Canvas
import com.vaadin.ui.CustomComponent

class DayChart(width:Int, height:Int) extends CustomComponent {
	val canvas = new Canvas() {
	  setWidth(width)
	  setHeight(height)
	}
	setCompositionRoot(canvas)
	def draw(s:Stock) {
		canvas.reset
		canvas.setBackgroundColor("white")
		
		canvas.setFillStyle("cce9ff")
		for (s<-1 to 10 if s%2==1)
			canvas.fillRect(s*width/10, 0, width/10, height)
			
		canvas.setFillStyle("black")
		canvas.setFont("20px Arial")
		canvas.fillText(s.name, 10, 30, 1)
		canvas.setFont("15px Arial")
		canvas.fillText(s.price+"", 10, 50, 1)
		
		canvas.setFillStyle("rgba(0,0,0,0.5)")
		val min = s.history.reduce((x,y)=>if (x.price<y.price) x else y).price
		val max = s.history.reduce((x,y)=>if (x.price>y.price) x else y).price
		var prevx = 0
		for (pp<-s.history) {
		  val x = Math.round(width * (pp.time-s.history.head.time) / (s.history.last.time - s.history.head.time))
		  val y = width - width*(pp.price - min) / (max-min)
		  canvas.fillRect(prevx,y,x-prevx,width-y)
		  prevx=x
		}
	}
	
}
