package AjusteDataset;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

class App {

    public static String line = "";
    public static String file = "tic-tac-toe.csv";
    public static ArrayList<String[][]> list = new ArrayList<>();
    public static Integer cont;
    public static String[][] board;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {       

        try (Scanner sc = new Scanner(Paths.get(file))) {

            while(sc.hasNext()) {                
                
                line = sc.nextLine();
                String[] gameChar = line.split(",");
                cont = 0;
                board = new String[3][3];

                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        board[i][j] = gameChar[cont];
                        cont++;
                    }
                } 
                list.add(board);
            }            

            FileWriter fileWriter = new FileWriter(new File("test.txt"));
            BufferedWriter  bw  = new BufferedWriter (fileWriter);

            for (String[][] b : list) {                

                if(avaliaSeGanhou(b)) {                                       
                    bw.write(escreve(b) + "ganhou");
                }
                else {
                    bw.write(escreve(b) + "empate");
                }                
                sb.delete(0, sb.length());
                bw.newLine();
            }

            bw.close();
            System.out.println("Fim");

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static String escreve(String[][] b){        

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                sb.append(b[i][j].toString());
                sb.append(",");
            }
        }
        
        return sb.toString();
    }

    public static boolean avaliaSeGanhou(String[][] b){
        int contXHoriz = 0;
        int contOHoriz = 0;

        int contXVert = 0;
        int contOvert = 0;

        // HORIZONTAL
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {

                if(b[i][j].equals("x")){
                    contXHoriz++;
                }
                if(b[i][j].equals("o")){
                    contOHoriz++;
                }
                if(contXHoriz == 3){
                    return true;
                }
                if(contOHoriz == 3){
                    return true;
                }
            }
        }

        // VERTICAL
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {

                if(b[j][i].equals("x")){
                    contXVert++;
                }
                if(b[j][i].equals("o")){
                    contOvert++;
                }
                if(contXVert == 3){
                    return true;
                }
                if(contOvert == 3){
                    return true;
                }
            }
        }

        // DIAGONAL
        if(b[0][0].equals("x") && b[1][1].equals("x") &&
            b[2][2].equals("x"))
            return true;
        if(b[0][2].equals("x") && b[1][1].equals("x") &&
            b[2][0].equals("x"))
            return true;

        if(b[0][0].equals("o") && b[1][1].equals("o") &&
            b[2][2].equals("o"))
            return true;
        if(b[0][2].equals("o") && b[1][1].equals("o") &&
            b[2][0].equals("o"))
            return true;

        return false;
    }

}