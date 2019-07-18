package com.example.zimadtest.view;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.example.zimadtest.R;
import com.example.zimadtest.view.cat_view.CatsListFragment;
import com.example.zimadtest.view.dog_view.DogsListFragment;

public class MainActivity extends AppCompatActivity {

    private DogsListFragment dogsListFragment;
    private CatsListFragment catsListFragment;
    private FragmentManager fm;
    private Fragment active;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews(savedInstanceState);
        bindWidgetsWithAnEvent();
    }


    private void initViews(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            dogsListFragment = new DogsListFragment();
            catsListFragment = new CatsListFragment();

            fm = getSupportFragmentManager();

            active = dogsListFragment;

            fm.beginTransaction().add(R.id.fragment_content, catsListFragment, "2").hide(catsListFragment).commit();
            fm.beginTransaction().add(R.id.fragment_content, dogsListFragment, "1").commit();
        }

        tabLayout = findViewById(R.id.tabLayout);
    }

    private void bindWidgetsWithAnEvent() {
        tabLayout.addTab(tabLayout.newTab().setText(R.string.dog_text), true);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.cat_teaxt));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (tab.getPosition()) {
                    case 0:
                        fm.beginTransaction().hide(active).show(dogsListFragment).commit();
                        active = dogsListFragment;
                        break;

                    case 1:
                        fm.beginTransaction().hide(active).show(catsListFragment).commit();
                        active = catsListFragment;
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
