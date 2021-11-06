package com.khz.atena.ui.home;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.khz.atena.BR;
import com.khz.atena.R;
import com.khz.atena.model.Item;

import org.w3c.dom.Text;

public class HomeViewModel extends BaseObservable {
    private Activity activity;

    public HomeViewModel(Activity activity) {
        this.activity = activity;
    }

    public void setTextField(View v) {
        AlertDialog.Builder builder    = new AlertDialog.Builder(activity);
        ViewGroup           viewGroup  = activity.findViewById(android.R.id.content);
        View                dialogView = LayoutInflater.from(activity).inflate(R.layout.dialog_set_ip, viewGroup, false);
        EditText            etTopic    = dialogView.findViewById(R.id.etTopic);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.show();
        dialogView.findViewById(R.id.btnSend).setOnClickListener(view -> {
            if (etTopic.getText().toString().isEmpty()) {
                Toast.makeText(activity, "Please Enter Text", Toast.LENGTH_SHORT).show();
                return;
            }
            String topic = etTopic.getText().toString();

            switch (v.getId()) {
                case R.id.tvSizeStatus:
                    if (topic.equalsIgnoreCase("long"))
                        ((TextView) v).setTextColor(Color.parseColor("#4E9D6E"));
                    else
                        ((TextView) v).setTextColor(Color.parseColor("#FF4E4E"));
                    break;
                case R.id.tvPercent:
                    topic += " ";
                    break;
            }
            ((TextView) v).setText(topic);
            alertDialog.dismiss();
        });
    }
}
