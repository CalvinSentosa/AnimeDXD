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
import androidx.viewpager2.widget.ViewPager2;

import java.util.Arrays;
import java.util.List;

public class NewsFragment extends Fragment {

    private ViewPager2 carouselViewPager;
    private Handler sliderHandler = new Handler(Looper.getMainLooper());
    private int currentIndex = 0;

    private final Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            if (carouselViewPager != null) {
                currentIndex = (currentIndex + 1) % 5;
                carouselViewPager.setCurrentItem(currentIndex, true);
                sliderHandler.postDelayed(this, 5000);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        carouselViewPager = view.findViewById(R.id.carouselViewPager);

        List<Integer> imageList = Arrays.asList(
                R.drawable.slide1,
                R.drawable.slide2,
                R.drawable.slide3,
                R.drawable.slide4,
                R.drawable.slide5
        );

        carouselViewPager.setAdapter(new CarouselAdapter(imageList));
        carouselViewPager.setOffscreenPageLimit(1);

        // Start auto-scroll
        sliderHandler.postDelayed(sliderRunnable, 5000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
}
