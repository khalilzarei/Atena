package com.khz.atena.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.khz.atena.R;
import com.khz.atena.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainViewModel       viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding   = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainViewModel(this);
        binding.setViewModel(viewModel);
        viewModel.setPicId(R.drawable.pic1);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
//        int selectedId = binding.radioGroup.getCheckedRadioButtonId();
        int selectedId = view.getId();
        int picId      = R.drawable.pic1;
        switch (selectedId) {
            case R.id.radioPic2:
                if (checked)
                    picId = R.drawable.pic2;
                break;
            case R.id.radioPic3:
                if (checked)
                    picId = R.drawable.pic3;
                break;
            case R.id.radioPic4:
                if (checked)
                    picId = R.drawable.pic4;
                break;
            case R.id.radioPic5:
                if (checked)
                    picId = R.drawable.pic5;
                break;
            default:
                picId = R.drawable.pic1;
                break;
        }
        viewModel.setPicId(picId);
    }
}