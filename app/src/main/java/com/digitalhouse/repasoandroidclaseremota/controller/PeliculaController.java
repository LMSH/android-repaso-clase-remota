package com.digitalhouse.repasoandroidclaseremota.controller;

import com.digitalhouse.repasoandroidclaseremota.model.dao.DaoPeliculasInternet;
import com.digitalhouse.repasoandroidclaseremota.model.pojo.Detalle;
import com.digitalhouse.repasoandroidclaseremota.model.pojo.PeliculaContainer;
import com.digitalhouse.repasoandroidclaseremota.util.ResultListener;

public class PeliculaController {

    private DaoPeliculasInternet dao;
    private Integer paginaActual;
    private Boolean estaCargando;
    private Integer ultimaPaginaDisponible;

    public PeliculaController() {
        dao = new DaoPeliculasInternet();
        paginaActual = 1;
        estaCargando = false;
        ultimaPaginaDisponible = paginaActual+1;
    }

    public void traerPeliculasDeInternet(final ResultListener<PeliculaContainer> escuchadorDeLaVista) {
        if (!estaCargando && paginaActual <= ultimaPaginaDisponible) {
            estaCargando = true;
            dao.traerPeliculasDeInternet(new ResultListener<PeliculaContainer>() {
                @Override
                public void finish(PeliculaContainer results) {
                    ultimaPaginaDisponible = results.getTotal_pages();
                    if(paginaActual.equals(ultimaPaginaDisponible)){
                        results.setYaNoHayMasPaginas(true);
                    }
                    escuchadorDeLaVista.finish(results);
                    paginaActual++;
                    estaCargando = false;
                }
            }, paginaActual);
        }
    }

    public void traerUnaPeliculaPorId(final ResultListener<Detalle> escuchadorDeLaVista, String idDeLaPelicula) {
        dao.traerUnPeliculaPorId(new ResultListener<Detalle>() {
            @Override
            public void finish(Detalle results) {
                escuchadorDeLaVista.finish(results);
            }
        }, idDeLaPelicula);
    }
}