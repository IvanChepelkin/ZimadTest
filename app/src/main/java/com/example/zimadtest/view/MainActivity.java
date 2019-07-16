package com.example.zimadtest.view;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
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
    private FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    private FragmentManager fm;
    private Fragment active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        dogsListFragment = new DogsListFragment();
        catsListFragment = new CatsListFragment();

        fm = getSupportFragmentManager();

        active = dogsListFragment;

        fm.beginTransaction().add(R.id.fragment_content, catsListFragment, "2").hide(catsListFragment).commit();
        fm.beginTransaction().add(R.id.fragment_content, dogsListFragment, "1").commit();


        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fm.beginTransaction().hide(active).show(dogsListFragment).commit();
                    active = dogsListFragment;
                    return true;
                case R.id.navigation_dashboard:
                    fm.beginTransaction().hide(active).show(catsListFragment).commit();
                    active = catsListFragment;
                    return true;
            }
            return false;
        }
    };

}
