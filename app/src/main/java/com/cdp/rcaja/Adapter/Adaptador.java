package com.cdp.rcaja.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cdp.rcaja.R;
import com.cdp.rcaja.entidades.Recibos;


import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private List<Recibos> mData;
    private LayoutInflater mInflater;
    private Context context;

    public Adaptador(List<Recibos> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){ return mData.size(); }

    @Override
    public Adaptador.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.activity_lista_recibos,null);
        return new Adaptador.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Adaptador.ViewHolder holder,final int position){
        holder.binData(mData.get(position));
    }

    public void setItems(List<Recibos> items){mData=items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView nombre,correo,estado;

        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconRecibo);
            nombre = itemView.findViewById(R.id.nameTextView);
            correo= itemView.findViewById(R.id.correoTextView);
            estado=itemView.findViewById(R.id.estadoTextView);
        }

        void binData(final Recibos item){
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombre.setText(item.getNombreCliente());
            correo.setText(item.getCorreo_electornico());
            estado.setText(item.getEstado());
        }

    }
}


