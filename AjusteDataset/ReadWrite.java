package AjusteDataset;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWrite {

    private Scanner sc;
    private String fileIn = "tic-tac-toe.csv";
    private String fileOut = "test.csv";
    private FileWriter fileWriter;

    public ReadWrite() throws IOException {
        sc = new Scanner(Paths.get(fileIn));
        fileWriter = new FileWriter(new File(fileOut));        
    }

    public ArrayList<Board> read() {
        String line = "";
        int cont;
        String[][] auxBoard;
        ArrayList<Board> list = new ArrayList<>();

        while(sc.hasNext()) {                
            
            line = sc.nextLine();
            String[] gameChar = line.split(",");
            cont = 0;
            auxBoard = new String[3][3];

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    auxBoard[i][j] = gameChar[cont];
                    cont++;
                }
            }
            Board board = new Board(auxBoard);
            list.add(board);
        }
        return list;
    }

    public void write(ArrayList<Board> list) throws IOException {
        BufferedWriter bw  = new BufferedWriter (this.fileWriter);

        for (Board b : list) {                      
            bw.write(b.toString());
            bw.newLine();
        }

        bw.close();
        System.out.println("Fim");
    }
}