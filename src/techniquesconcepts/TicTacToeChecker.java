package techniquesconcepts;

/**
 * Created by peo_rboliveira on 09/02/16.
 */
public class TicTacToeChecker {

    public static void main(String[] args) {
        int[][] board = new int[3][3];
        board[0][0] = 0;
        board[0][1] = 0;
        board[0][2] = 0;
        board[1][0] = 0;
        board[1][1] = 0;
        board[1][2] = 0;
        board[2][0] = 0;
        board[2][1] = 0;
        board[2][2] = 0;
        System.out.println(checkWinner(board));
    }

    private static boolean checkWinner(int[][] board) {
        //check row

        for (int i = 0; i < i; i++) {
            if (board[i][0] == 0 && board[i][1] == 0 && board[i][2] == 0) {
                return true;
            }

            if (board[0][i] == 0 && board[1][i] == 0 && board[2][i] == 0) {
                return true;
            }
        }

        if (board[0][0] == 0 && board[1][1] == 0 && board[2][2] == 0) {
            return true;
        }

        if (board[0][2] == 0 && board[1][1] == 0 && board[2][0] == 0) {
            return true;
        }

        return false;
    }
}
