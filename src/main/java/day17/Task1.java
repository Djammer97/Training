package day17;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int amount = 8;
        ChessPiece[] chess = new ChessPiece[amount];
        for (int i = 0; i < (amount / 2); i++) {
            chess[i] = ChessPiece.PAWN_WHITE;
            chess[i + amount / 2] = ChessPiece.ROOK_BLACK;
        }
        for (ChessPiece piece : chess) {
            System.out.print(piece + " ");
        }
    }
}