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
    "country", "kitchen", "picture", "morning", "evening", "weather", "history", "problem", "question", "answer",
    "market", "doctor", "dinner", "travel", "summer", "winter", "flower", "bottle", "pencil", "planet",
    "river", "mountain", "island", "forest", "ocean", "bridge", "street", "castle", "rocket", "dragon",
    "orange", "banana", "cheese", "bread", "coffee", "butter", "pizza", "cookie", "chicken", "potato",
    "button", "mirror", "guitar", "camera", "phone", "laptop", "keyboard", "screen", "battery", "engine",
    "player", "winner", "monster", "knight", "wizard", "treasure", "shield", "sword", "arrow", "battle",
    "happy", "little", "simple", "strong", "yellow", "purple", "silver", "golden", "bright", "quiet",
    "dance", "sleep", "laugh", "write", "speak", "listen", "build", "think", "learn", "believe"
    };
        
        int life = 6;
        Random r = new Random();
        int n = r.nextInt(words.length);
        String secretWord = words[n];
        char[] discovered = new char[secretWord.length()];
        System.out.println(secretWord);

        for(int i = 0; i < secretWord.length(); i++){
            discovered[i] = '_';
        }
         for(int i = 0; i < discovered.length; i++){
            System.out.print(discovered[i]);
        }

        Scanner scan = new  Scanner(System.in); 
        char letra =  readLetter(scan);


        boolean found =  false;
        for(int i = 0; i < secretWord.length(); i++){
            if (secretWord.charAt(i) == letra) {
                discovered[i] = letra;
                found = true;
            }
        }
        if (found == false) {
            life--;  
        }

      
       
    }


    
    static char readLetter (Scanner scan ){
       
          while (true) {
            System.out.println("Escribe una letra : ");       
            String text = scan.nextLine();
            if (text.length() == 1 && Character.isLetter(text.charAt(0))) {
                return text.toLowerCase().charAt(0);
            }else{
                System.out.println("Error: escribe una sola letra ");
            }
             
        }
    }

    static  boolean isComplete (char[] discovered ){
        for(int i = 0; i < discovered.length; i ++){
            if (discovered[i] == '_') {
                return  false;
            }
        }
        return true;
    }
    
}