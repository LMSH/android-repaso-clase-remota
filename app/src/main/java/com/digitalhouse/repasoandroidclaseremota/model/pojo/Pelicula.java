package com.digitalhouse.repasoandroidclaseremota.model.pojo;

import com.google.gson.annotations.SerializedName;

public class Pelicula {

    @SerializedName("poster_path")
    private String posterPeliculaUrl;
    @SerializedName("title")
    private String tituloPelicula;
    @SerializedName("overview")
    private String sinopsisPelicula;
    private String id;

    public Pelicula(String posterPeliculaUrl, String tituloPelicula, String sinopsisPelicula, String id) {
        this.posterPeliculaUrl = posterPeliculaUrl;
        this.tituloPelicula = tituloPelicula;
        this.sinopsisPelicula = sinopsisPelicula;
        this.id = id;
    }

    public Pelicula() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
