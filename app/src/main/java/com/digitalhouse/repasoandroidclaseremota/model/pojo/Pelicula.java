package com.digitalhouse.repasoandroidclaseremota.model.pojo;

import com.google.gson.annotations.SerializedName;

public class Pelicula {

    @SerializedName("poster_path")
    private String posterPeliculaUrl;
    @SerializedName("title")
    private String tituloPelicula;
    @SerializedName("overview")
    private String sinopsisPelicula;

    public Pelicula(String posterPeliculaUrl, String tituloPelicula, String sinopsisPelicula) {
        this.posterPeliculaUrl = posterPeliculaUrl;
        this.tituloPelicula = tituloPelicula;
        this.sinopsisPelicula = sinopsisPelicula;
    }

    public Pelicula() {
    }


    public String getPosterPeliculaUrl() {
        return posterPeliculaUrl;
    }

    public void setPosterPeliculaUrl(String posterPeliculaUrl) {
        this.posterPeliculaUrl = posterPeliculaUrl;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public String getSinopsisPelicula() {
        return sinopsisPelicula;
    }

    public void setSinopsisPelicula(String sinopsisPelicula) {
        this.sinopsisPelicula = sinopsisPelicula;
    }
}
