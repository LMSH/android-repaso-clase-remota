package com.digitalhouse.repasoandroidclaseremota;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PeliculasViewHolder> {

    private List<Pelicula> peliculaList;

    public RecyclerViewAdapter(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
    }

    @NonNull
    @Override
    public PeliculasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_pelicula,parent,false);
        PeliculasViewHolder peliculasViewHolder = new PeliculasViewHolder(view);
        return peliculasViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculasViewHolder holder, int position) {
        Pelicula pelicula = peliculaList.get(position);
        PeliculasViewHolder peliculasViewHolder = holder;
        peliculasViewHolder.bindPelicula(pelicula);
    }

  /* Si yo le especifico el tipo de ViewHolder que agarra el adapter no hace falta este casteo, porque el atributo viene del tipo de mi ViewHolder
  @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Pelicula pelicula = peliculaList.get(position);
        PeliculasViewHolder peliculasViewHolder = (PeliculasViewHolder) holder;
        peliculasViewHolder.bindPelicula(pelicula);
    }*/

    @Override
    public int getItemCount() {
        return peliculaList.size();
    }


    public class PeliculasViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewCelda;
        private TextView textViewTituloPelicula;
        private TextView textViewSinopsisPelicula;

        public PeliculasViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCelda = itemView.findViewById(R.id.imagenPelicula);
            textViewTituloPelicula = itemView.findViewById(R.id.tituloPelicula);
            textViewSinopsisPelicula = itemView.findViewById(R.id.sinopsisPelicula);
        }

        public void bindPelicula(Pelicula unaPelicula){
            //ImageView -> Necesito utilizar Glide
            Glide.with(itemView)
                    .load(unaPelicula.getPosterPeliculaUrl())
                    .into(imageViewCelda);
            textViewTituloPelicula.setText(unaPelicula.getTituloPelicula());
            textViewSinopsisPelicula.setText(unaPelicula.getSinopsisPelicula());
        }
    }
}
