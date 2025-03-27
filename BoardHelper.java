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
    public static Letter[] evaluateGuess(String guess, String correctWord) {
        Letter[] letters = new Letter[6];
        for (int i = 0; i < letters.length; i++) {
            // ..
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
     * @return
     */
    public static boolean boardComplete(Board board, String correctWord) {
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
}
