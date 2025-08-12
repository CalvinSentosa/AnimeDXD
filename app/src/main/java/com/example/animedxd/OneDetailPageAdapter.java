package com.example.animedxd;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class OneDetailPageAdapter extends FragmentStateAdapter {
    public OneDetailPageAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new OneSynopsisFragment();
            case 1: return new OneReviewFragment();
            case 2: return new OneClipFragment();
            default: return new OneSynopsisFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
