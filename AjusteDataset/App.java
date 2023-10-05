package AjusteDataset;

import java.io.IOException;
import java.util.ArrayList;


class App {

    public static void main(String[] args) {        
        
        try {
            ReadWrite readWrite = new ReadWrite();

            ArrayList<Board>  list = readWrite.read();
            readWrite.write(list);

        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}