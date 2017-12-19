package com.example.appexamen;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.milib.LoginFragment;
import com.example.milib.LoginFragmentListener;
import com.example.milib.RegisterFragment;
import com.example.milib.RegisterFragmentListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    LoginFragment loginFragment;
    RegisterFragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment=(LoginFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentLogin );

        MainActivityEvents mainActivityEvents= new MainActivityEvents(this);
        loginFragment.setListener(mainActivityEvents);
        registerFragment.setListener(mainActivityEvents);
        DataHolder.instance.fireBaseAdmin.setListener(mainActivityEvents);


    }
}


class MainActivityEvents implements LoginFragmentListener, RegisterFragmentListener, FireBaseAdminListener {
    
    MainActivity mainActivity;

    public MainActivityEvents(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }

    @Override
    public void registerFragmentRegisterButtonAceptarClicked(String sUser, String sPass) {

    }

    @Override
    public void registerFragmentRegisterButtonCancelarClicked() {

    }

    @Override
    public void loginFragmentLoginButtonClicked(String sUser, String sPass) {

    }

    @Override
    public void loginFragmentRegisterButtonClicked() {

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