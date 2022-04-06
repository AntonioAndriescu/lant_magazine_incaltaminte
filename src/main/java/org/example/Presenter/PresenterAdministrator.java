package org.example.Presenter;

import org.example.GUI.IAdministratorView;
import org.example.Models.Persistenta.PersistentaUtilizator;
import org.example.Models.Utilizator;

import javax.xml.bind.JAXBException;

public class PresenterAdministrator {
    private IAdministratorView adm;
    private static PersistentaUtilizator utilizatori = new PersistentaUtilizator();

    public PresenterAdministrator (IAdministratorView i) {
        adm = i;
    }

    public static PersistentaUtilizator vizualizare()  {
        try {
            utilizatori = PersistentaUtilizator.unmarshal();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return utilizatori;
    }

    public void adaugareXml() throws JAXBException {
        Utilizator u = new Utilizator(adm.getNume(), adm.getPrenume(), adm.getEmail(), adm.getFunctie(), adm.getIdMagazin(), adm.getUsername(), adm.getParola());
        PersistentaUtilizator.addUtilizator(u);
    }

    public void stergereXml() throws JAXBException {
        String[] s = adm.getInformatiiRand();
        Utilizator u = new Utilizator(s[0], s[1], s[2], s[3], Integer.parseInt(s[4]), s[5], s[6]);
        PersistentaUtilizator.removeUtilizator(u);
    }

    public void actualizareXml() throws JAXBException {
        String[] s = adm.getInformatiiRand();
        Utilizator u1 = new Utilizator(s[0], s[1], s[2], s[3], Integer.parseInt(s[4]), s[5], s[6]);
        Utilizator u2 = new Utilizator(adm.getNume(), adm.getPrenume(), adm.getEmail(), adm.getFunctie(), adm.getIdMagazin(), adm.getUsername(), adm.getParola());
        PersistentaUtilizator.updateUtilizator(u1, u2);
    }

    public static PersistentaUtilizator searchNume(String s) throws JAXBException {
        utilizatori = PersistentaUtilizator.unmarshal();
        utilizatori.getUtilizatori().removeIf(u -> !u.getNume().equals(s));
        return utilizatori;
    }

    public static PersistentaUtilizator searchFunctie(String s) throws JAXBException {
        utilizatori = PersistentaUtilizator.unmarshal();
        utilizatori.getUtilizatori().removeIf(u -> !u.getFunctie().equals(s));
        return utilizatori;
    }

    public static PersistentaUtilizator searchIdMagazin(Integer i) throws JAXBException {
        utilizatori = PersistentaUtilizator.unmarshal();
        utilizatori.getUtilizatori().removeIf(u -> !u.getIdMagazin().equals(i));
        return utilizatori;
    }

    public Object[][] creareTabel(PersistentaUtilizator utilizatorList) {
        int i = 0;
        int size = utilizatorList.getUtilizatori().size();
        Object[][] data = new Object[size][];
        for(Utilizator u : utilizatorList.getUtilizatori()) {
            data[i] = new Object[] {u.getNume(), u.getPrenume(), u.getEmail(), u.getFunctie(), u.getIdMagazin(), u.getUsername(), u.getParola()};
            i++;
        }
        return data;
    }
}
