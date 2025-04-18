import java.util.Arrays;

public class BoardHelper {
    /**
     * Creates an empty 2d Letter array and picks a random word
     * from a list. Returns a new Board object with those components
     * @return Board with all empty letters
     */
    public static Board createEmptyBoard() {
        Letter[][] letters = new Letter[16][6];
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[0].length; j++) {
                letters[i][j]= new EmptyLetter();
            }
        }
        return new Board(letters);
    }

    /**
     * Fills a row of letters with either correct, close or wrong letters
     *
     * @param guess       Guessed word
     * @param correctWord Correct word
     */
    public static void evaluateGuess(Letter[] letters, String guess, String correctWord) {
        for (int i = 0; i < letters.length; i++) {
            String guessChr = guess.substring(i, i+1).toUpperCase();
            String wordChr = correctWord.substring(i, i+1).toUpperCase();
                // guessChr.equals(wordChr)
            if (guessChr.equals(wordChr)) {
                letters[i] = new CorrectLetter(guessChr);
                // correctWord.toUpperCase().contains(guessChr)
            } else if (CloseLetter.isClose(i, guess, guessChr, correctWord)) {
                letters[i] = new CloseLetter(guessChr);
            } else {
                letters[i] = new WrongLetter(guessChr);
            }
        }
    }

    public static boolean isBoardFull(Board board) {
        for (int i = 0; i < 16; i++){
            if (board.getLetters()[i][0] instanceof EmptyLetter){
                return false;
            }
        }
        return true;
    }


    /**
     * Checks if a board has successfully been completed with a correct
     * guessed word.
     * @return True if a board has successfully been completed with a correct
     * guessed word, else false
     */
    public static boolean boardComplete(Board board) {
        for (int i = 15; i > -1; i--){
            if (board.getLetters()[i][0] instanceof EmptyLetter){

            } else {
                for (int j = 0; j < 6; j++){
                    if (!(board.getLetters()[i][j] instanceof CorrectLetter)){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Prints a board
     */
    public static void printBoard(Board board) {
        // stub
        Letter[][] letray = board.getLetters();
        for (int r = 0; r <= 8; r++) {
            System.out.println();
            for (int c = 0; c < 6; c++) {
                System.out.print(letray[r][c] + " ");
            }
        }
    }

    public static void printBoardRow(Letter[][] boardLetters, int i) {
        for (int j = 0; j < boardLetters[i].length; j++) {
            System.out.print(boardLetters[i][j] + " ");
        }
    }

    public static void printTwoBoards(Board b1, Board b2) {
        Letter[][] letters1 = b1.getLetters();
        Letter[][] letters2 = b2.getLetters();
        for (int i = 0; i < 16; i++) {
            printBoardRow(letters1, i);
            System.out.print("| ");
            printBoardRow(letters2, i);
            System.out.println();
        }
    }


}
