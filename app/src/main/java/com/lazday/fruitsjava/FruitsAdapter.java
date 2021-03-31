package com.lazday.fruitsjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitsAdapter extends RecyclerView.Adapter<FruitsAdapter.ViewHolder> {

    private List<FruitsModel> fruits;

    public FruitsAdapter(List<FruitsModel> fruits) {
        this.fruits = fruits ;
    }

    @NonNull
    @Override
    public FruitsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_fruits,
                        parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final FruitsModel fruit = fruits.get(position);
        viewHolder.image.setImageResource( fruit.getImage() );
        viewHolder.text.setText( fruit.getName() );
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

    public void add(FruitsModel data) {
        fruits.add(data);
        notifyDataSetChanged();
    }
}
