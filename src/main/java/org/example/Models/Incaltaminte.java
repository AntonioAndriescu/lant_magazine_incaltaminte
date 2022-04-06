package org.example.Models;

public class Incaltaminte {
    private String producator;
    private String denumire;
    private float pret;
    private boolean disponibilitate;

    public Incaltaminte(String producator, String denumire, float pret, boolean disponibilitate) {
        this.producator = producator;
        this.denumire = denumire;
        this.pret = pret;
        this.disponibilitate = disponibilitate;
    }

    public Incaltaminte (Incaltaminte incaltaminte) {
        this.producator = incaltaminte.producator;
        this.denumire = incaltaminte.denumire;
        this.pret = incaltaminte.pret;
        this.disponibilitate = incaltaminte.disponibilitate;
    }

    public Incaltaminte () {
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public String getProducator() {
        return producator;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public float getPret() {
        return pret;
    }

    public void setDisponibilitate(boolean disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    public boolean getDisponibilitate() {
        return disponibilitate;
    }
}
