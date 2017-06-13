package com.example.studybuddy.studybuddy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studybuddy.studybuddy.realm.Question;

import butterknife.ButterKnife;

/**
 * Created by JohnNate on 6/12/17.
 */

public class rightAns extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.right_answer, container, false);

        ButterKnife.bind(this, view);

        return view;
    }
}
