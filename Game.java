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
        String thing = "";
        while (thing.length() != 6 && !GuessHelper.getInstance().isValidWord(thing.toLowerCase())){
            thing = scanner.nextLine();
            thing= thing.replace(" ", "");
            thing = thing.toUpperCase();
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
        //board1 = BoardHelper.createEmptyBoard();
        //board2 = BoardHelper.createEmptyBoard();
        //System.out.println(isGameOver());
        //System.out.println( BoardHelper.isBoardFull(board1) );
        //System.out.println( BoardHelper.boardComplete(board1));
        //System.out.println(BoardHelper.boardComplete(board2));
        while (!isGameOver()) {
            printBoards();
            System.out.println();
            System.out.println(Colors.WHITE + "What is your guess?" + Colors.RESET);
            String guess = promptForGuess();
            while (!done(guess)) {
                if (done(guess)) {
                    System.out.println(guess);
                    board1.useGuess(guess);
                    board2.useGuess(guess);
                    guesses++;
                } else {
                    System.out.println("Incorrect input!" + "\nTry again");
                    System.out.println(Colors.WHITE + "What is your guess?" + Colors.RESET);
                    guess = promptForGuess();
                }
            }
            System.out.println(guess);
            if(GuessHelper.getInstance().isValidWord(guess.toLowerCase())) {
                board1.useGuess(guess);
                board2.useGuess(guess);
                guesses++;
            } else {
                System.out.println("Incorrect input! Put in a REAL 6 letter word.");
            }
        }
        // TODO: get result
            System.out.print("Result: ");
            if (BoardHelper.boardComplete(board1) && BoardHelper.boardComplete(board2)){
                System.out.println("You woonn!11 🥳🥳");
            } else {
                System.out.println("You lost.. ;(");
                System.out.println("The words were " + board1.getCorrectWord() + " and " + board2.getCorrectWord());
            }
    }

    public boolean done (String guess){
        for (int i = 0; i < 5; i++){
            if (guess.substring(i, i+1).equals(" ")){
                return false;
            }
        }
        return true;
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
