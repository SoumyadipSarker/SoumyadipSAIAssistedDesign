package MorseCodeConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DefaultMorseCodeConverter {
    private static final Map<String, String> morseToText = new HashMap<>();
    private static final Map<String, String> textToMorse = new HashMap<>();

    static {
        // Morse code to text mappings
        morseToText.put(".-", "A");
        morseToText.put("-...", "B");
        morseToText.put("-.-.", "C");
        morseToText.put("-..", "D");
        morseToText.put(".", "E");
        morseToText.put("..-.", "F");
        morseToText.put("--.", "G");
        morseToText.put("....", "H");
        morseToText.put("..", "I");
        morseToText.put(".---", "J");
        morseToText.put("-.-", "K");
        morseToText.put(".-..", "L");
        morseToText.put("--", "M");
        morseToText.put("-.", "N");
        morseToText.put("---", "O");
        morseToText.put(".--.", "P");
        morseToText.put("--.-", "Q");
        morseToText.put(".-.", "R");
        morseToText.put("...", "S");
        morseToText.put("-", "T");
        morseToText.put("..-", "U");
        morseToText.put("...-", "V");
        morseToText.put(".--", "W");
        morseToText.put("-..-", "X");
        morseToText.put("-.--", "Y");
        morseToText.put("--..", "Z");
        morseToText.put(".----", "1");
        morseToText.put("..---", "2");
        morseToText.put("...--", "3");
        morseToText.put("....-", "4");
        morseToText.put(".....", "5");
        morseToText.put("-....", "6");
        morseToText.put("--...", "7");
        morseToText.put("---..", "8");
        morseToText.put("----.", "9");
        morseToText.put("-----", "0");
        morseToText.put(".-.-.-", ".");
        morseToText.put("--..--", ",");
        morseToText.put("..--..", "?");
        morseToText.put("-.-.--", "!");
        morseToText.put("-....-", "-");
        morseToText.put("-.--.", "(");
        morseToText.put("-.--.-", ")");
        morseToText.put(".----.", "'");
        morseToText.put("-..-.", "/");
        morseToText.put(".-..-.", "\"");
        morseToText.put("---...", ":");
        morseToText.put("-.-.-.", ";");
        morseToText.put("...-..-", "$");
        morseToText.put(".-...", "&");
        morseToText.put(".--.-.", "@");
        morseToText.put(".-.-.", "+");
        morseToText.put("..--.-", "_");
        //morseToText.put("\n", "\n");

        // Text to Morse code mappings
        for (Map.Entry<String, String> entry : morseToText.entrySet()) {
            textToMorse.put(entry.getValue(), entry.getKey());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Morse Code Converter");
        System.out.println("--------------------");
        System.out.println("1. Text to Morse code");
        System.out.println("2. Morse code to Text");
        System.out.println("--------------------");
        System.out.print("Enter your choice (1-2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.println("Enter multiple lines of text to convert to Morse code. Enter 'q' to quit:");
                StringBuilder convertedMText = new StringBuilder();
                while (true) {
                    String line = scanner.nextLine().toUpperCase();
                    if (line.equalsIgnoreCase("q")) {
                        break;
                    }
                    convertedMText.append(convertTextToMorse(line.toString().trim())).append("\n");
                }
                convertedMText.deleteCharAt(convertedMText.length()-1);
                System.out.println("Morse code:\n" + convertedMText);
                //String morseCode = convertedText(inputText.toString().trim());
                //System.out.println("Morse code:\n" + morseCode);
                break;

            case 2:
                System.out.println("Enter Morse code to convert to text. Enter 'q' to quit:");
                //String inputMorse = "";
                StringBuilder convertedText = new StringBuilder();
               while (true) {
                    String line = scanner.nextLine();
                    if (line.equalsIgnoreCase("q")) {
                        break;
                    }
                    //inputMorse = line + "\n";
                    convertedText.append(convertMorseToText(line.toString().trim()));
                    convertedText.append("\n");
                }
                //convertedText = new StringBuilder(convertMorseToText(inputMorse.toString().trim()));
                convertedText.deleteCharAt(convertedText.length()-1);
                System.out.println("Text:\n" + convertedText);
                break;

            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }

        scanner.close();
    }

    public static String convertTextToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        boolean flag = false;
        for (char c : text.toUpperCase().toCharArray()) {
            String character = String.valueOf(c);
            if (textToMorse.containsKey(character)) {
                flag = false;
                morseCode.append(textToMorse.get(character)).append(" ");
            } else if ((character.equals(" ") && !flag)) {
                flag = true;
                morseCode.append("/ ");
            }
        }
        return morseCode.toString().trim();
    }

    public static String convertMorseToText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] words = morse.split("\\s+/\\s+");
        for (String word : words) {
            String[] letters = word.split("\\s+");
            for (String letter : letters) {
                if (morseToText.containsKey(letter)) {
                    text.append(morseToText.get(letter));
                }
            }
            text.append(" ");
        }
        return text.toString().trim();
    }
}
