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

        // Setup carousel
        carouselViewPager = view.findViewById(R.id.carouselViewPager2);
        List<Integer> imageList = Arrays.asList(
                R.drawable.slide1,
                R.drawable.slide2,
                R.drawable.slide3,
                R.drawable.slide4,
                R.drawable.slide5
        );
        CarouselAdapter carouselAdapter = new CarouselAdapter(imageList);
        carouselViewPager.setAdapter(carouselAdapter);
        carouselViewPager.setOffscreenPageLimit(1);

        int startPosition = Integer.MAX_VALUE / 2;
        startPosition = startPosition - (startPosition % imageList.size());
        carouselViewPager.setCurrentItem(startPosition, false);

        CarouselAdapter adapter = new CarouselAdapter(imageList);
        carouselViewPager.setAdapter(adapter);
        carouselViewPager.setOffscreenPageLimit(1);

        // Prevent parent from intercepting touch (for tab swipe conflict)
        carouselViewPager.getChildAt(0).setOnTouchListener((v, event) -> {
            carouselViewPager.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        });

        // Auto-scroll every 5 seconds
        sliderHandler.postDelayed(sliderRunnable, 5000);

        // Reset auto-scroll after manual swipe
        carouselViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 5000);
            }
        });

//
        // Setup list
        RecyclerView listRecyclerView = view.findViewById(R.id.animeRecyclerView);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Example data for the list
        List<AnimeItem> animeList = new ArrayList<>();
        animeList.add(new AnimeItem(R.drawable.demonslayer, "DEMON SLAYER", 4, "Demon Slayer, atau Kimetsu no Yaiba...", "Horror"));
        animeList.add(new AnimeItem(R.drawable.haikyuu, "HAIKYUU", 4, "Haikyuu bercerita tentang Shoyo Hinata...", "Sport"));
        animeList.add(new AnimeItem(R.drawable.jujutsu, "JUJUTSU KAISEN", 4, "Cerita tentang kutukan dan penyihir...", "Action"));
        listRecyclerView.setAdapter(new AnimeListAdapter(animeList));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
}