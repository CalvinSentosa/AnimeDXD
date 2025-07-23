package com.example.animedxd;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Home extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView welcomeText = findViewById(R.id.welcomeText);
        String username = getIntent().getStringExtra("USERNAME");
        welcomeText.setText("Welcome, " + username);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(new TabAdapter(this));

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText("News");
                        tab.view.setContentDescription("News Tab");
                    } else {
                        tab.setText("Manga");
                        tab.view.setContentDescription("Manga Tab");
                    }
                }
        ).attach();

//        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
//
//        bottomNav.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.nav_home:
//                    // Stay here
//                    return true;
//                case R.id.nav_news:
//                    // You can change tab to News
//                    viewPager.setCurrentItem(0);
//                    return true;
//                case R.id.nav_profile:
//                    // Switch to Profile tab, or start new activity
//                    viewPager.setCurrentItem(1);
//                    return true;
//            }
//            return false;
//        });


    }
}
