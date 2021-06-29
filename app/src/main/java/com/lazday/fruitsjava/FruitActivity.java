package com.lazday.fruitsjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FruitActivity extends AppCompatActivity implements FruitAdapter.OnAdapterListener {

    Integer position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        ArrayList<FruitModel> listFruit = new ArrayList<>();
        listFruit.add( new FruitModel("apple", R.drawable.apple) );
        listFruit.add( new FruitModel("avocado", R.drawable.avocado) );
        listFruit.add( new FruitModel("banana", R.drawable.banana) );
        listFruit.add( new FruitModel("cherry", R.drawable.cherry) );
        listFruit.add( new FruitModel("grape", R.drawable.grape) );
        listFruit.add( new FruitModel("orange", R.drawable.orange) );
        listFruit.add( new FruitModel("paprika", R.drawable.paprika) );
        listFruit.add( new FruitModel("pineapple", R.drawable.pineapple) );
        listFruit.add( new FruitModel("strawberry", R.drawable.strawberry) );
        listFruit.add( new FruitModel("tomato", R.drawable.tomato) );
        listFruit.add( new FruitModel("watermelon", R.drawable.watermelon) );

        RecyclerView list = findViewById(R.id.list);
//        FruitsAdapter fruitsAdapter = new FruitsAdapter(listFruit);
        FruitAdapter fruitsAdapter = new FruitAdapter(new ArrayList<>(), this::onClick);
        list.setAdapter( fruitsAdapter );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position < 11) {
                    fruitsAdapter.add( listFruit.get(position) );
                    list.scrollToPosition( position );
                    position ++;
                } else {
                    Toast.makeText(FruitActivity.this, "All fruits are complete!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onClick(FruitModel fruitModel) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("intent_fruit", fruitModel);
        startActivity( intent );
    }
}