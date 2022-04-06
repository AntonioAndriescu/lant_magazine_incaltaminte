package org.example.Presenter;

import org.example.GUI.*;
import org.example.Models.Persistenta.PersistentaUtilizator;
import org.example.Models.Utilizator;

import javax.xml.bind.JAXBException;

public class PresenterLogin {
    public static void verificareLogin(String s1, String s2) {
        try {
            for (Utilizator u : PersistentaUtilizator.unmarshal().getUtilizatori()) {
                if (s1.equals(u.getUsername()) && s2.equals(u.getParola()) && u.getFunctie().equals("administrator")) {
                    IAdministratorView v = new AdministratorView();
                    break;
                } else if (s1.equals(u.getUsername()) && s2.equals(u.getParola()) && u.getFunctie().equals("angajat")) {
                    IAngajatView v = new AngajatView();
                    break;
                } else {
                    System.out.println("Please enter valid username and password");
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
