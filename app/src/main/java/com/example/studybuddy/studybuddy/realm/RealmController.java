package com.example.studybuddy.studybuddy.realm;

import android.util.Log;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by JohnNate on 6/12/17.
 */

public class RealmController {

    public static Realm db = Realm.getDefaultInstance();

    public static void addNew ()
    {
        //insert into db try
        db.beginTransaction();

        Question one = db.createObject(Question.class);

        one.setAnswer(3);
        one.setId(1);
        one.setQuestion("Why study programming language concept?");
        one.setAnswerOne("Learn better to express feeling");
        one.setAnswerTwo("To learn other languages difficulty");
        one.setAnswerThree("To better choose the programming language we need!");
        one.setAnswerFour("To use the language I never known");

        db.commitTransaction();
    }

    public static void displayAll ()
    {
        RealmResults<Question> results1 =
                db.where(Question.class).findAll();

        for(Question c:results1) {
            Log.d("results1", c.getQuestion());
        }
    }

    public static void storeNew ()
    {
        db.beginTransaction();

            Question newques = db.createObject(Question.class);

            newques.setId(2);
            newques.setQuestion("Which is not the the criteria of evaluating a programming language?");
            newques.setAnswerOne("Readability");
            newques.setAnswerTwo("Reability");
            newques.setAnswerThree("Writability");
            newques.setAnswerFour("Opportunity");
            newques.setAnswer(2);

        db.commitTransaction();
    }

}
