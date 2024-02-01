
public class HumanPlay extends App {
    String name;
    char mark;

    HumanPlay(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

  void move()
    {
     
        int row,col;
       do {
           System.out.println("Enter the rows and column");
           row=sc.nextInt();
           col=sc.nextInt();
        } while (!isValid(row, col));

        tic.mark(row, col, mark);
        // sc.close();
    }

    boolean isValid(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (tic.board[row][col] == ' ')
                return true;
        }
        return false;
        
    }
}


