public class CloseLetter extends Letter {
    public CloseLetter(String chr) {
        super(chr, Colors.YELLOW);
    }

    public static boolean isClose(int idx, String guess, String guessChr, String correctWord) {
        int ltrCount = 0;
        int guessedCount = 0;
        if (correctWord.toUpperCase().contains(guessChr)) {
            for (int i = 0; i < correctWord.length(); i++) {
                if (correctWord.substring(i, i+1).toUpperCase().equals(guessChr)) {
                    ltrCount++;
                }
            }
            /* testing
            System.out.println(idx + "--");
            System.out.println(guessChr);
            System.out.println(correctWord);
            System.out.println(ltrCount);
             */

            for (int i = 0; i <= idx; i++) {
                if (guess.substring(i, i+1).equals(guessChr)) {
                    guessedCount++;
                }
            }
            /* testing
            System.out.println(guess);
            System.out.println(guessedCount + "--");
             */

            if (guessedCount > ltrCount) {
                System.out.println("false");
                return false;
            } else {
                System.out.println("true");
                return true;
            }
        }
        return false;
    }
}
