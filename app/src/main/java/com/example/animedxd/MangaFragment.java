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
        mangaList.add(new Manga("DEMON SLAYER", "Fantasi Gelap", "Demon Slayer, atau Kimetsu no Yaiba, bercerita tentang Tanjiro Kamado, seorang pemuda yang keluarganya dibantai oleh iblis.", R.drawable.demonslayer));
        mangaList.add(new Manga("HAIKYUU", "Komedi", "Haikyuu bercerita tentang Shoyo Hinata, siswa SMA yang terinspirasi oleh \"Raksasa Kecil\" (The Little Giant) dan bertekad menjadi pemain voli terbaik.", R.drawable.haikyu_manga));
        mangaList.add(new Manga("JUJUTSU KAISEN", "Fantasi Gelap", "Jujutsu Kaisen adalah serial anime Jepang yang menceritakan Yuji Itadori, seorang siswa SMA yang secara tak sengaja menjadi wadah bagi roh kutukan terkuat bernama Ryomen Sukuna.", R.drawable.jujutsu));
        mangaList.add(new Manga("HUNTER X HUNTER", "Action", "Hunter x Hunter adalah cerita tentang seorang anak laki-laki bernama Gon Freecss yang ingin menjadi Hunter untuk menemukan ayahnya, Ging Freecss, seorang Hunter legendaris yang meninggalkannya sejak kecil.", R.drawable.hunterlist));
        mangaList.add(new Manga("ONE PUNCH MAN", "Comedy", "One Punch Man adalah kisah tentang Saitama, seorang pahlawan super yang mampu mengalahkan semua musuh dengan satu pukulan saja. Ia menjadi bosan karena kurangnya tantangan dalam kekuatan supernya.", R.drawable.onelist));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MangaAdapter(getContext(), mangaList));

        return view;
    }
}
