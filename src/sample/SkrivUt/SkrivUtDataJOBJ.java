package sample.SkrivUt;

import sample.Kunde.Kunde;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SkrivUtDataJOBJ extends SkrivData {


    public SkrivUtDataJOBJ(Object threadDone) {
        super();
    }

    PrintWriter pw;
    StringBuilder JOBJUt = new StringBuilder();
    List<String> JSONUt=new ArrayList<>();


    public SkrivUtDataJOBJ(File file, String fornavn, String etternavn, String telefonnummer, String email, String type, String pris) {

        try {
            pw=new PrintWriter(file);
           Kunde kunde = new Kunde(fornavn, etternavn, telefonnummer, email, type, pris);
           JSONUt.add("{ \n Fornavn: "+kunde.getFornavn());
            JSONUt.add(" \n EtterNavn: "+kunde.getEtternavn());
            JSONUt.add(" \n Email: "+kunde.getEmail());
            JSONUt.add(" \n Telefon: "+kunde.getTelefonnummer());
            JSONUt.add(" \n Type: "+kunde.getType());
            JSONUt.add(" \n Pris: "+kunde.getPris());
            JSONUt.add("\n }");
            System.out.println(JSONUt.toString());



       } catch (Exception e) {
           e.printStackTrace();
       }


    }
    @Override
    protected Object call() throws Exception {
        Thread.sleep(5000);
        System.out.println("Printing pågår");
        pw.println(JSONUt.toString());
        pw.close();

        return 0;
    }
}
