package com.digitalhouse.repasoandroidclaseremota;

public class Pelicula {

    private String posterPeliculaUrl;
    private String tituloPelicula;
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
