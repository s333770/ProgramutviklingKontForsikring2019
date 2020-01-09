package sample.SkrivUt;

import sample.Kunde.Kunde;

import java.io.*;

public class SkrivUtDataJOBJ extends SkrivData {


    public SkrivUtDataCSV(Object threadDone) {
        super();
    }

    PrintWriter pw;
    StringBuilder csvUT = new StringBuilder();

    public SkrivUtDataCSV(File file, String fornavn, String etternavn, String telefonnummer, String email, String type, String pris) {
        try {
            pw=new PrintWriter(file);

            Kunde kunde = new Kunde(fornavn, etternavn, telefonnummer,email,type,pris);
            csvUT.append(kunde.getFornavn());
            csvUT.append(',');
            csvUT.append(kunde.getEtternavn());
            csvUT.append(',');
            csvUT.append(kunde.getEmail());
            csvUT.append(',');
            csvUT.append(kunde.getTelefonnummer());
            csvUT.append(',');
            csvUT.append(kunde.getType());
            csvUT.append(',');
            csvUT.append(kunde.getPris());
            pw.println(csvUT);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected Object call() throws Exception {
        Thread.sleep(5000);
        System.out.println("Printing pågår");
        pw.println(csvUT);
        return 0;
    }
}
