package com.example.studybuddy.studybuddy;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Jeff on 6/9/2017.
 */

public class EmptyCategory extends Fragment{
    @BindView(R.id.lblNothing)
    TextView lblNothing;
    @BindView(R.id.imgTry)
    ImageView imgTry;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.empty_category,container,false);
        unbinder = ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        unbinder.unbind();
    }

}
