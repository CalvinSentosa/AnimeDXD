package com.example.animedxd;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimeListAdapter extends RecyclerView.Adapter<AnimeListAdapter.ViewHolder> {

    private Context context;
    private List<AnimeItem> animeList;

    public AnimeListAdapter(Context context, List<AnimeItem> animeList) {
        this.context = context;
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_anime, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnimeItem anime = animeList.get(position);
        holder.animeTitle.setText(anime.getTitle());
        holder.genre.setText(anime.getGenre());
        holder.rating.setText(String.valueOf(anime.getRating()));
        holder.description.setText(anime.getDescription());
        holder.image.setImageResource(anime.getImageResId());

        // 🔸 Handle click
        holder.itemView.setOnClickListener(v -> {
            if (anime.getTitle().equalsIgnoreCase("DEMON SLAYER")) {
                Intent intent = new Intent(context, DemonDetailActivity.class);
                intent.putExtra("title", anime.getTitle());
                intent.putExtra("imageResId", anime.getImageResId());
                context.startActivity(intent);
            } else if (anime.getTitle().equalsIgnoreCase("HUNTER X HUNTER")) {
                Intent intent = new Intent(context, HunterDetailActivity.class);
                intent.putExtra("title", anime.getTitle());
                intent.putExtra("imageResId", anime.getImageResId());
                context.startActivity(intent);
            } else if (anime.getTitle().equalsIgnoreCase("ONE PUNCH MAN")) {
                Intent intent = new Intent(context, OneDetailActivity.class);
                intent.putExtra("title", anime.getTitle());
                intent.putExtra("imageResId", anime.getImageResId());
                context.startActivity(intent);
            } else if (anime.getTitle().equalsIgnoreCase("JUJUTSU KAISEN")) {
                Intent intent = new Intent(context, JjkDetailActivity.class);
                intent.putExtra("title", anime.getTitle());
                intent.putExtra("imageResId", anime.getImageResId());
                context.startActivity(intent);
            } else if (anime.getTitle().equalsIgnoreCase("HAIKYU")) {
                Intent intent = new Intent(context, HaikyuDetailActivity.class);
                intent.putExtra("title", anime.getTitle());
                intent.putExtra("imageResId", anime.getImageResId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView animeTitle, genre, rating, description;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            animeTitle = itemView.findViewById(R.id.animeTitle);
            genre = itemView.findViewById(R.id.Genre);
            rating = itemView.findViewById(R.id.Rating);
            description = itemView.findViewById(R.id.Description);
            image = itemView.findViewById(R.id.animeImage);
        }
    }
}
