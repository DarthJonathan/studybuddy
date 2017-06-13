package com.example.studybuddy.studybuddy;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.studybuddy.studybuddy.realm.Question;
import com.example.studybuddy.studybuddy.realm.RealmController;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by JohnNate on 6/12/17.
 */

public class QuizController{

    private FragmentManager manager;
    private int rightAnswered = 0, total=0, counter=0;

    private rightAns rightans = new rightAns();
    private wrongAns wrongans = new wrongAns();
    private finishedScreen finish = new finishedScreen();

    ArrayList<Question> ques = new ArrayList<>();

    private static volatile QuizController instance;

    public void setManager(FragmentManager manager)
    {
        this.manager = manager;
    }

    private void replaceFragment(Fragment fragment, Bundle bundle){
        String backStateName = fragment.getClass().getName();

        boolean fragmentPopped = manager.popBackStackImmediate(backStateName,0);

        if(!fragmentPopped) {
            fragment.setArguments(bundle);
            android.app.FragmentTransaction fragTran = manager.beginTransaction();
            fragTran.replace(R.id.fragment_container,fragment);
            fragTran.setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragTran.commit();
        }
    }

    public void show()
    {
        RealmResults<Question> results1 =
                RealmController.db.where(Question.class).findAll();

        for(Question q:results1)
        {
            ques.add(q);
            total++;
        }

        showQuestions();
    }

    public void showQuestions ()
    {
        if(total == counter)
        {
            replaceFragment(finish, null);
        }else
        {
            quizScreen quizsc = new quizScreen();
            Bundle args = new Bundle();

            Question question = ques.get(counter);

            args.putString("question", question.getQuestion());
            args.putString("quesNum", (counter+1) + ".");
            args.putString("ans1", question.getAnswerOne());
            args.putString("ans2", question.getAnswerTwo());
            args.putString("ans3", question.getAnswerThree());
            args.putString("ans4", question.getAnswerFour());
            args.putInt("right", question.getAnswer());

            replaceFragment(quizsc, args);
        }
    }

    public static QuizController getInstance()
    {
        if(instance != null)
        {
            return instance;
        }else
        {
            return null;
        }
    }

    public void setInstance (QuizController in)
    {
        this.instance = in;
    }

    public QuizController thisInstance()
    {
        return this;
    }

    public void right ()
    {
        rightAnswered++;
        counter++;
        replaceFragment(rightans, null);
        System.out.println(counter);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showQuestions();
            }
        }, 1500);
    }

    public void wrong ()
    {
        counter++;
        replaceFragment(wrongans, null);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showQuestions();
            }
        }, 1500);
    }
}
