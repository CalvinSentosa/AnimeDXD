package com.example.animedxd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder> {

    private List<Integer> imageList;

    public CarouselAdapter(List<Integer> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.carousel_item, parent, false);
        return new CarouselViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
        int actualPosition = position % imageList.size();
        holder.imageView.setImageResource(imageList.get(actualPosition));
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE; // simulate infinite items
    }

    static class CarouselViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        CarouselViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.carouselImage);
        }
    }
}

