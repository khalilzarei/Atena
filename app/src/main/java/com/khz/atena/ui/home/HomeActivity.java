package com.khz.atena.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.khz.atena.R;
import com.khz.atena.databinding.ActivityHomeBinding;
import com.khz.atena.model.Item;
import com.khz.atena.ui.main.MainActivity;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    HomeViewModel       viewModel;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        Item item = (Item) getIntent().getSerializableExtra("item");

        if (item == null) {
            onBackPressed();
            finish();
        } else {
            viewModel = new HomeViewModel(item);
            binding.setViewModel(viewModel);
        }
        int picId = getIntent().getIntExtra("picId", R.drawable.pic1);
        binding.picHome.setImageResource(picId);
    }

    public void chooseImage(View view) {
        openGallery();
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            binding.picHome.setImageURI(imageUri);
        }
    }
}