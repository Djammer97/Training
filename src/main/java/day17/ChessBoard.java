package day17;

public class ChessBoard {
    private ChessPiece[][] board;

    public ChessBoard(ChessPiece[][] board) {
        this.board = board;
    }

    public void print() {
        for (ChessPiece[] pieces : board) {
            for (ChessPiece piece : pieces){
                System.out.print(piece);
            }
            System.out.println();
        }
    }
}
