package com.example.appexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.milib.LoginFragmentListener;
import com.example.milib.RegisterFragmentListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


class MainActivityEvents implements LoginFragmentListener, RegisterFragmentListener {
    MainActivity mainActivity;

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
}