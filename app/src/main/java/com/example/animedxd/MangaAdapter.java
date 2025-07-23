package com.example.animedxd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.ViewHolder> {

    private final Context context;
    private final List<Manga> mangaList;

    public MangaAdapter(Context context, List<Manga> mangaList) {
        this.context = context;
        this.mangaList = mangaList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, genre, description;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageViewManga);
            title = itemView.findViewById(R.id.titleManga);
            genre = itemView.findViewById(R.id.genreManga);
            description = itemView.findViewById(R.id.descManga);
        }
    }

    @NonNull
    @Override
    public MangaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_manga, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MangaAdapter.ViewHolder holder, int position) {
        Manga manga = mangaList.get(position);
        holder.title.setText(manga.title);
        holder.genre.setText(manga.genre);
        holder.description.setText(manga.description);
        holder.image.setImageResource(manga.imageResId);
    }

    @Override
    public int getItemCount() {
        return mangaList.size();
    }
}
