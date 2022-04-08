public class XOPiece {

    private String XO;

    public XOPiece() {
        XO = " ";
    }

    public XOPiece(String choice) {
        XO = choice;
    }

    public String getXO() {
        return(XO);
    }

    public void changeXOPiece(String p) {
        XO = p;
    }

    public boolean matches (XOPiece piece) {
        boolean match = false;
        if (this.getXO().equals(piece.getXO())) {
            match = true;
        }
        return (match);
    }

    public String toString() {
        return(this.getXO());
    }
}