package AjusteDataset;

import java.io.IOException;
import java.util.ArrayList;


class App {

    public static void main(String[] args) {        
        
        try {

            ReadWrite readWrite = new ReadWrite();

            // não alterei o dataset original só criei outro
            ArrayList<Board>  list = readWrite.read("tic-tac-toe.csv");
            readWrite.write(list, "test.csv");

            // para criar mais casos de empate
            ArrayList<Board> listInvert = new ArrayList<>();
            for (Board b : list) {
                if(b.getStatus() == "empate"){
                    Board board = new Board(b.invertido());
                    listInvert.add(board);
                }
            }            
            readWrite.write(listInvert, "empate-invetido.csv");

            // para criar casos de jogo ainda em andamento
            ArrayList<Board> listEmAndamento= new ArrayList<>();
            for (Board b : list) {
                if(b.getStatus() == "ganhou"){
                    var aux = b.emAndamento();
                    if(aux != null){
                        Board board = new Board(aux);                    
                        listEmAndamento.add(board);
                    }                    
                }
            }
            readWrite.write(listEmAndamento, "jogando2.csv");

        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}