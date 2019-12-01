package com.digitalhouse.repasoandroidclaseremota.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeliculaContainer {

    private Integer page;
    private Integer total_pages;
    @SerializedName("results")
    private List<Pelicula> listaDePeliculas;
    private Boolean yaNoHayMasPaginas = false;

    public PeliculaContainer(Integer page, Integer total_pages, List<Pelicula> listaDePeliculas) {
        this.page = page;
        this.total_pages = total_pages;
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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Boolean getYaNoHayMasPaginas() {
        return yaNoHayMasPaginas;
    }

    public void setYaNoHayMasPaginas(Boolean yaNoHayMasPaginas) {
        this.yaNoHayMasPaginas = yaNoHayMasPaginas;
    }
}
