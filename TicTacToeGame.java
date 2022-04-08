import java.util.Scanner;
import java.util.Random;

public class TicTacToeGame {

	public static void main(String [] args) {

		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		String input = "";
		int slot = 0;
		XOPiece pieceX = new XOPiece("X");
		String name1 = "";
		String name2 = "";
		int rand0or1 = 1;
		Player player1;
		Player player2;
		SquareBoard board;
		boolean won = false;
		XOPiece winPiece = new XOPiece();
		int boardSpots = 0;
		String again;
		boolean repeat = true;

		System.out.println("Please enter first players name:");
		name1 = scan.nextLine();
		System.out.println("Please enter second players name:");
		name2 = scan.nextLine();
		System.out.println();

		//WHO GOES FIRST
		rand0or1 = r.nextInt(2);
		if (rand0or1 == 0) {
			player1 = new Player(name1);
			player2 = new Player(name2);
		}
		else {
			player1 = new Player(name2);
			player2 = new Player(name1);
		}

		//SET PLAYER 1 AND 2'S PIECES
		rand0or1 = r.nextInt(2);
		if (rand0or1 == 0) {
			player1.setXOPiece("O");
			player2.setXOPiece("X");
		}
		else {
			player1.setXOPiece("X");
			player2.setXOPiece("O");
		}

		//INSTANTIATE BOARD
		board = new SquareBoard();
		Player first;
		Player other;
		int count = 0;

		while (repeat == true) {
			boardSpots = 0;
			//PRINT OUT BOARD PIECES
			System.out.println("Game Number " + (count + 1) + "!!!\n");
			board.printBoardCoordinates();
			System.out.println(board);
			//SET WHO GOES FIRST
			if (count % 2 == 0) {
				first = player1;
				other= player2;
			}
			else {
				first = player2;
				other = player1;
			}
			System.out.println("First: \n\t" + first.getName() + " - " + first.getPlayerXOPiece());
			System.out.println("Second: \n\t" + other.getName() + " - " + other.getPlayerXOPiece());
			System.out.println();
			while (won == false && boardSpots != 9) {
				System.out.println(first.getName() + " please enter a slot");
				slot = scan.nextInt();
				//SLOT VALIDATION
				while (!(slot >= 1 && slot <= 9) || board.isSlotTaken(slot)) {
					System.out.println("Please enter a valid slot number (1-9):");
					slot = scan.nextInt();
				}
				board.setBoardXOPiece(slot, first.getPlayerXOPiece());
				board.updateTakenSlots(slot);
				boardSpots++;
				System.out.println(board);
				won = board.checkWin();
				if (won || boardSpots == 9) {
					break;
				}
				System.out.println(other.getName() + " please enter a slot");
				slot = scan.nextInt();
				//SLOT VALIDATION
				while (!(slot >= 1 && slot <= 9) || board.isSlotTaken(slot)) {
					System.out.println("Please enter a valid slot number (1-9):");
					slot = scan.nextInt();
				}
				board.setBoardXOPiece(slot, other.getPlayerXOPiece());
				board.updateTakenSlots(slot);
				boardSpots++;
				System.out.println(board);
				won = board.checkWin();
			}

			winPiece.changeXOPiece(board.getWinnerPiece().getXO());
			if (first.getPlayerXOPiece().matches(winPiece)) {
				System.out.println(first.getName() + " wins!! WOOOOOO");
				first.updateWins();
			}
			else if (other.getPlayerXOPiece().matches(winPiece)) {
				System.out.println(other.getName() + " wins!! YEHAWYEAHW");
				other.updateWins();
			}
			else {
				System.out.println("LAME, no one won");
			}

			System.out.println("Do you want to play again? (y/n)");
			again = scan.nextLine();
			while (!(again.equals("y") || again.equals("n"))) {
				System.out.println("Please enter a \"y\" or a \"n\"");
				again = scan.nextLine();
				System.out.println();
			}
			if (again.equals("n")) {
				repeat = false;
			}
			else {
				count++;
				board.resetBoard();
				won = false;
				continue;
			}

		}

		System.out.println("Games played: " + (count + 1));
		System.out.println(player1);
		System.out.println(player2);
	}
}