 package com.example.guille.apptutorial;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.guille.apptutorial.Adapters.ListaCochesAdapter;
import com.example.guille.apptutorial.FBObjects.FBCoche;
import com.example.milib.GPSAdmin.GPSTracker;
import com.example.milib.ListaFragment;
import com.example.milib.DetallesFragment;
import com.example.milib.asynctasks.HttpAsyncTask;
import com.example.milib.asynctasks.HttpJsonAsyncTask;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


 public class  SecondActivity extends AppCompatActivity {

     ListaFragment listaFragmentCoches;
     ListaCochesAdapter listaCochesAdapter;
     SupportMapFragment mapFragment;
     DetallesFragment detallesFragment;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondActivityEvents events=new SecondActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);


        listaFragmentCoches =(ListaFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentListCoches);

         mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMapa);
         mapFragment.getMapAsync(events);
         detallesFragment =(DetallesFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentDetalles);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
       // transaction.show(listaFragmentMensajes);
        transaction.hide(listaFragmentCoches);
       transaction.hide(detallesFragment);
        transaction.show(mapFragment);
        transaction.commit();

         GPSTracker gpsTracker=new GPSTracker(this);

         if(gpsTracker.canGetLocation()){
            FBCoche fbCoche=new FBCoche(2017,"coche","renault",gpsTracker.getLatitude(),gpsTracker.getLongitude(),"");
            DataHolder.instance.fireBaseAdmin.insertarEnRama("/Coches/3",fbCoche.toMap());

             Map<String, Object> childUpdates = new HashMap<>();
             childUpdates.put("/Coches/3",fbCoche.toMap());

             String key = DataHolder.instance.fireBaseAdmin.generarKeySobreRama("/CochesConID/");
             childUpdates.put("/CochesConID/" + key, fbCoche.toMap());
             DataHolder.instance.fireBaseAdmin.insertarEnMultiRama(childUpdates);


         }else{
             gpsTracker.showSettingsAlert();
         }

        /* HttpAsyncTask httpAsyncTask=new HttpAsyncTask();
         httpAsyncTask.execute("https://images7.alphacoders.com/671/671281.jpg",
                 "https://www.google.es/imgres?imgurl=http%3A%2F%2Fwww.xlsemanal.com%2Fwp-content%2Fuploads%2Fsites%2F3%2F2017%2F07%2Fcapsulas-pastillas-colores.jpg&imgrefurl=http%3A%2F%2Fwww.xlsemanal.com%2Fconocer%2Fsalud%2F20170714%2Flo-desea-saber-las-pastillas.html&docid=wf_jkaUQIYun9M&tbnid=ENU7kPEoLir1RM%3A&vet=10ahUKEwjex6KipuvYAhUBWxQKHYdIDnEQMwhOKAAwAA..i&w=800&h=426&bih=736&biw=1440&q=pastillas&ved=0ahUKEwjex6KipuvYAhUBWxQKHYdIDnEQMwhOKAAwAA&iact=mrc&uact=8",
                 "https://www.google.es/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwiP_72ppuvYAhWG0RQKHZ04CXYQjRwIBw&url=http%3A%2F%2Fpastillasparaadelgazarfacil.com%2Fterocaps-funciona%2F&psig=AOvVaw3snxscAJkyembX6ToPJ2Pn&ust=1516701164491622",
                 "https://www.google.es/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwj28d22puvYAhVI6RQKHfL5AUwQjRwIBw&url=http%3A%2F%2Fwww.comoalargarelpene.info%2Fpastillas-para-agrandar-el-pene%2F&psig=AOvVaw3snxscAJkyembX6ToPJ2Pn&ust=1516701164491622",
                 "https://www.google.es/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwiS8qC9puvYAhUKPRQKHeBrAQ4QjRwIBw&url=https%3A%2F%2Fwww.muyinteresante.es%2Fsalud%2Fsexualidad%2Ffotos%2Flos-10-efectos-secundarios-mas-comunes-de-las-pastillas-anticonceptivas%2Fpastillas1&psig=AOvVaw3snxscAJkyembX6ToPJ2Pn&ust=1516701164491622");
*/

        //PASAMOS POR PARAMETRO EL NOMBRE DE LA RAMA QUE QUIERAS EN LA BASE DE DATOS DE FIREBASE
        //DataHolder.instance.fireBaseAdmin.descargarYObservarRama("mensajes");

         HttpJsonAsyncTask httpJsonAsyncTask=new HttpJsonAsyncTask();
         String url = String.format("http://api.openweathermap.org/data/2.5/weather?id=%s&appid=%s","3117732",DataHolder.instance.API_KEY );
         httpJsonAsyncTask.execute(url);

         HttpJsonAsyncTask httpJsonAsyncTask1=new HttpJsonAsyncTask();
         String url1 = String.format("http://10.0.2.2/pruebasJSON/leeJugadores.php");
         httpJsonAsyncTask1.execute(url1);

        Log.v("SecondActivity","--------EMAAAIL: "+DataHolder.instance.fireBaseAdmin.user.getEmail());


      /*  ArrayList<String> mdatos= new ArrayList<>();
        mdatos.add("MENSAJE1");
        mdatos.add("MENSAJE2");

        ListaMensajesAdapter listaMensajesAdapter = new ListaMensajesAdapter(mdatos);
        listaFragment.recyclerView.setAdapter(listaMensajesAdapter); */
    }

}


