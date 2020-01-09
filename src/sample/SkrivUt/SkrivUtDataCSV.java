package sample.SkrivUt;

import javafx.concurrent.Task;
import sample.Kunde.Kunde;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkrivUtDataCSV extends SkrivData  {


    public SkrivUtDataCSV(Object threadDone) {
        super();
    }

    PrintWriter pw;

    public SkrivUtDataCSV(File file, String fornavn, String etternavn, String telefonnummer, String email, String type, String pris) {
        try {
            pw=new PrintWriter(file);
            StringBuilder csvUT = new StringBuilder();
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
        pw.
        Thread.sleep(5000);
        System.out.println("Hello world");
        return 0;
    }
}
