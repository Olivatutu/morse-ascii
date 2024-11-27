import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Character> morseToAsciiMap = new HashMap<>();
        morseToAsciiMap.put(".-", 'A'); morseToAsciiMap.put("-...", 'B'); morseToAsciiMap.put("-.-.", 'C');
        morseToAsciiMap.put("-..", 'D'); morseToAsciiMap.put(".", 'E'); morseToAsciiMap.put("..-.", 'F');
        morseToAsciiMap.put("--.", 'G'); morseToAsciiMap.put("....", 'H'); morseToAsciiMap.put("..", 'I');
        morseToAsciiMap.put(".---", 'J'); morseToAsciiMap.put("-.-", 'K'); morseToAsciiMap.put(".-..", 'L');
        morseToAsciiMap.put("--", 'M'); morseToAsciiMap.put("-.", 'N'); morseToAsciiMap.put("---", 'O');
        morseToAsciiMap.put(".--.", 'P'); morseToAsciiMap.put("--.-", 'Q'); morseToAsciiMap.put(".-.", 'R');
        morseToAsciiMap.put("...", 'S'); morseToAsciiMap.put("-", 'T'); morseToAsciiMap.put("..-", 'U');
        morseToAsciiMap.put("...-", 'V'); morseToAsciiMap.put(".--", 'W'); morseToAsciiMap.put("-..-", 'X');
        morseToAsciiMap.put("-.--", 'Y'); morseToAsciiMap.put("--..", 'Z');


        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el mensaje en código Morse (usa espacios entre letras y tres espacios entre palabras):");
        String morseCode = scanner.nextLine();
        scanner.close();

        StringBuilder asciiMessage = new StringBuilder();
        String[] words = morseCode.split("   ");

        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                asciiMessage.append(morseToAsciiMap.getOrDefault(letter, '?'));
            }
            asciiMessage.append(" ");
        }

        System.out.println("Mensaje en ASCII: " + asciiMessage.toString().trim());
    }
}
