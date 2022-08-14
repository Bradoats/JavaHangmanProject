import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Hangman {
    public static void main(String[] args) throws Exception {
        WordChooser wordChooser = new WordChooser();
        String randomWord = wordChooser.chooseWord(false, " ");
        startGame(randomWord);
    }

    public static void startGame(String word) throws Exception {
        Scanner sc = new Scanner(System.in);
        hangmanASCII artGenerator = new hangmanASCII();
        int strikes = 0;
        List<String> wordTokenized = List.of(word.split(""));
        List<String> displayList = new ArrayList<String>();

        List<String> alphabetList = new ArrayList<String>();
        alphabetList.addAll(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","l","r","s","t","u","v","w","x","y","z"));

        for(String letter : wordTokenized) {
            displayList.add("_");
        }

        artGenerator.printArt(strikes);

        do {
            String displayListStringified = "";
            for(String character : displayList) {
                displayListStringified += character + " ";
            }
            System.out.println(displayListStringified);

            System.out.println("Enter a letter: ");
            String userInput = sc.next();

            if(userInput.length() != 1 || userInput.matches("\\d")) {
                artGenerator.printArt(strikes);
                System.out.println("Your input can have only 1, lowercase letter, please try again.");
            } else {
                if(alphabetList.contains(userInput.toLowerCase()) == false) {
                    artGenerator.printArt(strikes);
                    System.out.println("You used this character already, please try again.");
                } else {
                    if(wordTokenized.contains(userInput.toLowerCase())) {
                        for (int i=0; i<wordTokenized.size(); i++) {
                            if(wordTokenized.get(i).equals(userInput.toLowerCase())) {
                                displayList.set(i, userInput.toLowerCase());
                            }
                        }
                        artGenerator.printArt(strikes);
                        System.out.println("Correct, the letter contains " + userInput.toLowerCase() + "!");
                        //v code that removes a character from the alphabet array once it gets used v
                        alphabetList.remove(alphabetList.indexOf(userInput.toLowerCase()));
                    } else {
                        strikes += 1;
                        artGenerator.printArt(strikes);
                        System.out.println("The hangman now has " + strikes + " body parts.");
                        //v code that removes a character from the alphabet array once it gets used v
                        alphabetList.remove(alphabetList.indexOf(userInput.toLowerCase()));
                    }
                }

                if(strikes == 6) {
                    System.out.println("You lose, the word was " + word + ".");
                }
                if(displayList.contains("_") == false) {
                    System.out.println("Congrats, you win! the word was " + word + "!");
                    break;
                }
            }
        } while(strikes != 6 || displayList.contains("_") == false);
        System.out.println("Rematch? (yes/no)");
        sc.nextLine();
        String rematch = sc.nextLine();
        if(rematch.equals("yes")) {
            WordChooser wordChooser = new WordChooser();
            String randomWord = wordChooser.chooseWord(true, word);
            startGame(randomWord);
        } else {
            System.out.println("Okay, ending game.");
        }
    }
}
