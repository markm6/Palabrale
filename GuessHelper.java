import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GuessHelper {

    private static File GUESSES_FILE;
    private static ArrayList<String> GUESSES;
    private static GuessHelper instance = new GuessHelper();
    private GuessHelper() {
        GUESSES = new ArrayList<>();
        GUESSES_FILE = new File("./validguesses.txt");
        try {
            Scanner scanner = new Scanner(GUESSES_FILE);
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                GUESSES.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    public static GuessHelper getInstance() {
        return instance;
    }

    public static String randomWord() {
        return GUESSES.get((int)(Math.random()*100));
    }

    public boolean isValidWord(String word) {
        int leftIdx=0;
        int rightIdx= GUESSES.size()-1;

        while (leftIdx<=rightIdx){
            int middle= (leftIdx+rightIdx)/2;
            if(word.compareTo(GUESSES.get(middle))<0){
                rightIdx=middle-1;
            }else if(word.compareTo(GUESSES.get(middle))>0){
                leftIdx=middle+1;
            }else{
                return true;
            }
        }

        return false;
    }

}
