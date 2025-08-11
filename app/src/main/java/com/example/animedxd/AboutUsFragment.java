package com.example.animedxd;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

// AboutUsFragment.java
public class AboutUsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aboutus, container, false);

        TextView welcomeText = view.findViewById(R.id.welcomeText);
        String username = getActivity().getIntent().getStringExtra("USERNAME");
        welcomeText.setText("Welcome, " + username);

        ImageView iconMenu = view.findViewById(R.id.iconMenu);
        LinearLayout logoutContainer = view.findViewById(R.id.logoutContainer);

        iconMenu.setOnClickListener(v -> {
            if (logoutContainer.getVisibility() == View.VISIBLE) {
                logoutContainer.setVisibility(View.INVISIBLE);
            } else {
                logoutContainer.setVisibility(View.VISIBLE);
            }
        });

        logoutContainer.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });

        return view;
    }
}