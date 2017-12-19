package com.example.appexamen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.example.appexamen.Adapters.ListaNoticiasAdapter;
import com.example.appexamen.FBObjetos.FBNoticia;
import com.example.milib.ListaFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by guille on 19/12/17.
 */

public class SecondActivity extends AppCompatActivity {
  ListaFragment listaFragmentNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondActivityEvents events=new SecondActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);

        listaFragmentNoticias =(ListaFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentListNoticias);


        //PASAMOS POR PARAMETRO EL NOMBRE DE LA RAMA QUE QUIERAS EN LA BASE DE DATOS DE FIREBASE
        DataHolder.instance.fireBaseAdmin.descargarYObservarRama("Noticias");


        Log.v("SecondActivity","--------EMAAAIL: "+DataHolder.instance.fireBaseAdmin.user.getEmail());


      /*  ArrayList<String> mdatos= new ArrayList<>();
        mdatos.add("MENSAJE1");
        mdatos.add("MENSAJE2");

        ListaMensajesAdapter listaMensajesAdapter = new ListaMensajesAdapter(mdatos);
        listaFragment.recyclerView.setAdapter(listaMensajesAdapter); */
    }

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
        Log.v("RAMA",rama+"--------RAMA DESCARGADA............"+dataSnapshot);

        if(rama.equals("Noticias")){

            GenericTypeIndicator<ArrayList<FBNoticia>> indicator=new GenericTypeIndicator<ArrayList<FBNoticia>>(){};
            ArrayList<FBNoticia> noticias=dataSnapshot.getValue(indicator);
            //VALUES NO ES UN ARRAY LIST ES UN COLLECTIONS
            Log.v("noticias","noticias CONTIENE: "+noticias);

            //PARA TRANSFORMAR UN COLLECTION A UN ARRAY LIST HAY QUE HACER es new ArrayList<Mensaje>(msg.values())
            ListaNoticiasAdapter listaNoticiasAdapter=new ListaNoticiasAdapter(noticias,secondActivity);
            secondActivity.listaFragmentNoticias.recyclerView.setAdapter(listaNoticiasAdapter);
        }
    }
}