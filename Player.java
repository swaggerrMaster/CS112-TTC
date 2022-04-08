import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;

public class Player {

	private String name;
	private int wins;
	private XOPiece piece;

	public Player(String n) {
		name = n;
		wins = 0;
		piece = new XOPiece();
	}

	public void updateWins() {
		wins++;
	}

	public void setXOPiece(String p) {
		piece.changeXOPiece(p);
	}

	public XOPiece getPlayerXOPiece() {
		return(piece);
	}

	public String getName() {
		return(name);
	}

	public String toString() {
		return(name + ": " + wins + " wins");
	}
}