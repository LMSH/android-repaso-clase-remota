package com.digitalhouse.repasoandroidclaseremota.util;

import com.digitalhouse.repasoandroidclaseremota.model.pojo.PeliculaContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PeliculasService {

    @GET("movie/popular")
    Call<PeliculaContainer> peliculasMasPopulares(@Query("api_key") String apiKey);

}
