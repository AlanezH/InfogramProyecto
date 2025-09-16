package com.example.infogram;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.infogram.fragment.HomeFragment;
import com.example.infogram.fragment.ProfileFragment;
import com.example.infogram.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class containerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_container);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment;
                        if (item.getItemId() == R.id.search) {
                            selectedFragment = new SearchFragment();
                        } else if (item.getItemId() == R.id.home) {
                            selectedFragment = new HomeFragment();
                        } else if (item.getItemId() == R.id.profile) {
                            selectedFragment = new ProfileFragment();
                        } else {
                            return false;
                        }
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container_frame, selectedFragment)
                                .commit();
                        return true;
                    }
                });
    }
}