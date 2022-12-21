package com.cdp.rcaja.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cdp.rcaja.R;
import com.cdp.rcaja.Ver_recibo;
import com.cdp.rcaja.entidades.Recibos;


import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ReciboViewHolder> {

    ArrayList<Recibos> listaRecibos;
    ArrayList<Recibos> listaOriginal;

    public Adaptador(ArrayList<Recibos> listaRecibos) {
        this.listaRecibos = listaRecibos;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaRecibos);
    }

    @NonNull
    @Override
    public ReciboViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_items_recibo, null, false);
        return new ReciboViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReciboViewHolder holder, int position) {
        holder.nombre.setText(listaRecibos.get(position).getNombreCliente());
        holder.correo.setText(listaRecibos.get(position).getNombreBanco());
        holder.estado.setText(listaRecibos.get(position).getEstado());
    }

    @Override
    public int getItemCount() {
        return listaRecibos.size();
    }

    //public void setItems(List<Recibos> items){mData=items;}

    public class ReciboViewHolder extends RecyclerView.ViewHolder {

        ImageView iconImage;
        TextView nombre,correo,estado;

        public ReciboViewHolder(@NonNull View itemView) {
            super(itemView);

            iconImage = itemView.findViewById(R.id.iconRecibo);
            nombre = itemView.findViewById(R.id.nameTextView);
            correo= itemView.findViewById(R.id.correoTextView);
            estado=itemView.findViewById(R.id.estadoTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Ver_recibo.class);
                    intent.putExtra("ID", listaRecibos.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}


