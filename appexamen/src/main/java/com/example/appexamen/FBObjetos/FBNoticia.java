package com.example.appexamen.FBObjetos;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by guille on 19/12/17.
 */
@IgnoreExtraProperties
public class FBNoticia {

    public String Juego;
    public String Nombre;
    public String imgurl;

    public FBNoticia(){

    }

    public FBNoticia(String Juego,String Nombre, String imgurl){
        this.Juego=Juego;
        this.Nombre=Nombre;
        this.imgurl=imgurl;

    }
}
