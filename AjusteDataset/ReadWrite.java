package AjusteDataset;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWrite {

    private String fileInPadrao = "tic-tac-toe.csv";
    private String fileOutPadrao = "test.csv";

    public ArrayList<Board> read(String fileName) {
        String line = "";
        int cont;
        String[][] auxBoard;
        ArrayList<Board> list = new ArrayList<>();
        Scanner sc;

        if(fileName == null){
            fileName = fileInPadrao;
        }

        try {
            sc = new Scanner(Paths.get(fileName));             

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

        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.getMessage();
        }
        
        System.out.println("Leitura com sucesso do arquivo " + fileName);
        System.out.println("\n");
        return list;
    }

    public void write(ArrayList<Board> list, String fileName) throws IOException {
        if(fileName == null){
            fileName = fileOutPadrao;
        }
        FileWriter fileWriter = new FileWriter(new File(fileName));  
        BufferedWriter bw  = new BufferedWriter (fileWriter);

        for (Board b : list) {                      
            bw.write(b.toString());
            bw.newLine();
        }

        bw.close();
        System.out.println("Escrita com sucesso do arquivo " + fileName);
        System.out.println("\n");
    }
}