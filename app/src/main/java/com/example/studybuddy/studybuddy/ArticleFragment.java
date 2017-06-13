package com.example.studybuddy.studybuddy;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Jeff on 6/10/2017.
 */

public class ArticleFragment extends Fragment implements View.OnClickListener, FragmentChangeListener{
    @BindView(R.id.lblTitle)
    TextView lblTitle;
    @BindView(R.id.underline)
    RelativeLayout underline;
    @BindView(R.id.pContent1)
    TextView pContent1;
    @BindView(R.id.pContent2)
    TextView pContent2;
    @BindView(R.id.pContent3)
    TextView pContent3;
    @BindView(R.id.imgContent4)
    ImageView imgContent4;
    @BindView(R.id.pContent5)
    TextView pContent5;
    @BindView(R.id.pContent6)
    TextView pContent6;
    @BindView(R.id.pContent7)
    TextView pContent7;
    @BindView(R.id.pContent8)
    TextView pContent8;
    @BindView(R.id.pContent9)
    TextView pContent9;
    @BindView(R.id.imgContent10)
    ImageView imgContent10;
    @BindView(R.id.pContent11)
    TextView pContent11;
    @BindView(R.id.pContent12)
    TextView pContent12;
    @BindView(R.id.underlineEnd)
    RelativeLayout underlineEnd;
    @BindView(R.id.lblEnd)
    TextView lblEnd;
    @BindView(R.id.btnQuiz)
    Button btnQuiz;

    private Unbinder unbinder;

    Button btnquiz;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article, container, false);
        unbinder = ButterKnife.bind(this, view);

        btnquiz = (Button)view.findViewById(R.id.btnQuiz);
        btnquiz.setOnClickListener(this);

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

        switch (view.getId()){
            case R.id.btnQuiz:
            {
                QuizController controller = new QuizController();
                controller.setManager(getFragmentManager());
                controller.show();
                controller.setInstance(controller.thisInstance());
            }break;
        }
    }

}
