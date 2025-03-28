public class BoardHelper {
    /**
     * Creates an empty 2d Letter array and picks a random word
     * from a list. Returns a new Board object with those components
     * @return Board with all empty letters
     */
    public static Board createEmptyBoard() {
        // stub
        Letter[][] letters = new Letter[16][6];
        String correctWord = "";
        return new Board(letters, correctWord);
    }

    /**
     * Fills a row of letters with either correct, close or wrong letters
     * @param guess Guessed word
     * @param correctWord Correct word
     * @return Full row of letters
     */
    public static Letter[] evaluateGuess(Letter[] letters, String guess, String correctWord) {
        for (int i = 0; i < letters.length; i++) {
            String guessChr = guess.substring(i, i+1);
            String wordChr = correctWord.substring(i, i+1);
            if (guessChr.equals(wordChr)) {
                letters[i] = new CorrectLetter(guessChr);
            } else if (correctWord.contains(guessChr)) {
                letters[i] = new CloseLetter(guessChr);
            } else {
                letters[i] = new WrongLetter(guessChr);
            }
        }
        return letters;
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
            }
        }
        return true;
    }

    /**
     * Prints a board
     */
    public static void printBoard(Board board) {
        // stub
    }

}
