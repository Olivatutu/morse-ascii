import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Character, String> mapaAsciiAMorse = new HashMap<>();
    private static final Map<String, Character> mapaMorseAAscii = new HashMap<>();

    static {
        mapaAsciiAMorse.put('a', ".-");
        mapaAsciiAMorse.put('b', "-...");
        mapaAsciiAMorse.put('c', "-.-.");
        mapaAsciiAMorse.put('d', "-..");
        mapaAsciiAMorse.put('e', ".");
        mapaAsciiAMorse.put('f', "..-.");
        mapaAsciiAMorse.put('g', "--.");
        mapaAsciiAMorse.put('h', "....");
        mapaAsciiAMorse.put('i', "..");
        mapaAsciiAMorse.put('j', ".---");
        mapaAsciiAMorse.put('k', "-.-");
        mapaAsciiAMorse.put('l', ".-..");
        mapaAsciiAMorse.put('m', "--");
        mapaAsciiAMorse.put('n', "-.");
        mapaAsciiAMorse.put('ñ', "-. -. --");
        mapaAsciiAMorse.put('o', "---");
        mapaAsciiAMorse.put('p', ".--.");
        mapaAsciiAMorse.put('q', "--.-");
        mapaAsciiAMorse.put('r', ".-.");
        mapaAsciiAMorse.put('s', "...");
        mapaAsciiAMorse.put('t', "-");
        mapaAsciiAMorse.put('u', "..-");
        mapaAsciiAMorse.put('v', "...-");
        mapaAsciiAMorse.put('w', ".--");
        mapaAsciiAMorse.put('x', "-..-");
        mapaAsciiAMorse.put('y', "-.--");
        mapaAsciiAMorse.put('z', "--..");

        mapaMorseAAscii.put(".-", 'a');
        mapaMorseAAscii.put("-...", 'b');
        mapaMorseAAscii.put("-.-.", 'c');
        mapaMorseAAscii.put("-..", 'd');
        mapaMorseAAscii.put(".", 'e');
        mapaMorseAAscii.put("..-.", 'f');
        mapaMorseAAscii.put("--.", 'g');
        mapaMorseAAscii.put("....", 'h');
        mapaMorseAAscii.put("..", 'i');
        mapaMorseAAscii.put(".---", 'j');
        mapaMorseAAscii.put("-.-", 'k');
        mapaMorseAAscii.put(".-..", 'l');
        mapaMorseAAscii.put("--", 'm');
        mapaMorseAAscii.put("-.", 'n');
        mapaMorseAAscii.put("-. -. --", 'ñ');
        mapaMorseAAscii.put("---", 'o');
        mapaMorseAAscii.put(".--.", 'p');
        mapaMorseAAscii.put("--.-", 'q');
        mapaMorseAAscii.put(".-.", 'r');
        mapaMorseAAscii.put("...", 's');
        mapaMorseAAscii.put("-", 't');
        mapaMorseAAscii.put("..-", 'u');
        mapaMorseAAscii.put("...-", 'v');
        mapaMorseAAscii.put(".--", 'w');
        mapaMorseAAscii.put("-..-", 'x');
        mapaMorseAAscii.put("-.--", 'y');
        mapaMorseAAscii.put("--..", 'z');
    }

    public static String convertirAMorse(String frase) {
        StringBuilder morse = new StringBuilder();
        String[] palabras = frase.split(" ");

        for (String palabra : palabras) {
            for (int i = 0; i < palabra.length(); i++) {
                char letra = palabra.charAt(i);
                String letraEnMorse = mapaAsciiAMorse.get(Character.toLowerCase(letra));
                if (letraEnMorse != null) {
                    morse.append(letraEnMorse);
                }
                if (i < palabra.length() - 1) {
                    morse.append(" ");
                }
            }
            morse.append("  ");
        }
        return morse.toString().trim();
    }

    public static String convertirAAscii(String morseCode) {
        StringBuilder asciiMessage = new StringBuilder();
        String[] palabras = morseCode.split("   ");

        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");
            for (String letra : letras) {
                asciiMessage.append(mapaMorseAAscii.getOrDefault(letra, '?'));
            }
            asciiMessage.append(" ");
        }
        return asciiMessage.toString().trim();
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Selecciona una opción: ");
        System.out.println("1 <- Convertir ASCII a Morse \n2 <- Convertir Morse a ASCII ");
        int opcion = teclado.nextInt();
        teclado.nextLine();

        switch (opcion){
            case 1:
                System.out.print("Introduce el texto a convertir en código Morse: ");
                String input = teclado.nextLine();
                String morseCode = convertirAMorse(input);
                System.out.println("Código Morse: " + morseCode);
                break;
            case 2:
                System.out.println("Introduce el mensaje en código Morse (usa un espacio entre letras y tres espacios entre palabras):");
                String morseInput = teclado.nextLine();
                String asciiMessage = convertirAAscii(morseInput);
                System.out.println("Mensaje en ASCII: " + asciiMessage);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        teclado.close();
    }
}
