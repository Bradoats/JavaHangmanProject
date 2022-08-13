import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordChooser {
    public static String chooseWord() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String word = null;
        FileReader fr = new FileReader("words.txt");
        BufferedReader br = new BufferedReader(fr);
        Random rand = new Random();
        List<String> fileTokenized = br.lines().toList();

        System.out.println("Please type the difficulty in lowercase that you wish to play.\neasy\nnormal\nhard\n:");

        String difficulty = sc.nextLine();

        if(difficulty.equals("easy")) {
            word = fileTokenized.get(rand.nextInt(0, 13));
        } else if(difficulty.equals("normal")) {
            word = fileTokenized.get(rand.nextInt(14,26));
        } else if (difficulty.equals("hard")) {
            word = fileTokenized.get(rand.nextInt(27,36));
        } else {
            System.out.println("Please try again:");
            chooseWord();
        }

        return word;
    }
}
