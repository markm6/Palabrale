public class Board {
    private Letter[][] letters;
    private String correctWord;
    private boolean solved;
    public Board(Letter[][] letters) {
        this.letters = letters;
        this.correctWord = WordHelper.randomWord();
    }

    public Letter[][] getLetters() {
        return letters;
    }

    /**
     * Finds the first empty row index.
     * @return First empty row index in the letters array.
     */
    public int getFirstEmptyRow() {
        for (int i = 0; i < letters.length; i++){
            if (letters[i][0] instanceof EmptyLetter) {
                return i;
            }
        }
        return -1;
    }

    public void useGuess(String guess) {
        // TODO: if solved is true do not use the guess/do not fill board with additional guesses
        int row = getFirstEmptyRow();
        BoardHelper.evaluateGuess(letters[row], guess, correctWord);

        // TODO: update solved instance variable to true
        // IF the row is completely solved
        for (int i = 0; i < 6; i++) {
            // ..
        }
    }

    public String getCorrectWord() {
        return correctWord;
    }
}
