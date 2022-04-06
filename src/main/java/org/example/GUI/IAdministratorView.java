package org.example.GUI;

import org.example.Models.Persistenta.PersistentaUtilizator;

public interface IAdministratorView {
    public String getNume();
    public void setNume(String nume);
    public String getPrenume();
    public void setPrenume(String prenume);
    public String getEmail();
    public void setEmail(String email);
    public String getFunctie();
    public void setFunctie(String functie);
    public Integer getIdMagazin();
    public void setIdMagazin(String idMagazin);
    public String getUsername();
    public void setUsername(String username);
    public String getParola();
    public void setParola(String parola);
    public String[] getInformatiiRand();
    public String getFiltru();
    public void TabelUtilizatori(PersistentaUtilizator utilizatorList);
}
