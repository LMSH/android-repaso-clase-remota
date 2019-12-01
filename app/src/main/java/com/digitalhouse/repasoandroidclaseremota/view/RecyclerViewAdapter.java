package com.digitalhouse.repasoandroidclaseremota.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.digitalhouse.repasoandroidclaseremota.R;
import com.digitalhouse.repasoandroidclaseremota.model.pojo.Pelicula;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PeliculasViewHolder> {

    public static final String IMAGEN_BASE_URL = "http://image.tmdb.org/t/p/original";
    private List<Pelicula> peliculaList;
    private EscuchadorCelda escuchadorCelda;

    public RecyclerViewAdapter(List<Pelicula> peliculaList, EscuchadorCelda escuchadorCelda) {
        this.peliculaList = peliculaList;
        this.escuchadorCelda = escuchadorCelda;
    }

    public void agregarPaginaDePeliculas(List<Pelicula> peliculaList){
        //this.peliculaList = peliculaList; //Ya no quiero que reemplace la lista
        this.peliculaList.addAll(peliculaList);
        notifyDataSetChanged();
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

        public PeliculasViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageViewCelda = itemView.findViewById(R.id.imagenPelicula);
            textViewTituloPelicula = itemView.findViewById(R.id.tituloPelicula);
            textViewSinopsisPelicula = itemView.findViewById(R.id.sinopsisPelicula);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Pelicula pelicula = peliculaList.get(getAdapterPosition());
                    escuchadorCelda.eligieronUnaCelda(pelicula);
                }
            });
        }

        public void bindPelicula(Pelicula unaPelicula){
            //ImageView -> Necesito utilizar Glide
            Glide.with(itemView)
                    .load(IMAGEN_BASE_URL+unaPelicula.getPosterPeliculaUrl())
                    .into(imageViewCelda);
            textViewTituloPelicula.setText(unaPelicula.getTituloPelicula());
            textViewSinopsisPelicula.setText(unaPelicula.getSinopsisPelicula());
        }
    }

    public interface EscuchadorCelda{
        public void eligieronUnaCelda(Pelicula laPeliculaSeleccionada);
    }
}
