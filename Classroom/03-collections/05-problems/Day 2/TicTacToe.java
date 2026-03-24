public class TicTacToe {

    private char[][] board = new char[3][3];

    public TicTacToe() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';
    }

    public void move(int row, int col, char player) {
        board[row][col] = player;
    }

    public boolean checkWin(char player) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player)
                return true;

            if (board[0][i] == player &&
                    board[1][i] == player &&
                    board[2][i] == player)
                return true;
        }

        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player)
            return true;

        if (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player)
            return true;

        return false;
    }
}