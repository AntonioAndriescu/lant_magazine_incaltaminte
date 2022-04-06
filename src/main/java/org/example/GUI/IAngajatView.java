package org.example.GUI;

import org.example.Models.Persistenta.PersistentaIncaltaminte;

public interface IAngajatView {
    public void setProducator(String s);
    public String getProducator();
    public void setDenumire(String s);
    public String getDenumire();
    public void setPret(Float f);
    public Float getPret();
    public void setId(Integer s);
    public Integer getId();
    public void setMarime(Integer s);
    public Integer getMarime();
    public void setCantitate(Integer s);
    public Integer getCantitate();
    public void setDisponibilitate(boolean value);
    public boolean getDisponibilitate();
    public String[] getInformatiiRand();
    public void TabelProduse(PersistentaIncaltaminte incaltaminteList);
}
