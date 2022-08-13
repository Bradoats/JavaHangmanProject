import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Hangman {
    public static void main(String[] args) throws Exception {
        WordChooser wordChooser = new WordChooser();
        String randomWord = wordChooser.chooseWord();
        startGame(randomWord);
    }

    public static void startGame(String word) {
        Scanner sc = new Scanner(System.in);
        int strikes = 0;
        List<String> wordTokenized = List.of(word.split(""));
        List<String> displayList = new ArrayList<String>();

        List<String> alphabetList = new ArrayList<String>();
        alphabetList.addAll(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","l","r","s","t","u","v","w","x","y","z"));

        for(String letter : wordTokenized) {
            displayList.add("_");
        }

        do {
            System.out.println(displayList.toString());

            System.out.println("Enter a letter: ");
            String userInput = sc.next();

            if(userInput.length() != 1) {
                System.out.println("Your input can only have 1 character, please try again.");
            } else {
                if(alphabetList.contains(userInput) == false) {
                    System.out.println("You used this character already, please try again.");
                } else {
                    if(wordTokenized.contains(userInput)) {
                        for (int i=0; i<wordTokenized.size(); i++) {
                            if(wordTokenized.get(i).equals(userInput)) {
                                displayList.set(i, userInput);
                            }
                        }
                        //v code that removes a character from the alphabet array once it gets used v
                        alphabetList.remove(alphabetList.indexOf(userInput));
                    } else {
                        strikes += 1;
                        System.out.println("The hangman now has " + strikes + " body parts");
                        //v code that removes a character from the alphabet array once it gets used v
                        alphabetList.remove(alphabetList.indexOf(userInput));
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
    }
}
