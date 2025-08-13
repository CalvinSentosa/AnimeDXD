package com.example.animedxd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MangaFragment extends Fragment {
    private RecyclerView recyclerView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manga, container, false);
        recyclerView = view.findViewById(R.id.recyclerManga);

        List<Manga> mangaList = new ArrayList<>();
        mangaList.add(new Manga("DEMON SLAYER", "Fantasi Gelap", "Demon Slayer, atau Kimetsu no Yaiba...", R.drawable.demonslayer));
        mangaList.add(new Manga("HAIKYUU", "Komedi", "Haikyuu bercerita tentang Shoyo Hinata...", R.drawable.haikyuu));
        mangaList.add(new Manga("JUJUTSU KAISEN", "Fantasi Gelap", "Cerita tentang kutukan dan penyihir...", R.drawable.jujutsu));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MangaAdapter(getContext(), mangaList));

        return view;
    }
}
