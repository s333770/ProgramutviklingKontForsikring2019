package sample.SkrivUt;

import javafx.concurrent.Task;

import java.io.File;

public abstract class SkrivData extends Task {

    public static String getFileExtension(String fullName) {
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

}

