package com.example.animedxd;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class DemonDetailPageAdapter extends FragmentStateAdapter {
    public DemonDetailPageAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new DemonSynopsisFragment();
            case 1: return new DemonReviewFragment();
            case 2: return new DemonClipFragment();
            default: return new DemonSynopsisFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
