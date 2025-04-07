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


    private String promptForGuess() {
        String thing = "";
        while (!isValidGuess(thing) && !GuessHelper.getInstance().isValidWord(thing.toLowerCase())){
            if(thing.isEmpty()){
                System.out.println(Colors.WHITE + "What is your guess?" + Colors.RESET);
                thing= scanner.nextLine();
                thing= thing.toUpperCase();
            }else {
                System.out.println("Incorrect input! Please enter a valid 6-letter word (only letters).");
                System.out.println(Colors.WHITE + "What is your guess?" + Colors.RESET);
                thing = scanner.nextLine();
                thing = thing.toUpperCase();
            }
        }
        return thing;

    }
    private boolean isGameOver() {
        if (guesses >= 16 || BoardHelper.isBoardFull(board1) || BoardHelper.isBoardFull(board2) || (BoardHelper.boardComplete(board1) && BoardHelper.boardComplete(board2))){
            return true;
        }
        return false;
    }
    private void printBoards() {
        BoardHelper.printTwoBoards(board1, board2);
    }
    private void playGame() {
        printBoards();
        while (!isGameOver()) {
            System.out.println();
            // Get a valid guess from the user
            String guess = promptForGuess();
            // Once a valid guess is entered, process the guess
            System.out.println(guess);
            if (GuessHelper.getInstance().isValidWord(guess.toLowerCase())) {
                board1.useGuess(guess);
                board2.useGuess(guess);
                guesses++;
                printBoards();
            } else {
                System.out.println("Incorrect input! The word must be a real 6-letter word.");
            }
        }

        // End game result
        System.out.print("Result: ");
        if (BoardHelper.boardComplete(board1) && BoardHelper.boardComplete(board2)) {
            System.out.println("You won! 🥳🥳");
            System.out.println("It took you " + guesses + " guesses!");
        } else {
            System.out.println("You lost.. ;(");
            System.out.println("The words were " + board1.getCorrectWord() + " and " + board2.getCorrectWord());
        }
    }



    public boolean isValidGuess(String guess) {
        // Ensure the guess is exactly 6 characters and only alphabetic letters
        if (guess.length() != 6) {

            return false; // Guess must be 6 characters
        }

        for (int i = 0; i < guess.length(); i++) {
            if (!Character.isAlphabetic(guess.charAt(i))) {
                return false; // Guess must contain only alphabetic characters
            }
        }

        return true; // If both checks pass, it's a valid guess
    }


    public void start() {
        System.out.println("Welcome to Palabrale!" + "\nLike Wordle but " + Colors.YELLOW + "BETTER" + Colors.RESET);
        System.out.println("Little twist. " + Colors.CYAN + "6 letter word, two boards, and both boards use the same word you input." + Colors.RESET);
        System.out.println(Colors.RED + "3... 2... 1" + Colors.RESET);
        playGame();
        System.out.println("Want to play again? (y/n)");
        String answer = scanner.nextLine();
        while (!answer.equals("n")){
            Game thing = new Game();
            thing.start();
            System.out.println("Want to play again? (y/n): ");
            answer = scanner.nextLine();
        }
        System.out.println("Bye bye");
    }
    private void printGuessCount() {
        System.out.println("Guess #" + (guesses + 1));
    }



    public Board getBoard1() {
        return board1;
    }

    public Board getBoard2() {
        return board2;
    }


}
