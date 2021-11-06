package com.khz.atena.ui.binance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.khz.atena.R;
import com.khz.atena.databinding.ActivityBinanceBinding;
import com.khz.atena.ui.home.HomeViewModel;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class BinanceActivity extends AppCompatActivity {

    ActivityBinanceBinding binding;
    HomeViewModel          viewModel;
    private static final int PICK_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding   = DataBindingUtil.setContentView(this, R.layout.activity_binance);
        viewModel = new HomeViewModel(this);
        binding.setViewModel(viewModel);
    }

    public void chooseImage(View view) {
        openGallery();
    }

    private void openGallery() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            try {
                final Uri         imageUri      = data.getData();
                final InputStream imageStream   = getContentResolver().openInputStream(imageUri);
                final Bitmap      selectedImage = BitmapFactory.decodeStream(imageStream);
                binding.picHome.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
        }
    }
}