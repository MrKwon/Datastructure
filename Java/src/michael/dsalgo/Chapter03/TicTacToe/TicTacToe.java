package michael.dsalgo.Chapter03.TicTacToe;

import java.util.Scanner;

/**
 * TicTacToe 게임 사용자가 말을 놓을 수 있도록 구현
 * void putMark => boolean putMark 로 수정
 * boolean isFull 추가
 * main logic 재구성
 */
public class TicTacToe {
    protected static final int X = 1, O = -1;
    protected static final int EMPTY = 0;
    protected int board[][] = new int[3][3];
    protected int player;

    public TicTacToe() {
        clearBoard();
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = EMPTY;
        player = X;
    }

    public boolean putMark(int i, int j) /*throws IllegalArgumentException*/ {
        if ((i < 0) || (i > 2) || (j < 0) || (j > 2)) {
//            throw new IllegalArgumentException("Invalid board position");
            System.out.println("Invalid board position try again");
            return false;
        }
        if (board[i][j] != EMPTY) {
//            throw new IllegalArgumentException("Board position occupied");
            System.out.println("Board position ocuupied try again");
            return false;
        }

        board[i][j] = player;
        player = -player;
        return true;
    }

    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark * 3)
            || (board[1][0] + board[1][1] + board[1][2] == mark * 3)
            || (board[2][0] + board[2][1] + board[2][2] == mark * 3)
            || (board[0][0] + board[1][0] + board[2][0] == mark * 3)
            || (board[0][1] + board[1][1] + board[2][1] == mark * 3)
            || (board[0][2] + board[1][2] + board[2][2] == mark * 3)
            || (board[0][0] + board[1][1] + board[2][2] == mark * 3)
            || (board[2][0] + board[1][1] + board[0][2] == mark * 3));
    }

    public boolean isFull() {
        return (Math.abs(board[0][0]) + Math.abs(board[0][1]) + Math.abs(board[0][2])
                + Math.abs(board[1][0]) + Math.abs(board[1][1]) + Math.abs(board[1][2])
                + Math.abs(board[2][0]) + Math.abs(board[2][1]) + Math.abs(board[2][2]) == 9);
    }

    public int winner() {
        if (isWin(X))
            return X;
        else if (isWin(O))
            return O;
        else
            return 0;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case X:
                        s += "X";
                        break;
                    case O:
                        s += "O";
                        break;
                    case EMPTY:
                        s += " ";
                        break;
                }
                if (j < 2) s += "|";
            }
            if (i < 2) s += "\n----\n";
        }
        return s;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner stdIn = new Scanner(System.in);

        int i = 0;
        int winner = game.winner();
        while(winner == 0) {
            if (game.isFull()) break;

            if (i % 2 == 0)
                System.out.println("X의 차례 : ");
            else
                System.out.println("O의 차례 : ");

            int x = stdIn.nextInt();
            int y = stdIn.nextInt();

            if (!game.putMark(x, y)) {
                System.out.println(game.toString());
                continue;
            }

            winner = game.winner();

            System.out.println(game.toString());
            i++;
        }

        if (game.winner() != 0)
            System.out.println(winner + " wins");
        else
            System.out.println("tie");
    }
}
