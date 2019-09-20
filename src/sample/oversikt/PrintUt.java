package sample.oversikt;

import javafx.concurrent.Task;

public class PrintUt extends Task<Void>{

    @Override
    protected Void call() throws Exception {

        try{
            Thread.sleep(3000);
            System.out.println("hello");
        }
        catch (InterruptedException e){
            System.err.println(e);
        }
        return null;
    }
}
