import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordChooser {
    public static String chooseWord(boolean isRematch, String previouslyUsedWord) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileReader fr = new FileReader("words.txt");
        BufferedReader br = new BufferedReader(fr);
        Random rand = new Random();
        List<String> fileTokenized = new ArrayList<String>();
        fileTokenized.addAll(br.lines().toList());


        if(isRematch == true && fileTokenized.contains(previouslyUsedWord)) {
            fileTokenized.remove(fileTokenized.indexOf(previouslyUsedWord));
        }

        String word = fileTokenized.get(rand.nextInt(fileTokenized.size()));

        System.out.println("Please type the number corresponding to the difficulty that you wish to play.\neasy (1)\nnormal (2)\nhard (3)\n:");

        int difficulty = sc.nextInt();

        if(difficulty == 1) {
            while(word.length() != 4) {
                word = fileTokenized.get(rand.nextInt(fileTokenized.size()));
            }
        } else if(difficulty == 2) {
            while(word.length() != 5) {
                word = fileTokenized.get(rand.nextInt(fileTokenized.size()));
            }
        } else if (difficulty == 3) {
            while(word.length() != 6) {
                word = fileTokenized.get(rand.nextInt(fileTokenized.size()));
            }
        } else {
            throw new Exception("Error: number outside of range 1-3.");
        }

        return word;
    }
}
