package com.example.appexamen;

import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by guille on 19/12/17.
 */

public class SecondActivity extends AppCompatActivity {

}
class SecondActivityEvents implements FireBaseAdminListener{


    SecondActivity secondActivity;

    public SecondActivityEvents(SecondActivity secondActivity){
        this.secondActivity=secondActivity;

    }

    @Override
    public void firebaseAdmin_registerOk(boolean blOk) {

    }

    @Override
    public void firebaseAdmin_loginOk(boolean blOk) {

    }

    @Override
    public void firebaseAdmin_ramaDescargada(String rama, DataSnapshot dataSnapshot) {

    }
}