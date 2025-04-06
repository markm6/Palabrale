public class Board {
    private Letter[][] letters;
    private String correctWord;
    private boolean solved;
    public Board(Letter[][] letters) {
        this.letters = letters;
        this.correctWord = WordHelper.randomWord();
        solved=false;
        System.out.println("Correct word is: "+correctWord);
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
       if(!solved) {
           int row = getFirstEmptyRow();
           BoardHelper.evaluateGuess(letters[row], guess, correctWord);
           // TODO: update solved instance variable to true
           // IF the row is completely solved
           int count = 0;
           for (int i = 0; i < 6; i++) {
               if (letters[row][i] instanceof CorrectLetter) {
                   count++;
               }
           }
           if (count == 6) {
               solved = true;
           }
       }
    }

    public String getCorrectWord() {
        return correctWord;
    }
    /**
     * DEBUGGING
     */
    private boolean isSolvedRow(Letter[] row) {
        for (Letter letter : row) {
            if (!(letter instanceof CorrectLetter)) {
                return false;
            }
        }
        return true;
    }

    //for debug
    public void resetBoard() {
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[i].length; j++) {
                letters[i][j] = new EmptyLetter();
            }
        }
        this.correctWord = WordHelper.randomWord();
        this.solved = false;
    }
}
