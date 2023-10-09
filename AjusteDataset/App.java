package AjusteDataset;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


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
            //ArrayList<Board>  listEmAndamento = readWrite.read("jogando2.csv");
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
            readWrite.write(listEmAndamento, "jogando3.csv");
            

            ArrayList<Board>  listEmpatesConteridos = readWrite.read("so-empates.csv");
            for(int i = 0; i < 10000; i++ ){
                Board boardEmpate = criaBoardEmpate();
                
                if(boardEmpate != null){
                    listEmpatesConteridos.add(boardEmpate);
                }
            }
            readWrite.write(listEmpatesConteridos, "empates-criados.csv");

        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    private static Board criaBoardEmpate(){
        Random gerador = new Random();
        String[][] boardEmpate = new  String[3][3];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(gerador.nextInt(2) == 1){
                    boardEmpate[i][j] = "x";
                }
                else {
                    boardEmpate[i][j] = "o";
                }                
            }       
        }

        Board newBoard = new Board(boardEmpate);

        if(!newBoard.getStatus().equals("empate")){
            newBoard  = null;
        }
        else if(!newBoard.jogoValido(newBoard.getBoard())){
            newBoard = null;
        }
        else if(newBoard.horizontal(boardEmpate) || newBoard.vertical(boardEmpate) || newBoard.diagonal(boardEmpate))
           newBoard = null;

        return newBoard;

    }     
}