package AjusteDataset;

public class Board {
    
    private String[][] board;
    private String status;

    public Board(String[][] board) {
        this.board = board;
        this.status = avaliar(this.board);
    }

    public String[][] getBoard(){
        return this.board;
    }

    public void setBoard(String[][] board){
        this.board = board;
    }

    public String getStatus(){
        return status;
    }

    public String avaliar(String[][] board) {
        String result = "empate";

        if(horizontal(board)) return result = "ganhou";

        if(vertical(board)) return result = "ganhou";

        if(diagonal(board)) return result = "ganhou";

        return result;
    }

    private boolean horizontal(String[][] board){        
        int contXHoriz;
        int contOHoriz;

        for(int i = 0; i < 3; i++) {
            contXHoriz = 0;
            contOHoriz = 0;

            for(int j = 0; j < 3; j++) {

                if(board[i][j].equals("x")){
                    contXHoriz++;
                }
                if(board[i][j].equals("o")){
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
        return false;
    }

    private boolean vertical(String[][] board) {
        int contXVert;
        int contOvert;

        for(int i = 0; i < 3; i++) {
            contXVert = 0;
            contOvert = 0;

            for(int j = 0; j < 3; j++) {

                if(board[j][i].equals("x")){
                    contXVert++;
                }
                if(board[j][i].equals("o")){
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
        return false;
    }

    public boolean diagonal(String[][] board) {
         if(board[0][0].equals("x") && board[1][1].equals("x") &&
            board[2][2].equals("x"))
            return true;
        if(board[0][2].equals("x") && board[1][1].equals("x") &&
            board[2][0].equals("x"))
            return true;

        if(board[0][0].equals("o") && board[1][1].equals("o") &&
            board[2][2].equals("o"))
            return true;
        if(board[0][2].equals("o") && board[1][1].equals("o") &&
            board[2][0].equals("o"))
            return true;

        return false;
    }

    public String toString(){    
        StringBuilder sb  = new StringBuilder();  

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                sb.append(this.board[i][j].toString());
                sb.append(",");
            }
        }
        
        return sb.toString() + this.status;
    }

    public String toStringFormat(){    
        StringBuilder sb  = new StringBuilder();  

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {                
                sb.append(this.board[i][j].toString());                
            }
            sb.append("\n");
        }
        
        return sb.toString() + this.status;
    }

    public String[][] invertido(){
        String[][] boardInvertido = new  String[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(this.board[i][j].equals("x")){
                    boardInvertido[i][j] = "o";
                } 
                else if(this.board[i][j].equals("o")){
                    boardInvertido[i][j] = "x";
                }
                else {
                    boardInvertido[i][j] = "b";
                }                 
            }            
        }

        return boardInvertido;
    }
    
}
