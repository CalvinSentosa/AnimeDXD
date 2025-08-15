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
        List<Integer> imageList = Arrays.asList(R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4, R.drawable.slide5);
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
        animeList.add(new AnimeItem(R.drawable.demonslayer, "DEMON SLAYER", 4, "Demon Slayer, atau Kimetsu no Yaiba...", "Horror"));
        animeList.add(new AnimeItem(R.drawable.haikyu_manga, "HAIKYU", 4, "Haikyuu bercerita tentang Shoyo Hinata...", "Sport"));
        animeList.add(new AnimeItem(R.drawable.jujutsu, "JUJUTSU KAISEN", 4, "Cerita tentang kutukan dan penyihir...", "Action"));
        animeList.add(new AnimeItem(R.drawable.demonslayer, "HUNTER X HUNTER", 4, "Hunter x Hunter, adalah hunter x hunter...", "Action"));
        animeList.add(new AnimeItem(R.drawable.demonslayer, "ONE PUNCH MAN", 3, "One punch man adalah anime...", "Comedy"));
        listRecyclerView.setAdapter(new AnimeListAdapter(requireContext(), animeList));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
}