import java.util.ArrayList;
public class SquareBoard {

    private XOPiece[][] board;
    private int size;
    private XOPiece winnerPiece;
    private ArrayList<Integer> takenSlots;

    public SquareBoard() {
        board = new XOPiece[3][3];
        takenSlots = new ArrayList<Integer>();
        size = 3;
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                board[r][c] = new XOPiece();
            }
        }
    }

    public SquareBoard(int n) {
        board = new XOPiece[n][n];
        size = n;
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                board[r][c] = new XOPiece();
            }
        }
    }

    public void resetBoard() {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                board[r][c] = new XOPiece();
            }
        }
        takenSlots.clear();
    }

    public void updateTakenSlots(int s) {
        takenSlots.add(s);
    }

    public boolean isSlotTaken(int s) {
        boolean taken = false;
        for (int i = 0; i < takenSlots.size(); i++) {
            if (s == takenSlots.get(i)) {
                taken = true;
            }
        }
        return(taken);
    }

    public void setBoardXOPiece(int slot, XOPiece piece) {
        if(slot == 1) {
            board[0][0] = piece;
        }
        else if (slot == 2) {
            board[0][1] = piece;
        }
        else if (slot == 3) {
            board[0][2] = piece;
        }
        else if (slot == 4) {
            board[1][0] = piece;
        }
        else if (slot == 5) {
            board[1][1] = piece;
        }
        else if (slot == 6) {
            board[1][2] = piece;
        }
        else if (slot == 7) {
            board[2][0] = piece;
        }
        else if (slot == 8) {
            board[2][1] = piece;
        }
        else {
            board[2][2] = piece;
        }
    }

    public XOPiece getBoardXOPiece(int r, int c) {
        //FIX ME NOT COORDINATES INETAD SLOTS
        return(board[r][c]);
    }

    public XOPiece getWinnerPiece() {
        return(winnerPiece);
    }

    public ArrayList<Integer> getTakenSlots() {
        return(takenSlots);
    }

    public void addTakenSlots(int s) {
        takenSlots.add(s);
    }

    public void printBoardCoordinates() {
        int slot = 1;
        for(int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                System.out.print("[" + slot + "] ");
                slot++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean checkWin() {
        boolean won = false;
        winnerPiece = new XOPiece();
        XOPiece emptyPiece = new XOPiece();
        int count = 0;
        //CHCEK FOR HORIZONTAL WINS
        for (int r = 0; r < board.length; r++) {
            count = 0;
            for (int c = 0; c < board[r].length - 1; c++) {
                if (!(board[r][c].matches(emptyPiece)) && board[r][c].matches(board[r][c + 1])) {
                    count++;
                    if (count == 2) {
                        winnerPiece.changeXOPiece(board[r][c].getXO());
                        won = true;
                        break;
                    }
                }
            }
        }
        //CHECK FOR VERTICAL WINS
        for (int c = 0; c < board[0].length; c++) {
            count = 0;
            for (int r = 0; r < board.length - 1; r++) {
                if (!(board[r][c].matches(emptyPiece)) && board[r][c].matches(board[r + 1][c])) {
                    count++;
                    if (count == 2) {
                        winnerPiece.changeXOPiece(board[r][c].getXO());
                        won = true;
                        break;
                    }
                }
            }
        }
        //CHCEK FOR DIAGONAL WINS RIGHTTOP TO LEFTBOTTOM
        count = 0;
        for (int r = 0; r < board.length - 1; r++) {
            //System.out.println("Checking " + r + "," + r + " matghes " + (r+1) + "," + (r+1));
            if (!(board[r][r].matches(emptyPiece)) && board[r][r].matches(board[r+1][r+1])) {
                count++;
                if (count == 2) {
                    winnerPiece.changeXOPiece(board[r][r].getXO());
                    won = true;
                    break;
                }
            }
        }
        //CHCEK FOR DIAGONAL WINS RIGTHTOP TO LEFTBOTTOM
        count = 0;
        for (int r = 0; r < board.length - 1; r++) {
            //System.out.println("Checking " + r + "," + r + " matghes " + (r+1) + "," + (r+1));
            if (!(board[r][r].matches(emptyPiece)) && board[r][board.length - 1 - r].matches(board[r+1][board.length - 1 - r - 1])) {
                count++;
                if (count == 2) {
                    winnerPiece.changeXOPiece(board[r][r].getXO());
                    won = true;
                    break;
                }
            }
        }
        
        return(won);
    }

    public String toString() {
        String output = "";
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                output = output + "[" + board[r][c] + "] ";
            }
            output = output + "\n";
        }
        return(output);
    }
}