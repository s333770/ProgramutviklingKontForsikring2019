package sample.SkrivUt;

import sample.Kunde.Kunde;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SkrivUtDataJOBJ extends SkrivData {


    public SkrivUtDataJOBJ(Kunde skrivUt, File filType) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filType);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(skrivUt);
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void skrivUtDataJobj(Object hvaSomSkrives, String filvei) throws FileNotFoundException {


    }



}
