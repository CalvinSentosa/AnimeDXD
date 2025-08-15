package com.example.animedxd;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFragment extends Fragment {

    private ViewPager2 carouselViewPager;
    private Handler sliderHandler = new Handler(Looper.getMainLooper());

    private final Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            if (carouselViewPager != null) {
                int nextItem = carouselViewPager.getCurrentItem() + 1;
                carouselViewPager.setCurrentItem(nextItem, true);
                sliderHandler.postDelayed(this, 5000);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listpage, container, false);

        ViewPager2 carouselViewPager = view.findViewById(R.id.carouselViewPager2);
        List<Integer> imageList = Arrays.asList(R.drawable.carousel1,
                                                R.drawable.carousel2,
                                                R.drawable.carousel3,
                                                R.drawable.carousel4,
                                                R.drawable.carousel5);
        CarouselAdapter adapter = new CarouselAdapter(imageList);
        carouselViewPager.setAdapter(adapter);

        // Set fake middle position
        int startPosition = Integer.MAX_VALUE / 2;
        // Align to imageList size
        startPosition = startPosition - (startPosition % imageList.size());
        carouselViewPager.setCurrentItem(startPosition, false);

        // Optional: Auto-scroll after delay
        Handler sliderHandler = new Handler(Looper.getMainLooper());
        Runnable sliderRunnable = () -> {
            int nextItem = carouselViewPager.getCurrentItem() + 1;
            carouselViewPager.setCurrentItem(nextItem);
        };

        // Start auto-scroll after 5 seconds
        sliderHandler.postDelayed(sliderRunnable, 5000);

        // Restart handler after manual scroll
        carouselViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 5000);
            }
        });

        // Setup list
        RecyclerView listRecyclerView = view.findViewById(R.id.animeRecyclerView);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Example data for the list
        List<AnimeItem> animeList = new ArrayList<>();
        animeList.add(new AnimeItem(R.drawable.demonlist, "DEMON SLAYER", 4, "Demon Slayer, atau Kimetsu no Yaiba, bercerita tentang Tanjiro Kamado, seorang pemuda yang keluarganya dibantai oleh iblis.", "Horror"));
        animeList.add(new AnimeItem(R.drawable.haikyuulist, "HAIKYU", 4, "Haikyuu bercerita tentang Shoyo Hinata, siswa SMA yang terinspirasi oleh \"Raksasa Kecil\" (The Little Giant) dan bertekad menjadi pemain voli terbaik.", "Sport"));
        animeList.add(new AnimeItem(R.drawable.jujutsulist, "JUJUTSU KAISEN", 4, "Jujutsu Kaisen adalah serial anime Jepang yang menceritakan Yuji Itadori, seorang siswa SMA yang secara tak sengaja menjadi wadah bagi roh kutukan terkuat bernama Ryomen Sukuna.", "Action"));
        animeList.add(new AnimeItem(R.drawable.hunterlist, "HUNTER X HUNTER", 4, "Hunter x Hunter adalah cerita tentang seorang anak laki-laki bernama Gon Freecss yang ingin menjadi Hunter untuk menemukan ayahnya, Ging Freecss, seorang Hunter legendaris yang meninggalkannya sejak kecil.", "Action"));
        animeList.add(new AnimeItem(R.drawable.onelist, "ONE PUNCH MAN", 3, "One Punch Man adalah kisah tentang Saitama, seorang pahlawan super yang mampu mengalahkan semua musuh dengan satu pukulan saja. Ia menjadi bosan karena kurangnya tantangan dalam kekuatan supernya.", "Comedy"));
        listRecyclerView.setAdapter(new AnimeListAdapter(requireContext(), animeList));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
}