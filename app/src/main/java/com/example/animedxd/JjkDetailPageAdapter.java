package com.example.animedxd;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class JjkDetailPageAdapter extends FragmentStateAdapter {
    public JjkDetailPageAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new JjkSynopsisFragment();
            case 1: return new JjkReviewFragment();
            case 2: return new JjkClipFragment();
            default: return new JjkSynopsisFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
