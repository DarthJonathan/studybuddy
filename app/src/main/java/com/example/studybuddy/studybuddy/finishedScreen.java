package com.example.studybuddy.studybuddy;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by JohnNate on 6/12/17.
 */

public class finishedScreen extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.finished_screen, container, false);

        ButterKnife.bind(this, view);

        return view;
    }
}
