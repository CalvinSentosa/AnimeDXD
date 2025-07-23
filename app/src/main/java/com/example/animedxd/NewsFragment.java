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

        CarouselAdapter adapter = new CarouselAdapter(imageList);
        carouselViewPager.setAdapter(adapter);
        carouselViewPager.setOffscreenPageLimit(1);

        // Start from a large enough middle to allow both directions
        int startPosition = Integer.MAX_VALUE / 2;
        startPosition = startPosition - (startPosition % imageList.size()); // make it aligned
        carouselViewPager.setCurrentItem(startPosition, false);

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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
}

