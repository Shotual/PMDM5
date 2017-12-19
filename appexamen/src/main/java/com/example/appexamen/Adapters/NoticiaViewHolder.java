package com.example.appexamen.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appexamen.R;

/**
 * Created by guille on 19/12/17.
 */

public class NoticiaViewHolder extends RecyclerView.ViewHolder{

    public ListaNoticiasAdapterListener listener;
    public TextView tvjuego;
    public TextView tvnombre;
    public ImageView imgnoticia;

    public void setListener(ListaNoticiasAdapterListener listener){

        this.listener=listener;
    }

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
        noticiaViewHolder.listener.ListaNoticiasAdapterCeldaClick (noticiaViewHolder);

    }
}