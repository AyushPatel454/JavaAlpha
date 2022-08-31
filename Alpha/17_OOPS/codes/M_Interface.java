public class M_Interface {
    public static void main(String[] args) {
        Queen q1 = new Queen();
        q1.moves();
    }
}

interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves() { // public nai lakhiye to error avse because by default te default hase.
        System.out.println("up, down, left, right, diagonal (in all 4 cell)");
    }
}

class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right");
    }
}