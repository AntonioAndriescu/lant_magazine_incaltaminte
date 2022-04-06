package org.example.Models;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement(name = "incaltaminte")
@XmlAccessorType (XmlAccessType.FIELD)
public class IncaltaminteFinal extends Incaltaminte {
    private Integer id;
    private Integer marime;
    private Integer cantitate;

    public IncaltaminteFinal(String producator, String denumire, float pret, boolean disponibilitate, Integer marime, Integer cantitate, Integer id) {
        super(producator, denumire, pret, disponibilitate);
        this.marime = marime;
        this.cantitate = cantitate;
        this.id = id;
    }

    public IncaltaminteFinal(IncaltaminteFinal incaltaminteFinal) {
        this.marime = incaltaminteFinal.marime;
        this.cantitate = incaltaminteFinal.cantitate;
        this.id = incaltaminteFinal.id;
    }

    public IncaltaminteFinal() {
    }

    public Integer getMarime() {
        return marime;
    }

    public void setMarime(Integer marime) {
        this.marime = marime;
    }

    public Integer getCantitate() {
        return cantitate;
    }

    public void setCantitate(Integer cantitate) {
        this.cantitate = cantitate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncaltaminteFinal that = (IncaltaminteFinal) o;
        return Objects.equals(id, that.id) && Objects.equals(marime, that.marime) && Objects.equals(cantitate, that.cantitate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marime, cantitate);
    }
}
