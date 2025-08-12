package com.example.animedxd;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HunterDetailPageAdapter extends FragmentStateAdapter {
    public HunterDetailPageAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new HunterSynopsisFragment();
            case 1: return new HunterReviewFragment();
            case 2: return new HunterClipFragment();
            default: return new HunterSynopsisFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
