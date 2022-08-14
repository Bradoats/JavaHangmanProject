public class hangmanASCII {
    public static void printArt(int strikes) {
        if(strikes == 0) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        }
        if(strikes == 1) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        }
        if(strikes == 2) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println("  |   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        }
        if(strikes == 3) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        }
        if(strikes == 4) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|\\  |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        }
        if(strikes == 5) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|\\  |");
            System.out.println(" /    |");
            System.out.println("      |");
            System.out.println("=========");
        }
        if(strikes == 6) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|\\  |");
            System.out.println(" / \\  |");
            System.out.println("      |");
            System.out.println("=========");
        }
    }
}
