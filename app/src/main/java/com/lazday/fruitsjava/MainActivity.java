package com.lazday.fruitsjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Integer position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<FruitsModel> listFruit = new ArrayList<>();
        listFruit.add( new FruitsModel("apple", R.drawable.apple) );
        listFruit.add( new FruitsModel("avocado", R.drawable.avocado) );
        listFruit.add( new FruitsModel("banana", R.drawable.banana) );
        listFruit.add( new FruitsModel("cherry", R.drawable.cherry) );
        listFruit.add( new FruitsModel("grape", R.drawable.grape) );
        listFruit.add( new FruitsModel("orange", R.drawable.orange) );
        listFruit.add( new FruitsModel("paprika", R.drawable.paprika) );
        listFruit.add( new FruitsModel("pineapple", R.drawable.pineapple) );
        listFruit.add( new FruitsModel("strawberry", R.drawable.strawberry) );
        listFruit.add( new FruitsModel("tomato", R.drawable.tomato) );
        listFruit.add( new FruitsModel("watermelon", R.drawable.watermelon) );

        RecyclerView list = findViewById(R.id.list);
//        FruitsAdapter fruitsAdapter = new FruitsAdapter(listFruit);
        FruitsAdapter fruitsAdapter = new FruitsAdapter(new ArrayList<>());
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
                    Toast.makeText(MainActivity.this, "All fruits are complete!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}