class SecondActivityEvents implements FireBaseAdminListener, OnMapReadyCallback , GoogleMap.OnMarkerClickListener{

    SecondActivity secondActivity;
    ListaCochesAdapter listaCochesAdapter;
    GoogleMap mMap;
    ArrayList<FBCoche> coches;

    public SecondActivityEvents(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;

    }


    @Override
    public void firebaseAdmin_registerOk(boolean blOk) {

    }

    @Override
    public void firebaseAdmin_loginOk(boolean blOk) {

    }

    public void quitarViejosPines(){
        if(coches!=null){
            for (int i=0;coches.size()<i;i++) {
                FBCoche cocheTemp=coches.get(i);
                if(cocheTemp.getMarker()!=null){
                    cocheTemp.getMarker().remove();
                }
            }
        }


    }

    public void agregarPinesCoches() {

        Log.v("PIN",  "--------MMAPP............"+mMap );

        for (int i=0;i<coches.size();i++) {
            FBCoche cocheTemp = coches.get(i);
            LatLng cochePos = new LatLng(cocheTemp.lat, cocheTemp.lon);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(cochePos);
            markerOptions.title(cocheTemp.Nombre);

            if(mMap!=null){
                Log.v("PIN",  "--------PINES............" );
                Marker marker=mMap.addMarker(markerOptions);
                cocheTemp.setMarker(marker);
                marker.setTag(cocheTemp);
                if(i==0)mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cochePos,7));
            }

        }
    }

    @Override
    public void firebaseAdmin_ramaDescargada(String rama, DataSnapshot dataSnapshot) {
        Log.v("RAMA", rama + "--------RAMA DESCARGADA............" + dataSnapshot);

      if (rama.equals("Coches")) {
           // quitarViejosPines();
            GenericTypeIndicator<ArrayList<FBCoche>> indicator = new GenericTypeIndicator<ArrayList<FBCoche>>() {
            };
            coches = dataSnapshot.getValue(indicator);
            //VALUES NO ES UN ARRAY LIST ES UN COLLECTIONS
            // Log.v("coches","COCHES CONTIENE: "+coches);

            //PARA TRANSFORMAR UN COLLECTION A UN ARRAY LIST HAY QUE HACER es new ArrayList<Mensaje>(msg.values())
            secondActivity.listaCochesAdapter = new ListaCochesAdapter(coches, secondActivity);
            secondActivity.listaFragmentCoches.recyclerView.setAdapter(secondActivity.listaCochesAdapter);

            agregarPinesCoches();
        }


    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        DataHolder.instance.fireBaseAdmin.descargarYObservarRama("Coches");
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        FBCoche coche=(FBCoche)marker.getTag();
        Log.v("SS","presiona "+coche.Nombre);

        secondActivity.detallesFragment.txtNombre.setText(coche.Nombre);
        secondActivity.detallesFragment.txtFabricado.setText(coche.Fabricado+"");
        secondActivity.detallesFragment.txtMarca.setText(coche.Marca);

        FragmentTransaction transaction = secondActivity.getSupportFragmentManager().beginTransaction();
        // transaction.show(listaFragmentMensajes);
        transaction.show(secondActivity.detallesFragment);
        transaction.commit();

        return false;
    }
}
