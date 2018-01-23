package com.example.guille.apptutorial;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by guille on 17/12/17.
 */

public class DataHolder {
    public static DataHolder instance = new DataHolder();

    public FireBaseAdmin fireBaseAdmin;
    public String API_KEY="03408e06b3d1acd722c783abf5f4da71";



    public DataHolder(){
        fireBaseAdmin=new FireBaseAdmin();
      ;
    }
}
