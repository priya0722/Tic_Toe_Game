import java.util.*;

public class TicTacToe {

    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    private static boolean gameOver = false;

    public static void main(String[] args) {
        initBoard();
        printBoard();

        while (!gameOver) {
            playerMove();
            printBoard();
            checkWinner();
        }

        if (gameOver) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("The game is a draw!");
        }
    }

    private static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player " + currentPlayer + "'s turn: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (row < 1 || row > 3 || col < 1 || col > 3) {
            System.out.println("Invalid move!");
            return;
        }

        if (board[row - 1][col - 1] != '-') {
            System.out.println("The cell is already occupied!");
            return;
        }

        board[row - 1][col - 1] = currentPlayer;
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static void checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                gameOver = true;
                break;
            } else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                gameOver = true;
                break;
            }
        }

        if (!gameOver) {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
                gameOver = true;
            } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
                gameOver = true;
            }
        }
    }
}
