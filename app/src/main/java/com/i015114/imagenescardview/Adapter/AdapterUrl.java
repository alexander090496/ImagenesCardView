package com.i015114.imagenescardview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.i015114.imagenescardview.MainActivity;
import com.i015114.imagenescardview.Model.UrlDetails;
import com.i015114.imagenescardview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 4/10/2017.
 */

public class AdapterUrl extends RecyclerView.Adapter<AdapterUrl.ViewHolder> {
    List<UrlDetails> urlDetailsList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public AdapterUrl(List<UrlDetails> urlDetailsList, Context context) {
        this.urlDetailsList = urlDetailsList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Encargado de trabajar con el item.xml y sus componentes
        String a;
        holder.textViewtitle.setText(urlDetailsList.get(position).getTitle());
        holder.textViewurl.setText(urlDetailsList.get(position).getUrl1());
        a= urlDetailsList.get(position).getUrl1();
        Picasso.with(context).load(a).into(holder.imageViewcard);


    }

    @Override
    public int getItemCount() {
        return urlDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewtitle;
        TextView textViewurl;
        ImageView imageViewcard;
        public ViewHolder(View item) {
            super(item);
            item.setOnClickListener(this);
            textViewtitle = (TextView) item.findViewById(R.id.id_item_titulo);
            textViewurl = (TextView) item.findViewById(R.id.id_item_url);
            imageViewcard = (ImageView) item.findViewById(R.id.img_item_cardview);
        }

        @Override
        public void onClick(View view) {
            Context contextitem = view.getContext();
            Intent inten = new Intent(contextitem,MainActivity.class);
            contextitem.startActivity(inten);

            //Toast.makeText(context,"click en el item",Toast.LENGTH_SHORT).show();
        }
    }
}
