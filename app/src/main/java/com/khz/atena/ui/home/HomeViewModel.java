package com.khz.atena.ui.home;

import android.graphics.Color;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.khz.atena.BR;
import com.khz.atena.model.Item;

public class HomeViewModel extends BaseObservable {
    private Item item;

    public HomeViewModel(Item item) {
        this.item = item;
    }

    @Bindable
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
        notifyPropertyChanged(BR.item);
    }

    @BindingAdapter("setSizeTextColor")
    public static void setSizeTextColor(TextView textView, String size) {
        if (size.equalsIgnoreCase("long"))
            textView.setTextColor(Color.parseColor("#4E9D6E"));
        else
            textView.setTextColor(Color.parseColor("#FF4E4E"));
    }
}
