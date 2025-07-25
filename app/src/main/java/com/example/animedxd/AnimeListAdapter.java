package com.example.animedxd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimeListAdapter extends RecyclerView.Adapter<AnimeListAdapter.AnimeViewHolder> {
    private List<AnimeItem> animeList;

    public AnimeListAdapter(List<AnimeItem> animeList) {
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        AnimeItem item = animeList.get(position);
        holder.titleText.setText(item.getTitle());
        holder.imageView.setImageResource(item.getImageResId());
        holder.ratingText.setText("Rating: " + item.getRating());
        holder.genreText.setText(item.getGenre());
        holder.descriptionText.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleText, ratingText, genreText, descriptionText;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.animeImage);
            titleText = itemView.findViewById(R.id.animeTitle);
            ratingText = itemView.findViewById(R.id.Rating);
            genreText = itemView.findViewById(R.id.Genre);
            descriptionText = itemView.findViewById(R.id.Description);
        }
    }
}