package com.digitalhouse.repasoandroidclaseremota.model.dao;

import com.digitalhouse.repasoandroidclaseremota.model.pojo.Detalle;
import com.digitalhouse.repasoandroidclaseremota.model.pojo.Pelicula;
import com.digitalhouse.repasoandroidclaseremota.model.pojo.PeliculaContainer;
import com.digitalhouse.repasoandroidclaseremota.util.PeliculasService;
import com.digitalhouse.repasoandroidclaseremota.util.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DaoPeliculasInternet {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "35e3a62b4d3f69da7d3a732867d3e414";
    private Retrofit retrofit;
    private PeliculasService peliculasService;

    public DaoPeliculasInternet() {
        /* Copiado y pegado de la documentación
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);*/

        //Acomodado a nuestro gusto
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        peliculasService = retrofit.create(PeliculasService.class);
    }

    //Método que le permita al dao hacer esa búsqueda
    public void traerPeliculasDeInternet(final ResultListener<PeliculaContainer> escuchadorDelController){

        Call<PeliculaContainer> masPopularesCall = peliculasService.peliculasMasPopulares(API_KEY);

        masPopularesCall.enqueue(new Callback<PeliculaContainer>() {
            @Override
            public void onResponse(Call<PeliculaContainer> call, Response<PeliculaContainer> response) {
                PeliculaContainer body = response.body();
                escuchadorDelController.finish(body);
            }

            @Override
            public void onFailure(Call<PeliculaContainer> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    public void traerUnPeliculaPorId(final ResultListener<Detalle> escuchadorDelController, String idDeLaPelicula){
        Call<Detalle> detallePelicula = peliculasService.getUnaPelicula(idDeLaPelicula, API_KEY);

        detallePelicula.enqueue(new Callback<Detalle>() {
            @Override
            public void onResponse(Call<Detalle> call, Response<Detalle> response) {
                Detalle body = response.body();
                escuchadorDelController.finish(body);
            }

            @Override
            public void onFailure(Call<Detalle> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
