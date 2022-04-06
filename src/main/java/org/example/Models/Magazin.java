package org.example.Models;

import java.util.List;

public class Magazin {
    private final String oras;
    private final String strada;
    private final Integer id;
    private List<Integer> listaIncaltaminte;

    public Magazin(Integer id, String oras, String strada, List<Integer> listaIncaltaminte) {
        this.oras = oras;
        this.strada = strada;
        this.listaIncaltaminte = listaIncaltaminte;
        this.id = id;
    }

    public String getOras() {
        return oras;
    }

    public String getStrada() {
        return strada;
    }

    public List<Integer> getListaIncaltaminte() {
        return listaIncaltaminte;
    }

    public Integer getId() {
        return id;
    }

    public void setListaIncaltaminte(List<Integer> listaIncaltaminte) {
        this.listaIncaltaminte = listaIncaltaminte;
    }
}
