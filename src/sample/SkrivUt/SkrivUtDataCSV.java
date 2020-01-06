package sample.SkrivUt;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class SkrivUtDataCSV extends SkrivData  {


    public void skrivDataTilCSVFil(Object skrivdatatilCSVfil) throws FileNotFoundException {
        FileOutputStream fileOutputStream =new FileOutputStream("CSVArrangement.CSV",true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        printWriter.print(skrivdatatilCSVfil+",");
        printWriter.close();
    }
}
