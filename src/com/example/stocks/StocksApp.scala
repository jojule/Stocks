package com.example.stocks

import com.vaadin.data.Property.ValueChangeEvent
import com.vaadin.ui.Alignment
import vaadin.scala._

class StocksApp extends SimpleApplication(title = "Day Trader", theme="stocks") {
  override def main = new VerticalLayout(height = "100%") {
    val hl = new HorizontalLayout(margin = true) {
      val chart = new DayChart(512, 512)
      val table = new Table(selectable=true, immediate=true, height="100%") {
        addContainerProperty("price", classOf[String], "")
        for (s <- Market.stocks) addItem(Array("" + s.price), s.name)
        addListener((e: ValueChangeEvent) => chart.draw(Market.stocks.find(_.name == getValue).head))
        select(Market.stocks.head.name)
        setColumnHeaderMode(com.vaadin.ui.Table.COLUMN_HEADER_MODE_HIDDEN)
        setRowHeaderMode(com.vaadin.ui.Table.ROW_HEADER_MODE_ID)
      }
      add(table)
      add(chart)
    }
    add(hl)
    setComponentAlignment(hl, Alignment.MIDDLE_CENTER)
  }
}
