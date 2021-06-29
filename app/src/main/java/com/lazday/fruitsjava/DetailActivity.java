package com.lazday.fruitsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        FruitModel fruitModel = (FruitModel) getIntent().getSerializableExtra("intent_fruit");
        getSupportActionBar().setTitle( fruitModel.getName() );
        ImageView imageView = findViewById(R.id.image);
        imageView.setImageResource( fruitModel.getImage() );
    }
}