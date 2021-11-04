package com.khz.atena.model;

import java.io.Serializable;

public class Item implements Serializable {
    private String percent;
    private String filusdt;
    private String pl;
    private String size;
    private String entryPrice;
    private String currentPrice;
    private String takeProfit;

    public Item(String percent, String filusdt, String pl, String size, String entryPrice, String currentPrice, String takeProfit) {
        this.percent      = percent;
        this.filusdt      = filusdt;
        this.pl           = pl;
        this.size         = size;
        this.entryPrice   = entryPrice;
        this.currentPrice = currentPrice;
        this.takeProfit   = takeProfit;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getFilusdt() {
        return filusdt;
    }

    public void setFilusdt(String filusdt) {
        this.filusdt = filusdt;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(String entryPrice) {
        this.entryPrice = entryPrice;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(String takeProfit) {
        this.takeProfit = takeProfit;
    }
}
