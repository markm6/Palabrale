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
        String guess = "";
        while (guess.length() != 6)
    }
    private boolean isGameOver() {
        if (guesses >= 16 || BoardHelper.isBoardFull(board1) || BoardHelper.boardComplete(board1) || BoardHelper.boardComplete(board2)){
            return true;
        }
        return false;
    }
    private void printBoards() {
        BoardHelper.printBoard(board1);
        BoardHelper.printBoard(board2);
    }
    private void playGame() {
        while (isGameOver()) {
            printBoards();
            System.out.println();
            System.out.println(Colors.WHITE + "What is your guess?" + Colors.RESET);
            String guess = promptForGuess();
            board1.useGuess(guess);
            board2.useGuess(guess);
            guesses++;
        }
        // TODO: get result
        System.out.println("Result: ");
    }
    public void start() {
        System.out.println("Welcome to Palabrale!" + "\nLike Wordle but " + Colors.YELLOW + "BETTER" + Colors.RESET);
        System.out.println("Little twist. " + Colors.CYAN + "6 letter word, two boards, and both boards use the same word you input." + Colors.RESET);
        System.out.println(Colors.RED + "3... 2... 1" + Colors.RESET);
        playGame();
    }

    public Board getBoard1() {
        return board1;
    }

    public Board getBoard2() {
        return board2;
    }

}
