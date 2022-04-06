package org.example.GUI;

import org.example.Models.Persistenta.PersistentaIncaltaminte;
import org.example.Presenter.PresenterUtilizator;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AngajatView implements IAngajatView {
    PresenterUtilizator presenterUtilizator;
    private JFrame frame = new JFrame();
    private JTable table;
    private JScrollPane sp;
    private JPanel panel = new JPanel();
    private TextField producator = new TextField();
    private TextField denumire = new TextField();
    private TextField pret = new TextField();
    private TextField id = new TextField();
    private TextField Marime = new TextField();
    private TextField cantitate = new TextField();
    private TextField disponibilitate = new TextField();
    private JLabel l1 = new JLabel("Producator:");
    private JLabel l2 = new JLabel("Denumire:");
    private JLabel l3 = new JLabel("Pret:");
    private JLabel l4 = new JLabel("id:");
    private JLabel l5 = new JLabel("Marime:");
    private JLabel l6 = new JLabel("Cantitate:");
    private JLabel l7 = new JLabel("Disponibilitate:");
    private JButton b1 = new JButton("Adaugare");
    private JButton b2 = new JButton("Stergere");
    private JButton b3 = new JButton("Vizualizare");
    private JButton b4 = new JButton("Actualizare");
    private JButton b5 = new JButton("Creare raport Json");
    private JButton b6 = new JButton("Creare raport CSV");
    private JLabel lfiltrare = new JLabel("Filtrare dupa:");
    private JTextField filtrare = new JTextField();
    private JButton fMarime = new JButton("Marime");
    private JButton fProducator = new JButton("Producator");
    private JButton fDisponibilitate = new JButton("Disponibilitate");

    public void setProducator(String s) {
        producator.setText(s);
    }

    public String getProducator() {
        return producator.getText();
    }

    public void setDenumire(String s) {
        denumire.setText(s);
    }

    public String getDenumire() {
        return denumire.getText();
    }

    public void setPret(Float f) {
        pret.setText(String.valueOf(f));
    }

    public Float getPret() {
        return Float.parseFloat(pret.getText());
    }

    public void setId(Integer s) {
        id.setText(String.valueOf(s));
    }

    public Integer getId() {
        return Integer.parseInt(id.getText());
    }

    public void setMarime(Integer s) {
        Marime.setText(String.valueOf(s));
    }

    public Integer getMarime() {
        return Integer.parseInt(Marime.getText());
    }

    public void setCantitate(Integer s) {
        cantitate.setText(String.valueOf(s));
    }

    public Integer getCantitate() {
        return Integer.parseInt(cantitate.getText());
    }

    public void setDisponibilitate(boolean value) {
        disponibilitate.setText(String.valueOf(value));
    }

    public boolean getDisponibilitate() {
        return Boolean.parseBoolean(disponibilitate.getText());
    }

    @Override
    public String[] getInformatiiRand() {
        String[] valori = new String[7];
        int randSelectat = table.getSelectedRow();
        for(int i = 0; i < table.getColumnCount(); i++) {
            valori[i] = String.valueOf(table.getValueAt(randSelectat, i));
        }
        return valori;
    }

    public AngajatView() {
        presenterUtilizator = new PresenterUtilizator(this);
        frame.setTitle("Angajat");
        frame.setBounds(300, 90, 1400, 550);
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

        producator.setFont(new Font("Arial", Font.PLAIN, 14));
        producator.setPreferredSize(new Dimension(180, 20));

        denumire.setFont(new Font("Arial", Font.PLAIN, 14));
        denumire.setPreferredSize(new Dimension(180, 20));

        pret.setFont(new Font("Arial", Font.PLAIN, 14));
        pret.setPreferredSize(new Dimension(180, 20));

        id.setFont(new Font("Arial", Font.PLAIN, 14));
        id.setPreferredSize(new Dimension(180, 20));

        Marime.setFont(new Font("Arial", Font.PLAIN, 14));
        Marime.setPreferredSize(new Dimension(180, 20));

        cantitate.setFont(new Font("Arial", Font.PLAIN, 14));
        cantitate.setPreferredSize(new Dimension(180, 20));

        disponibilitate.setFont(new Font("Arial", Font.PLAIN, 14));
        disponibilitate.setPreferredSize(new Dimension(180, 20));

        b1.setFont(new Font("Arial", Font.PLAIN, 14));
        b1.setPreferredSize(new Dimension(325, 30));

        b2.setFont(new Font("Arial", Font.PLAIN, 14));
        b2.setPreferredSize(new Dimension(325, 30));

        b3.setFont(new Font("Arial", Font.PLAIN, 14));
        b3.setPreferredSize(new Dimension(325, 30));

        b4.setFont(new Font("Arial", Font.PLAIN, 14));
        b4.setPreferredSize(new Dimension(325, 30));

        b5.setFont(new Font("Arial", Font.PLAIN, 14));
        b5.setPreferredSize(new Dimension(325, 30));

        b6.setFont(new Font("Arial", Font.PLAIN, 14));
        b6.setPreferredSize(new Dimension(325, 30));

        filtrare.setFont(new Font("Arial", Font.PLAIN, 14));
        filtrare.setPreferredSize(new Dimension(180, 20));

        lfiltrare.setFont(new Font("Arial", Font.PLAIN, 16));
        lfiltrare.setPreferredSize(new Dimension(140, 20));

        fProducator.setFont(new Font("Arial", Font.PLAIN, 14));
        fProducator.setPreferredSize(new Dimension(325, 30));

        fMarime.setFont(new Font("Arial", Font.PLAIN, 14));
        fMarime.setPreferredSize(new Dimension(325, 30));

        fDisponibilitate.setFont(new Font("Arial", Font.PLAIN, 14));
        fDisponibilitate.setPreferredSize(new Dimension(325, 30));

        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);

        frame.add(producator);
        frame.add(denumire);
        frame.add(pret);
        frame.add(id);
        frame.add(Marime);
        frame.add(cantitate);
        frame.add(disponibilitate);

        frame.add(b1);
        frame.add(b2);
        frame.add(b4);
        frame.add(b3);

        frame.add(filtrare);
        frame.add(lfiltrare);
        frame.add(fProducator);
        frame.add(fMarime);
        frame.add(fDisponibilitate);

        frame.add(b5);
        frame.add(b6);

        frame.setVisible(true);

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                frame.dispose();
                AngajatView v = new AngajatView();
                v.TabelProduse(PresenterUtilizator.vizualizare());
            }
        });

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    presenterUtilizator.adaugareXml();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    presenterUtilizator.stergereXml();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    presenterUtilizator.actualizareXml();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    PresenterUtilizator.raportJson();
                } catch (JAXBException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    PresenterUtilizator.raportCSV();
                } catch (JAXBException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        fMarime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                frame.dispose();
                AngajatView v = new AngajatView();
                try {
                    v.TabelProduse(PresenterUtilizator.searchMarime(Integer.parseInt(filtrare.getText())));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });

        fProducator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                frame.dispose();
                AngajatView v = new AngajatView();
                try {
                    v.TabelProduse(PresenterUtilizator.searchProducator(filtrare.getText()));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });

        fDisponibilitate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                frame.dispose();
                AngajatView v = new AngajatView();
                try {
                    v.TabelProduse(PresenterUtilizator.searchDisponibilitate(Boolean.parseBoolean(filtrare.getText())));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void TabelProduse(PersistentaIncaltaminte incaltaminteList) {
        String[] columnNames = {"Producator", "Denumire", "Pret", "Disponibilitate", "Marime", "Cantitate", "id"};
        table = new JTable(presenterUtilizator.creareTabel(incaltaminteList), columnNames);
        table.setFillsViewportHeight(true);
        sp = new JScrollPane(table);
        panel.add(sp);
        sp.setPreferredSize(new Dimension(1300, 300));
        frame.setVisible(true);
    }

    public static void main(String[] args) throws JAXBException {
        AngajatView v = new AngajatView();
    }
}
