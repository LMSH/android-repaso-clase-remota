package com.digitalhouse.repasoandroidclaseremota.model.pojo;

public class Detalle {

    private String original_title;
    private String overview;

    public Detalle(String original_title, String overview) {
        this.original_title = original_title;
        this.overview = overview;
    }

    public Detalle() {
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public String toString() {
        return "Detalle{" +
                "original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }
}
