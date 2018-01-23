package com.example.guille.apptutorial.FBObjects;

import com.google.android.gms.maps.model.Marker;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guille on 18/12/17.
 */
@IgnoreExtraProperties
public class FBCoche {

    public int Fabricado;
    public String Marca;
    public String Nombre;
    public double lat;
    public double lon;
    public String imgurl;

    private Marker marker=null;

    public FBCoche(){

    }

    public FBCoche(int Fabricado,String Marca,String Nombre,double lat,double lon, String imgurl){
        this.Fabricado=Fabricado;
        this.Marca=Marca;
        this.Nombre=Nombre;
        this.lat=lat;
        this.lon=lon;
        this.imgurl=imgurl;

    }

    public void setMarker(Marker marker){
        this.marker=marker;
    }
    public Marker getMarker(){
        return marker;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("Fabricado", Fabricado);
        result.put("Marca", Marca);
        result.put("Nombre", Nombre);
        result.put("lat:", lat);
        result.put("lon", lon);
        result.put("imgurl", imgurl);


        return result;
    }

}

