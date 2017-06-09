package com.example.studybuddy.studybuddy;

import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.pageFragment) Fragment pageFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(pageFrag!=null){
            if(savedInstanceState!=null){
                return;
            }
            HomeFragment homeFragment = new HomeFragment();
            homeFragment.setArguments(getIntent().getExtras());

            android.app.FragmentTransaction fragTran = getFragmentManager().beginTransaction();
            fragTran.add(R.id.pageFragment,homeFragment);
            fragTran.commit();

            //getSupportFragmentManager().beginTransaction().add(R.id.pageFragment,homeFragment).commit();
        }
    }
    //Button test = (Button)findViewById(R.id.btnProgramming);


}
