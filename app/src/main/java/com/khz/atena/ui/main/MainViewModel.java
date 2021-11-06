package com.khz.atena.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.android.material.snackbar.Snackbar;
import com.khz.atena.BR;
import com.khz.atena.R;
import com.khz.atena.model.Item;
import com.khz.atena.ui.binance.BinanceActivity;
import com.khz.atena.ui.home.HomeActivity;

public class MainViewModel extends BaseObservable {

    private       String   percent;
    private       String   filusdt;
    private       String   pl;
    private       String   size;
    private       String   entryPrice;
    private       String   currentPrice;
    private       String   takeProfit;
    private final Activity activity;
    private       int      picId;

    public MainViewModel(Activity activity) {
        this.activity = activity;
    }

    @Bindable
    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
        notifyPropertyChanged(BR.percent);
    }

    @Bindable
    public String getFilusdt() {
        return filusdt;
    }

    public void setFilusdt(String filusdt) {
        this.filusdt = filusdt;
        notifyPropertyChanged(BR.filusdt);
    }

    @Bindable
    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
        notifyPropertyChanged(BR.pl);
    }

    @Bindable
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
        notifyPropertyChanged(BR.size);
    }

    @Bindable
    public String getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(String entryPrice) {
        this.entryPrice = entryPrice;
        notifyPropertyChanged(BR.entryPrice);
    }

    @Bindable
    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
        notifyPropertyChanged(BR.currentPrice);
    }

    @Bindable
    public String getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(String takeProfit) {
        this.takeProfit = takeProfit;
        notifyPropertyChanged(BR.takeProfit);
    }

    @Bindable
    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
        notifyPropertyChanged(BR.picId);
    }

    public void goHomeActivity(View view) {
       /* if (percent == null || percent.isEmpty()) {
            showSnake(view, "Please enter percent");
            return;
        }
        if (filusdt == null || filusdt.isEmpty()) {
            showSnake(view, "Please enter FILUSDT");
            return;
        }
        if (pl == null || pl.isEmpty()) {
            showSnake(view, "Please enter P&L");
            return;
        }
        if (size == null || size.isEmpty()) {
            showSnake(view, "Please enter size");
            return;
        }
        if (entryPrice == null || entryPrice.isEmpty()) {
            showSnake(view, "Please enter Entry Price");
            return;
        }
        if (currentPrice == null || currentPrice.isEmpty()) {
            showSnake(view, "Please enter Current Price");
            return;
        }
        if (takeProfit == null || takeProfit.isEmpty()) {
            showSnake(view, "Please enter Take Profit");
            return;
        }
        Item   item   = new Item(percent, filusdt, pl, size, entryPrice, currentPrice, takeProfit);*/
        Intent intent = new Intent(activity, HomeActivity.class);
        if (view.getId() == R.id.cardTwo)
            intent = new Intent(activity, BinanceActivity.class);
//        intent.putExtra("item", item);
//        intent.putExtra("picId", getPicId());
        activity.startActivity(intent);
    }


    public void showSnake(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }
}
