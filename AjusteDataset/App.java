package AjusteDataset;

import java.io.IOException;
import java.util.ArrayList;


class App {

    public static void main(String[] args) {        
        
        try {

            ReadWrite readWrite = new ReadWrite();

            // não alterei o dataset original só criei outro
            ArrayList<Board>  list = readWrite.read();
            readWrite.write(list, "test.csv");

            // para criar mais casos de empate
            ArrayList<Board> listInvert = new ArrayList();
            for (Board b : list) {
                if(b.getStatus() == "empate"){
                    Board board = new Board(b.invertido());
                    listInvert.add(board);
                }
            }            
            readWrite.write(listInvert, "empate-invetido.csv");

        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}