
import java.util.*;

  class tic {
    static char board[][];

    public tic() {
        board = new char[3][3];
        Board();
    }

 static void Board() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
            }
        }
    }

  static void DisplayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");

            }
            System.out.println();

            System.out.println("-------------");
        }

    }

 static void mark(int row, int column, char c) {
        if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {
            board[row][column] = c;
        } else
            System.out.println("Invalid position");

    }

  static  boolean winRow() {
        if (board[0][0] != ' ' && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
           
            return true;
        }
        return false;
    }

  static  boolean winColumn() {
        if (board[0][0] != ' ' && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
           
            return true;
        }
        return false;

    }

static  boolean winDiagonal() {

        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2] != ' ' &&
                board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                   return true;
        }
        return false;

    }

    static boolean check()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==' ')
                return false;
            }
        }
        return true;
    }

    

}



 

public class App {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
       tic t=new tic();
        tic.DisplayBoard();
       
        HumanPlay player1=new HumanPlay("raja", 'X');
        HumanPlay player2=new HumanPlay("pandi", 'O');
       
        HumanPlay change;
        change=player1;
        
        while (true) {
            System.out.println(change.name+" turn");
            change.move();
            tic.DisplayBoard();
            if(tic.winColumn() || tic.winDiagonal() || tic.winRow())
            {
                System.out.println(change.name+" has won");
                break;
    
            }
            if(tic.check())
            {
                System.out.println("............................Match is Drawn......");
                System.out.println("............................Try Again............");
                main(args);
                break;
            }
            else
            {
                if(change==player1)
                change=player2;
                else
                change=player1;
            }
            
        }
       
       

    }
}
