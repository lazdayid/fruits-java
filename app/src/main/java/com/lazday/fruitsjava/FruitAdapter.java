package com.lazday.fruitsjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<FruitModel> fruits;
    private OnAdapterListener listener;

    public FruitAdapter(List<FruitModel> fruits, OnAdapterListener listener) {
        this.fruits = fruits;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_fruit,
                        parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final FruitModel fruit = fruits.get(position);
        viewHolder.image.setImageResource( fruit.getImage() );
        viewHolder.text.setText( fruit.getName() );
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick( fruit );
            }
        });
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
        }
    }

    public void add(FruitModel data) {
        fruits.add(data);
        notifyDataSetChanged();
    }

    interface OnAdapterListener {
        void onClick(FruitModel fruitModel);
    }
}
