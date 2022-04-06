package org.example.Models.Persistenta;

import org.example.Models.IncaltaminteFinal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.*;

@XmlRootElement(name = "incaltamintep")
@XmlAccessorType (XmlAccessType.FIELD)
public class PersistentaIncaltaminte {
    @XmlElement(name = "incaltaminte")
    private List<IncaltaminteFinal> incaltaminte;

    public List<IncaltaminteFinal> getIncaltamintep() {
        return incaltaminte;
    }

    public void setIncaltamintep(List<IncaltaminteFinal> incaltaminte) {
        this.incaltaminte = incaltaminte;
    }

    static PersistentaIncaltaminte incaltaminteList = new PersistentaIncaltaminte();
    static  {
        incaltaminteList.setIncaltamintep(new ArrayList<IncaltaminteFinal>());
    }

    public static void marshal() throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(org.example.Models.Persistenta.PersistentaIncaltaminte.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(incaltaminteList, new File("./incaltaminte.xml"));
    }

    public static PersistentaIncaltaminte unmarshal() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PersistentaIncaltaminte.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        PersistentaIncaltaminte shoes = (PersistentaIncaltaminte) jaxbUnmarshaller.unmarshal(new File("./incaltaminte.xml"));
        return shoes;
    }

    public static void addIncaltaminte(IncaltaminteFinal incaltaminte) throws JAXBException {
        incaltaminteList = unmarshal();
        incaltaminteList.getIncaltamintep().add(incaltaminte);
        marshal();
    }

    public static void removeIncaltaminte(IncaltaminteFinal incaltaminte) throws  JAXBException {
        incaltaminteList = unmarshal();
        for(IncaltaminteFinal x : incaltaminteList.getIncaltamintep()) {
            if(x.equals(incaltaminte)) {
                incaltaminteList.getIncaltamintep().remove(x);
                break;
            }
        }
        marshal();
    }

    public static void updateIncaltaminte(IncaltaminteFinal incaltaminte1, IncaltaminteFinal incaltaminte2) throws  JAXBException {
        incaltaminteList = unmarshal();
        for(IncaltaminteFinal x : incaltaminteList.getIncaltamintep()) {
            if(x.equals(incaltaminte1)) {
                x.setProducator(incaltaminte2.getProducator());
                x.setDenumire(incaltaminte2.getDenumire());
                x.setId(incaltaminte2.getId());
                x.setMarime(incaltaminte2.getMarime());
                x.setPret(incaltaminte2.getPret());
                x.setCantitate(incaltaminte2.getCantitate());
                x.setDisponibilitate(incaltaminte2.getDisponibilitate());
                break;
            }
        }
        marshal();
    }
}

