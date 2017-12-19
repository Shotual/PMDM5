package com.example.appexamen;

/**
 * Created by guille on 19/12/17.
 */

import com.google.firebase.database.DataSnapshot;


public interface FireBaseAdminListener {

    public void firebaseAdmin_registerOk(boolean blOk);
    public void firebaseAdmin_loginOk(boolean blOk);
    //no solo va a recbir la referencia de la rama si no tambien los datos de esa rama en dataSnapshot
    public void firebaseAdmin_ramaDescargada(String rama,DataSnapshot dataSnapshot );

}
