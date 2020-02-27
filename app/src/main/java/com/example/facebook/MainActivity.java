package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

       ViewPager viewPager;

       MyFragmentAdapter adapter;
       TabLayout tabLayout;

        protected void onCreate(Bundle savedInstanceState){

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            viewPager = findViewById(R.id.fragment_pager);
            tabLayout = findViewById(R.id.tab1);

            adapter = new MyFragmentAdapter(getSupportFragmentManager());

           viewPager.setAdapter(adapter);
           tabLayout.setupWithViewPager(viewPager);
           //new
        }
    }

