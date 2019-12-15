package sample;

import javafx.concurrent.Task;
import sample.Kunde.Kunde;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SkrivUt extends Task<> {


    public static void skrivData(String filepath, String fornavn, String etternavn,String telefonNummer, String email,String type, String pris ){
        try {
            Thread.sleep(3000);
            FileWriter fileWriter=new FileWriter(filepath);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            PrintWriter printWriter=new PrintWriter(bufferedWriter);
            printWriter.print(fornavn+","+etternavn+","+telefonNummer+","+email+","+type+","+pris);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void call() throws Exception {

    }
}
