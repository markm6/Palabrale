import java.util.Scanner;

public class Game {
    private int guesses;
    private Board board1;
    private Board board2;
    private Scanner scanner;
    public Game() {
        board1 = BoardHelper.createEmptyBoard();
        board2 = BoardHelper.createEmptyBoard();
        guesses = 0;
        scanner = new Scanner(System.in);
    }
    private void resetGame() {
        board1 = BoardHelper.createEmptyBoard();
        board2 = BoardHelper.createEmptyBoard();
        guesses = 0;
    }

    // TODO: finish promptForGuess, should include validation of the word and convert to uppercase
    private String promptForGuess() {
        return "";
    }
    // TODO: finish isGameOver, checks if the game is over (if guesses limit has been reached or game is won)
    private boolean isGameOver() {
        return false;
    }
    private void printBoards() {
        BoardHelper.printBoard(board1);
        BoardHelper.printBoard(board2);
    }
    private void playGame() {
        while (!isGameOver()) {
            printBoards();
            System.out.println("What is your guess?");
            String guess = promptForGuess();
            board1.useGuess(guess);
            board2.useGuess(guess);
            guesses++;
        }
        // TODO: get result
        System.out.println("Result: ");
    }
    public void start() {
        System.out.println("Welcome to Palabrale!");
    }

    public Board getBoard1() {
        return board1;
    }

    public Board getBoard2() {
        return board2;
    }

}
