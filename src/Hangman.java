import java.util.Random;
import java.util.Scanner;

/**
 * hangman
 */
public class Hangman {
    public static void main(String[] args) {
        String[] words = {
                "house", "water", "apple", "music", "table", "chair", "money", "world", "family", "school",
                "friend", "garden", "window", "animal", "letter", "mother", "father", "people", "number", "office",
                "country", "kitchen", "picture", "morning", "evening", "weather", "history", "problem", "question",
                "answer",
                "market", "doctor", "dinner", "travel", "summer", "winter", "flower", "bottle", "pencil", "planet",
                "river", "mountain", "island", "forest", "ocean", "bridge", "street", "castle", "rocket", "dragon",
                "orange", "banana", "cheese", "bread", "coffee", "butter", "pizza", "cookie", "chicken", "potato",
                "button", "mirror", "guitar", "camera", "phone", "laptop", "keyboard", "screen", "battery", "engine",
                "player", "winner", "monster", "knight", "wizard", "treasure", "shield", "sword", "arrow", "battle",
                "happy", "little", "simple", "strong", "yellow", "purple", "silver", "golden", "bright", "quiet",
                "dance", "sleep", "laugh", "write", "speak", "listen", "build", "think", "learn", "believe"
        };

        // scanner
        Scanner scan = new Scanner(System.in);
        String playAgain = "";
        do {
            playGame(scan, words);
            System.out.println("Play again? (y/n)");
            playAgain = scan.nextLine();
        } while (playAgain.equalsIgnoreCase("y"));

        scan.close();
    }

    static void playGame(Scanner scan, String[] words) {
        int lives = 6;
        String secretWord = chooseWord(words);
        String usedLetters = "";
        // relleno de palabra secreta
        char[] discovered = new char[secretWord.length()];
        for (int i = 0; i < secretWord.length(); i++) {
            discovered[i] = '_';
        }

        while (!isComplete(discovered) && lives > 0) {
            drawHangman(lives);

            showState(discovered, lives);

            char letter = readLetter(scan);

            if (usedLetters.contains("" + letter)) {
                System.out.println("You already tried that letter.");
                continue;
            }
            usedLetters += letter;
            if (!checkLetter(discovered, letter, secretWord)) {
                lives--;
            }

        }

        if (isComplete(discovered)) {
            String livesWord = lives == 1 ? "life" : "lives";
            System.out.println("Congratulations, you won! The word was: " + secretWord + ". You had " + lives + " "
                    + livesWord + " left.");

        } else {
            drawHangman(lives);
            System.out.println("You lost! You ran out of lives. The word was: " + secretWord + ".");

        }

    }

    static String chooseWord(String[] words) {
        Random r = new Random();
        int n = r.nextInt(words.length);
        return words[n];
    }

    static void showState(char[] discovered, int lives) {
        System.out.printf("Lives: %d %n", lives);

        for (int i = 0; i < discovered.length; i++) {
            System.out.print(discovered[i] + " ");
        }
    }

    static boolean checkLetter(char[] discovered, char letter, String secretWord) {
        boolean found = false;

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                discovered[i] = letter;
                found = true;
            }
        }
        return found;
    }

    static char readLetter(Scanner scan) {

        while (true) {
            System.out.printf("%nEnter a letter:  %n");
            String text = scan.nextLine();
            if (text.length() == 1 && Character.isLetter(text.charAt(0))) {
                return text.toLowerCase().charAt(0);
            } else {
                System.out.println("Error: please enter a single letter.");
            }

        }
    }

    static boolean isComplete(char[] discovered) {
        for (int i = 0; i < discovered.length; i++) {
            if (discovered[i] == '_') {
                return false;
            }
        }
        return true;
    }

    static void drawHangman(int lives) {
        switch (lives) {
            case 1 -> {
                System.out.println("""
                           +---+
                           |   |
                           O   |
                          /|\\  |
                            \\  |
                        =========""");
            }
            case 2 -> {
                System.out.println("""
                           +---+
                           |   |
                           O   |
                          /|\\  |
                               |
                        =========""");
            }
            case 3 -> {
                System.out.println("""
                           +---+
                           |   |
                           O   |
                           |\\  |
                               |
                        =========""");
            }
            case 4 -> {
                System.out.println("""
                           +---+
                           |   |
                           O   |
                           |   |
                               |
                        =========""");
            }

            case 5 -> {
                System.out.println("""
                           +---+
                           |   |
                           O   |
                               |
                               |
                        =========""");
            }

            case 6 -> {
                System.out.println("""
                           +---+
                           |   |
                               |
                               |
                               |
                        =========""");
            }

            case 0 -> {
                System.out.println("""
                           +---+
                           |   |
                           O   |
                          /|\\  |
                          / \\  |
                        =========""");
            }

            default -> {

            }
        }

    }

}