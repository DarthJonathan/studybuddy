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

        one.setAnswer(1);
        one.setId(1);
        one.setQuestion("Apakah jeffry single");
        one.setAnswerOne("Yes");
        one.setAnswerTwo("No");
        one.setAnswerThree("IYESSS");
        one.setAnswerFour("NAWWW");

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
            newques.setQuestion("Dapid kentang ga?");
            newques.setAnswerOne("Selalu");
            newques.setAnswerTwo("Always");
            newques.setAnswerThree("Tidakpernah tidak");
            newques.setAnswerFour("Memang iya");
            newques.setAnswer(4);

        db.commitTransaction();
    }

}
