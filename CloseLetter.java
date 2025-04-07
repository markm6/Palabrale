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

//            System.out.println(idx + "--");
//            System.out.println(guessChr);
//            System.out.println(correctWord);
//            System.out.println(ltrCount);


            for (int i = 0; i <= idx; i++) {
                if (guess.substring(i, i+1).equals(guessChr)) {
                    guessedCount++;
                }
            }

//            System.out.println(guess);
//            System.out.println(guessedCount);

            for (int i = idx; i < correctWord.length(); i++) {
                String gChr = guess.substring(i, i+1).toUpperCase();
                String wChr = correctWord.substring(i, i+1).toUpperCase();
                if (guessChr.equals(wChr) && gChr.equals(wChr)) {
//                    System.out.println(guessChr + wChr + " " + correctWord + i + "equal");
                    guessedCount--;
                }
            }
//            System.out.println(guessedCount + "--");

            if (guessedCount > ltrCount) {
                return false;
            } else if (guessedCount == 0 ) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
