import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class WordHelper {

    private static File WORD_FILE;
    private static ArrayList<String> WORDS;
    private static WordHelper instance = new WordHelper();
    private WordHelper() {
        WORDS = new ArrayList<>();
        WORD_FILE = new File("/words.txt");
        try {
            Scanner scanner = new Scanner(WORD_FILE);
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                WORDS.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    public static WordHelper getInstance() {
        return instance;
    }

    public static String randomWord() {
        return ""; // stub
    }

}
