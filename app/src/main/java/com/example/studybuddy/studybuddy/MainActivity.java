package com.example.studybuddy.studybuddy;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements FragmentChangeListener{
    @BindView(R.id.btnCategory)
    Button btnCategory;
    @BindView(R.id.btnUpload)
    Button btnUpload;
    @BindView(R.id.btnStatistics)
    Button btnStatistics;

    HomeFragment homeFragment;
    EmptyCategory emptyCategory;
    ComingSoon comingSoon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            return;
        }
        homeFragment = new HomeFragment();
        homeFragment.setArguments(getIntent().getExtras());
        emptyCategory = new EmptyCategory();
        emptyCategory.setArguments(getIntent().getExtras());
        comingSoon = new ComingSoon();
        comingSoon.setArguments(getIntent().getExtras());

        android.app.FragmentTransaction fragTran = getFragmentManager().beginTransaction();
        fragTran.add(R.id.fragment_container,homeFragment);
        fragTran.commit();
    }

    @Override
    public void replaceFragment(Fragment fragment){
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName,0);

        if(!fragmentPopped) {
            android.app.FragmentTransaction fragTran = manager.beginTransaction();
            fragTran.replace(R.id.fragment_container,fragment);
            fragTran.setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragTran.addToBackStack(backStateName);
            fragTran.commit();
        }
    }

    @OnClick(R.id.btnCategory)
    void btnCategory(View view){
        replaceFragment(homeFragment);
    }

    @OnClick(R.id.btnUpload)
    void btnUpload(View view){
        replaceFragment(comingSoon);
    }

    @OnClick(R.id.btnStatistics)
    void btnStatistics(View view){
        replaceFragment(emptyCategory);
    }


}
