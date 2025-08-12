package com.example.animedxd;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HaikyuDetailPageAdapter extends FragmentStateAdapter {
    public HaikyuDetailPageAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new HaikyuSynopsisFragment();
            case 1: return new HaikyuReviewFragment();
            case 2: return new HaikyuClipFragment();
            default: return new HaikyuSynopsisFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
