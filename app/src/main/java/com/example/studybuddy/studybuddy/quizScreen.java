package com.example.studybuddy.studybuddy;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JohnNate on 6/12/17.
 */

public class quizScreen extends Fragment{

    @BindView(R.id.question)
    TextView question;

    @BindView(R.id.questionNumber)
    TextView questionNumber;

    @BindView(R.id.ansOne)
    TextView firstAnswer;

    @BindView(R.id.asTwo)
    TextView secondAnswer;

    @BindView(R.id.ansThree)
    TextView thirdAnswer;

    @BindView(R.id.ansFour)
    TextView fourAnswer;

    private int right;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quiz_screen, container, false);

        ButterKnife.bind(this, view);

        String ques = getArguments().getString("question");
        String number = getArguments().getString("quesNum");
        String ans1 = getArguments().getString("ans1");
        String ans2 = getArguments().getString("ans2");
        String ans3 = getArguments().getString("ans3");
        String ans4 = getArguments().getString("ans4");

        right = getArguments().getInt("right");

        question.setText(ques);
        questionNumber.setText(number);
        firstAnswer.setText(ans1);
        secondAnswer.setText(ans2);
        thirdAnswer.setText(ans3);
        fourAnswer.setText(ans4);

        return view;
    }

    @OnClick(R.id.ans1btn)
    public void answerOne ()
    {
        if(right == 1)
        {
            QuizController.getInstance().right();
        }else
        {
            QuizController.getInstance().wrong();
        }
    }

    @OnClick(R.id.ans2btn)
    public void answerTwo ()
    {
        if(right == 2)
        {
            QuizController.getInstance().right();
        }else
        {
            QuizController.getInstance().wrong();
        }
    }

    @OnClick(R.id.ans3btn)
    public void answeThree ()
    {
        if(right == 3)
        {
            QuizController.getInstance().right();
        }else
        {
            QuizController.getInstance().wrong();
        }
    }

    @OnClick(R.id.ans4btn)
    public void answerFour ()
    {
        if(right == 4)
        {
            QuizController.getInstance().right();
        }else
        {
            QuizController.getInstance().wrong();
        }
    }


}
