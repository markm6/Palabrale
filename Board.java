public class Board {
    private Letter[][] letters;
    private String correctWord;
    public Board(Letter[][] letters, String correctWord) {
        this.letters = letters;
        this.correctWord = correctWord;
    }

    public Letter[][] getLetters() {
        return letters;
    }

    /**
     * Finds the first empty row index.
     * @return First empty row index in the letters array.
     */
    public int getFirstEmptyRow() {
        for (int i = 0; i < letters.length; i--){
            if (letters[i][0] instanceof EmptyLetter) {
                return i;
            }
        }
        return -1;
    }

    public void useGuess(String guess) {
        int row = getFirstEmptyRow();
        BoardHelper.evaluateGuess(letters[row], guess, correctWord);
    }
    
}
