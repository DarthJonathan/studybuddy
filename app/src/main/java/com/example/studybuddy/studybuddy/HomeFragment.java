package com.example.studybuddy.studybuddy;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Jeff on 6/9/2017.
 */

public class HomeFragment extends Fragment implements View.OnClickListener, FragmentChangeListener{
    @BindView(R.id.btnProgramming) Button btnProgramming;
    @BindView(R.id.btnMath) Button btnMath;
    @BindView(R.id.btnPhysics) Button btnPhysics;
    private Unbinder unbinder;

    Button btnProg,btnMat,btnPhy;

    ArticleFragment articleFragment;
    EmptyCategory emptyCategory;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        articleFragment = new ArticleFragment();
        emptyCategory = new EmptyCategory();

        btnProg = (Button)view.findViewById(R.id.btnProgramming);
        btnMat = (Button)view.findViewById(R.id.btnMath);
        btnPhy = (Button)view.findViewById(R.id.btnPhysics);

        btnProg.setOnClickListener(this);
        btnMat.setOnClickListener(this);
        btnPhy.setOnClickListener(this);

        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName,0);

        if(!fragmentPopped) {
            View container = (View) getActivity().findViewById(R.id.fragment_container);
            android.app.FragmentTransaction fragTran = manager.beginTransaction();
            fragTran.replace(container.getId(), fragment);
            fragTran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragTran.addToBackStack(backStateName);
            fragTran.commit();
        }
    }

    public void test(CharSequence text){
        Context context = getActivity();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public void onClick(View view) {

        //coba toast
        switch (view.getId()){
            case R.id.btnProgramming:replaceFragment(articleFragment);break;
            case R.id.btnMath:replaceFragment(emptyCategory); break;
            case R.id.btnPhysics:replaceFragment(emptyCategory);break;
        }
    }
}
