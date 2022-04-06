package org.example.Models;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement(name = "utilizator")
@XmlAccessorType(XmlAccessType.FIELD)
public class Utilizator {
    private String nume;
    private String prenume;
    private String email;
    private String functie; //angajat sau administrator
    private Integer idMagazin;
    private String username;
    private String parola;

    public Utilizator(String nume, String prenume, String email,  String functie, Integer idMagazin,  String username, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.functie = functie;
        this.idMagazin = idMagazin;
        this.username = username;
        this.parola = parola;
    }

    public Utilizator(Utilizator utilizator) {
        this.nume = utilizator.nume;
        this.prenume = utilizator.prenume;
        this.email = utilizator.email;
        this.idMagazin = utilizator.idMagazin;
        this.functie = utilizator.functie;
        this.username = utilizator.username;
        this.parola = utilizator.parola;
    }

    public Utilizator() {
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public String getFunctie() {
        return functie;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getParola() {
        return parola;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Integer getIdMagazin() {
        return idMagazin;
    }

    public void setIdMagazin(Integer idMagazin) {
        this.idMagazin = idMagazin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizator that = (Utilizator) o;
        return nume.equals(that.nume) && prenume.equals(that.prenume) && email.equals(that.email) && functie.equals(that.functie) && idMagazin.equals(that.idMagazin) && username.equals(that.username) && parola.equals(that.parola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, email, functie, idMagazin, username, parola);
    }
}
