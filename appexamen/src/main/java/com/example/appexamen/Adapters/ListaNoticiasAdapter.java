package com.example.appexamen.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appexamen.FBObjetos.FBNoticia;
import com.example.appexamen.R;

import java.util.ArrayList;
import android.support.v7.widget.RecyclerView;
/**
 * Created by guille on 19/12/17.
 */

public class ListaNoticiasAdapter extends RecyclerView.Adapter<NoticiaViewHolder> {

    private ListaNoticiasAdapterListener listener;
    private ArrayList<FBNoticia> noticias;
    private Context mContext;

    public ListaNoticiasAdapter(ArrayList<FBNoticia> noticias, Context mContext){

        this.noticias=noticias;
        this.mContext=mContext;
    }
    public void setListener(ListaNoticiasAdapterListener listener){

        this.listener=listener;
    }


    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_noticia_layout,null);
        NoticiaViewHolder noticiaViewHolder= new NoticiaViewHolder(view);
        return noticiaViewHolder;
    }

    //DONDE SE VINCULA ENTRE LOS CONTENIDOS Y EL CONTENEDOR(CELDAVIEWHOLDER);

    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {
        // holder.textomensaje.setText(coches.get(position).original);

        //IMPORTANTE ME COGE FABRICADO POR QUE SE CREE QUE ES UN ID

        holder.tvnombre.setText(noticias.get(position).Nombre);
        holder.tvjuego.setText(noticias.get(position).Juego);


        Glide.with(mContext).load(noticias.get(position).imgurl)
             .into(holder.imgnoticia);

    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }
}

//MOLDE
class NoticiaViewHolder extends RecyclerView.ViewHolder{


    public TextView tvjuego;
    public TextView tvnombre;
    public ImageView imgnoticia;


    public NoticiaViewHolder(View itemView) {
        super(itemView);

        tvnombre=itemView.findViewById(R.id.tvnombre);
        tvjuego=itemView.findViewById(R.id.tvjuego);
        imgnoticia=itemView.findViewById(R.id.imgnoticias);

        //INICIALIZAMOS EL EVENTO
        NoticiaViewHolderEvents events= new NoticiaViewHolderEvents(this);
        itemView.setOnClickListener(events);
    }


}

class NoticiaViewHolderEvents implements View.OnClickListener{

    NoticiaViewHolder noticiaViewHolder;

    public NoticiaViewHolderEvents(NoticiaViewHolder noticiaViewHolder){
        this.noticiaViewHolder=noticiaViewHolder;

    }
    @Override
    public void onClick(View v) {

    }
}