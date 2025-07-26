package com.example.animedxd;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class DemonDetailActivity extends AppCompatActivity {

    String[] titles = {"Synopsis", "Review", "Clip"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demon_activity_detail);

        // Receive passed data (optional use in layout)
        String title = getIntent().getStringExtra("title");
        int imageResId = getIntent().getIntExtra("imageResId", R.drawable.demonslayer); // default fallback

        // Use this title/imageResId in any fragment if needed
        // e.g., pass to fragments via bundle if dynamic
    }

}
