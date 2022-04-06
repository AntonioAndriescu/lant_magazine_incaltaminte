package org.example.Models.Persistenta;

import org.example.Models.Utilizator;

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

@XmlRootElement(name = "utilizatori")
@XmlAccessorType (XmlAccessType.FIELD)
public class PersistentaUtilizator {
    @XmlElement(name = "utilizator")
    private List<Utilizator> utilizatori = null;

    public List<Utilizator> getUtilizatori() {
        return utilizatori;
    }

    public void setUtilizatori(List<Utilizator> utilizatori) {
        this.utilizatori = utilizatori;
    }

    static PersistentaUtilizator utilizatoriList = new PersistentaUtilizator();
    static  {
        utilizatoriList.setUtilizatori(new ArrayList<Utilizator>());
    }

    public static void marshal() throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(org.example.Models.Persistenta.PersistentaUtilizator.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(utilizatoriList, new File("./utilizator.xml"));
    }

    public static PersistentaUtilizator unmarshal() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PersistentaUtilizator.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        PersistentaUtilizator emps = (PersistentaUtilizator) jaxbUnmarshaller.unmarshal( new File("./utilizator.xml") );
        return emps;
    }

    public static void addUtilizator(Utilizator utilizator) throws JAXBException {
        utilizatoriList = unmarshal();
        utilizatoriList.getUtilizatori().add(utilizator);
        marshal();
    }

    public static void removeUtilizator(Utilizator utilizator) throws JAXBException {
        utilizatoriList = unmarshal();
        for(Utilizator u : utilizatoriList.getUtilizatori()) {
            if(u.equals(utilizator)) {
                utilizatoriList.getUtilizatori().remove(u);
                break;
            }
        }
        marshal();
    }

    public static void updateUtilizator(Utilizator utilizator1, Utilizator utilizator2) throws JAXBException {
        utilizatoriList = unmarshal();
        for(Utilizator u : utilizatoriList.getUtilizatori()) {
            if(u.equals(utilizator1)) {
                u.setNume(utilizator2.getNume());
                u.setPrenume(utilizator2.getPrenume());
                u.setUsername(utilizator2.getUsername());
                u.setFunctie(utilizator2.getFunctie());
                u.setEmail(utilizator2.getEmail());
                u.setIdMagazin(utilizator2.getIdMagazin());
                u.setParola(utilizator2.getParola());
                break;
            }
        }
        marshal();
    }
}
