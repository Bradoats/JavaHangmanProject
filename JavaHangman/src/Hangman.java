import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) throws Exception {
        String word = chooseWord();
        System.out.println(word);
    }

    public static String chooseWord() throws FileNotFoundException {
        FileReader fr = new FileReader("words.txt");
        BufferedReader br = new BufferedReader(fr);
        Random rand = new Random();
        List<String> fileTokenized = br.lines().toList();

        String word = fileTokenized.get(rand.nextInt(fileTokenized.size()));

        return word;
    }
}
