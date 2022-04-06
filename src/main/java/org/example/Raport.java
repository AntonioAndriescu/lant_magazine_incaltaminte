package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVWriter;
import org.example.Models.IncaltaminteFinal;
import org.example.Models.Persistenta.PersistentaIncaltaminte;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Raport {
    public static void creareRaportJson(PersistentaIncaltaminte incaltaminte) throws IOException {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter("./raport.json")) {
            g.toJson(incaltaminte.getIncaltamintep(), writer);
        }
    }

    public  static  void creareRaportCSV(PersistentaIncaltaminte incaltaminte) throws IOException {
        ArrayList<String[]> array = new ArrayList<>();
        String[] header = {"producator", "denumire", "pret", "disponibilitate", "marime", "cantitate", "id"};
        for(IncaltaminteFinal x: incaltaminte.getIncaltamintep()) {
            array.add(new String[] {x.getProducator(), x.getDenumire(), String.valueOf(x.getPret()), String.valueOf(x.getDisponibilitate()), String.valueOf(x.getMarime()), String.valueOf(x.getCantitate()), String.valueOf(x.getId())});
        }
        try(CSVWriter writer = new CSVWriter(new FileWriter("./raport.csv"))) {
            writer.writeAll(array);
        }
    }
}
