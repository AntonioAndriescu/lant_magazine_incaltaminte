package org.example.GUI;

import org.example.Models.Persistenta.PersistentaUtilizator;
import org.example.Presenter.PresenterAdministrator;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorView implements IAdministratorView {
    PresenterAdministrator presenter;
    private JFrame frame = new JFrame();
    private JTable table;
    private JScrollPane sp;
    private JPanel panel = new JPanel();
    private JTextField nume = new JTextField();
    private JTextField prenume = new JTextField();
    private JTextField email = new JTextField();
    private JTextField functie = new JTextField();
    private JTextField idMagazin = new JTextField();
    private JTextField username = new JTextField();
    private JTextField parola = new JTextField();
    private JLabel l1 = new JLabel("Nume:");
    private JLabel l2 = new JLabel("Prenume:");
    private JLabel l3 = new JLabel("Email:");
    private JLabel l4 = new JLabel("Functie:");
    private JLabel l5 = new JLabel("idMagazin:");
    private JLabel l6 = new JLabel("Username:");
    private JLabel l7 = new JLabel("Parola:");
    private JButton b1 = new JButton("Adaugare");
    private JButton b2 = new JButton("Stergere");
    private JButton b4 = new JButton("Actualizare");
    private JButton b3 = new JButton("Vizualizare");
    private JLabel lfiltrare = new JLabel("Filtrare dupa:");
    private JTextField filtrare = new JTextField();
    private JButton fNume = new JButton("Nume");
    private JButton fIdMagazin = new JButton("idMagazin");
    private JButton fFunctie = new JButton("Functie");

    public void setNume(String s) {
        nume.setText(s);
    }

    public String getNume() {
        return nume.getText();
    }

    public void setPrenume(String s) {
        prenume.setText(s);
    }

    public String getPrenume() {
        return prenume.getText();
    }

    public void setEmail(String s) {
        email.setText(s);
    }

    public String getEmail() {
        return email.getText();
    }

    public void setFunctie(String s) {
        functie.setText(s);
    }

    public String getFunctie() {
        return functie.getText();
    }

    public void setIdMagazin(String s) {
        idMagazin.setText(s);
    }

    public Integer getIdMagazin() {
        return Integer.parseInt(idMagazin.getText());
    }

    public void setUsername(String s) {
        username.setText(s);
    }

    public String getUsername() {
        return username.getText();
    }

    public void setParola(String s) {
        parola.setText(s);
    }

    public String getParola() {
        return parola.getText();
    }

    public String getFiltru() {
        return filtrare.getText();
    }

    @Override
    public String[] getInformatiiRand() {
        String[] valori = new String[7];
        int randSelectat = table.getSelectedRow();
        for (int i = 0; i < table.getColumnCount(); i++) {
            valori[i] = String.valueOf(table.getValueAt(randSelectat, i));
        }
        return valori;
    }

    public AdministratorView() {
        presenter = new PresenterAdministrator(this);
        frame.setTitle("Administrator");
        frame.setBounds(300, 90, 1400, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());

        panel.setLayout(new FlowLayout());
        frame.add(panel);

        l1.setFont(new Font("Arial", Font.PLAIN, 16));
        l1.setPreferredSize(new Dimension(180, 20));

        l2.setFont(new Font("Arial", Font.PLAIN, 16));
        l2.setPreferredSize(new Dimension(180, 20));

        l3.setFont(new Font("Arial", Font.PLAIN, 16));
        l3.setPreferredSize(new Dimension(180, 20));

        l4.setFont(new Font("Arial", Font.PLAIN, 16));
        l4.setPreferredSize(new Dimension(180, 20));

        l5.setFont(new Font("Arial", Font.PLAIN, 16));
        l5.setPreferredSize(new Dimension(180, 20));

        l6.setFont(new Font("Arial", Font.PLAIN, 16));
        l6.setPreferredSize(new Dimension(180, 20));

        l7.setFont(new Font("Arial", Font.PLAIN, 16));
        l7.setPreferredSize(new Dimension(180, 20));

        nume.setFont(new Font("Arial", Font.PLAIN, 14));
        nume.setPreferredSize(new Dimension(180, 20));

        prenume.setFont(new Font("Arial", Font.PLAIN, 14));
        prenume.setPreferredSize(new Dimension(180, 20));

        email.setFont(new Font("Arial", Font.PLAIN, 14));
        email.setPreferredSize(new Dimension(180, 20));

        functie.setFont(new Font("Arial", Font.PLAIN, 14));
        functie.setPreferredSize(new Dimension(180, 20));

        idMagazin.setFont(new Font("Arial", Font.PLAIN, 14));
        idMagazin.setPreferredSize(new Dimension(180, 20));

        username.setFont(new Font("Arial", Font.PLAIN, 14));
        username.setPreferredSize(new Dimension(180, 20));

        parola.setFont(new Font("Arial", Font.PLAIN, 14));
        parola.setPreferredSize(new Dimension(180, 20));

        b1.setFont(new Font("Arial", Font.PLAIN, 14));
        b1.setPreferredSize(new Dimension(325, 30));

        b2.setFont(new Font("Arial", Font.PLAIN, 14));
        b2.setPreferredSize(new Dimension(325, 30));

        b3.setFont(new Font("Arial", Font.PLAIN, 14));
        b3.setPreferredSize(new Dimension(325, 30));

        b4.setFont(new Font("Arial", Font.PLAIN, 14));
        b4.setPreferredSize(new Dimension(325, 30));

        filtrare.setFont(new Font("Arial", Font.PLAIN, 14));
        filtrare.setPreferredSize(new Dimension(180, 20));

        lfiltrare.setFont(new Font("Arial", Font.PLAIN, 16));
        lfiltrare.setPreferredSize(new Dimension(140, 20));

        fNume.setFont(new Font("Arial", Font.PLAIN, 14));
        fNume.setPreferredSize(new Dimension(325, 30));

        fFunctie.setFont(new Font("Arial", Font.PLAIN, 14));
        fFunctie.setPreferredSize(new Dimension(325, 30));

        fIdMagazin.setFont(new Font("Arial", Font.PLAIN, 14));
        fIdMagazin.setPreferredSize(new Dimension(325, 30));

        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);

        frame.add(nume);
        frame.add(prenume);
        frame.add(email);
        frame.add(functie);
        frame.add(idMagazin);
        frame.add(username);
        frame.add(parola);

        frame.add(b1);
        frame.add(b2);
        frame.add(b4);
        frame.add(b3);

        frame.add(filtrare);
        frame.add(lfiltrare);
        frame.add(fNume);
        frame.add(fFunctie);
        frame.add(fIdMagazin);

        frame.setVisible(true);

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                frame.dispose();
                AdministratorView v = new AdministratorView();
                v.TabelUtilizatori(PresenterAdministrator.vizualizare());
            }
        });

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    presenter.adaugareXml();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    presenter.stergereXml();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    presenter.actualizareXml();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });

        fNume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                frame.dispose();
                AdministratorView v = new AdministratorView();
                try {
                    v.TabelUtilizatori(PresenterAdministrator.searchNume(filtrare.getText()));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });

        fFunctie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                frame.dispose();
                AdministratorView v = new AdministratorView();
                try {
                    v.TabelUtilizatori(PresenterAdministrator.searchFunctie(filtrare.getText()));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });

        fIdMagazin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                frame.dispose();
                AdministratorView v = new AdministratorView();
                try {
                    v.TabelUtilizatori(PresenterAdministrator.searchIdMagazin(Integer.parseInt(filtrare.getText())));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void TabelUtilizatori(PersistentaUtilizator utilizatorList) {
        String[] columnNames = {"Nume", "Prenume", "Email", "Functie", "idMagazin", "Username", "Parola"};
        table = new JTable(presenter.creareTabel(utilizatorList), columnNames);
        table.setFillsViewportHeight(true);
        sp = new JScrollPane(table);
        panel.add(sp);
        sp.setPreferredSize(new Dimension(1300, 300));
        frame.setVisible(true);
    }

    public static void main( String[] args )
    {
        AdministratorView v = new AdministratorView();
    }
}
