package org.example.Presenter;

import org.example.GUI.IAngajatView;
import org.example.Models.IncaltaminteFinal;
import org.example.Models.Persistenta.PersistentaIncaltaminte;

import javax.xml.bind.JAXBException;

import java.io.IOException;

import static org.example.Raport.creareRaportCSV;
import static org.example.Raport.creareRaportJson;

public class PresenterUtilizator {
    private IAngajatView ang;
    private static PersistentaIncaltaminte incaltaminte = new PersistentaIncaltaminte();

    public PresenterUtilizator (IAngajatView i) {
        ang = i;
    }

    public static PersistentaIncaltaminte vizualizare() {
        try {
            incaltaminte = PersistentaIncaltaminte.unmarshal();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return incaltaminte;
    }

    public void adaugareXml() throws JAXBException {
        IncaltaminteFinal x = new IncaltaminteFinal(ang.getProducator(), ang.getDenumire(), ang.getPret(), ang.getDisponibilitate(), ang.getMarime(), ang.getCantitate(), ang.getId());
        PersistentaIncaltaminte.addIncaltaminte(x);
    }

    public void stergereXml() throws JAXBException {
        String[] s = ang.getInformatiiRand();
        IncaltaminteFinal x = new IncaltaminteFinal(s[0], s[1], Float.parseFloat(s[2]), Boolean.parseBoolean(s[3]), Integer.parseInt(s[4]), Integer.parseInt(s[5]), Integer.parseInt(s[6]));
        PersistentaIncaltaminte.removeIncaltaminte(x);
    }

    public void actualizareXml() throws JAXBException {
        String[] s = ang.getInformatiiRand();
        IncaltaminteFinal x1 = new IncaltaminteFinal(s[0], s[1], Float.parseFloat(s[2]), Boolean.parseBoolean(s[3]), Integer.parseInt(s[4]), Integer.parseInt(s[5]), Integer.parseInt(s[6]));
        IncaltaminteFinal x2 = new IncaltaminteFinal(ang.getProducator(), ang.getDenumire(), ang.getPret(), ang.getDisponibilitate(), ang.getMarime(), ang.getCantitate(), ang.getId());
        PersistentaIncaltaminte.updateIncaltaminte(x1, x2);
    }

    public Object[][] creareTabel(PersistentaIncaltaminte incaltaminteList) {
        int i = 0;
        int size = incaltaminteList.getIncaltamintep().size();
        Object[][] data = new Object[size][];
        for(IncaltaminteFinal x : incaltaminteList.getIncaltamintep()) {
            data[i] = new Object[] {x.getProducator(), x.getDenumire(), x.getPret(), x.getDisponibilitate(), x.getMarime(), x.getCantitate(), x.getId()};
            i++;
        }
        return data;
    }

    public static PersistentaIncaltaminte searchProducator(String s) throws JAXBException {
        incaltaminte = PersistentaIncaltaminte.unmarshal();
        incaltaminte.getIncaltamintep().removeIf(u -> !u.getProducator().equals(s));
        return incaltaminte;
    }

    public static PersistentaIncaltaminte searchDisponibilitate(Boolean b) throws JAXBException {
        incaltaminte = PersistentaIncaltaminte.unmarshal();
        incaltaminte.getIncaltamintep().removeIf(u -> u.getDisponibilitate() != b);
        return incaltaminte;
    }

    public static PersistentaIncaltaminte searchMarime(Integer i) throws JAXBException {
        incaltaminte = PersistentaIncaltaminte.unmarshal();
        incaltaminte.getIncaltamintep().removeIf(u -> !u.getMarime().equals(i));
        return incaltaminte;
    }

    public static void raportJson() throws JAXBException, IOException {
        incaltaminte = PersistentaIncaltaminte.unmarshal();
        creareRaportJson(incaltaminte);
    }

    public static void raportCSV() throws JAXBException, IOException {
        incaltaminte = PersistentaIncaltaminte.unmarshal();
        creareRaportCSV(incaltaminte);
    }
}
