package com.digitalhouse.repasoandroidclaseremota.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeliculaContainer {

    @SerializedName("results")
    private List<Pelicula> listaDePeliculas;

    public PeliculaContainer(List<Pelicula> listaDePeliculas) {
        this.listaDePeliculas = listaDePeliculas;
    }

    public PeliculaContainer() {
    }

    public List<Pelicula> getListaDePeliculas() {
        return listaDePeliculas;
    }

    public void setListaDePeliculas(List<Pelicula> listaDePeliculas) {
        this.listaDePeliculas = listaDePeliculas;
    }
}
