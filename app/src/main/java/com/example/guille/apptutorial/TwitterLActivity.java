package com.example.guille.apptutorial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.guille.apptutorial.sqliteadmin.Contact;
import com.example.guille.apptutorial.sqliteadmin.DatabaseHandler;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.DatabaseReference;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class TwitterLActivity extends AppCompatActivity {

    TwitterLoginButton loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Twitter.initialize(this);
        setContentView(R.layout.activity_twitter_l);


        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {

                Log.v("ELMAS", "me he logeado");

                // Do something with result, which provides a TwitterSession for making API calls
            }

            @Override
            public void failure(TwitterException exception) {

                Log.v("ELMAS", "no me he logeado"+exception);
                // Do something on failure
            }
        });

        DatabaseHandler databaseHandler=new DatabaseHandler(this);
        Contact contact=new Contact(4,"Yony333", "999999");

        databaseHandler.addContact(contact);
        //Contact contact1=databaseHandler.getContact(0);
        Log.v("DDBB","------>>>>>"+databaseHandler.getAllContacts());
/*
        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("JF82J7aL3L0lt08aJZnwTq9Wy", "Xwk1TXyTZCvedQ7B3V7BkKF2apFJNsdzCYinHvlcmkWvkQTuny"))
                .debug(true)
                .build();
        Twitter.initialize(config);
        FirebaseCrash.log("SECOND ACTIVITY created");

*/


        FirebaseCrash.report(new Exception("My first Android non-fatal error"));
        FirebaseCrash.log("SECOND ACTIVITY created");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
