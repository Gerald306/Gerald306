import java.util.*;

public class TextAnalysisTool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User Input
        System.out.println("Please enter a paragraph of text:");
        String inputText = scanner.nextLine();

        // Character Count
        int characterCount = inputText.length();
        System.out.println("\nTotal number of characters: " + characterCount);

        // Word Count
        String[] words = inputText.split("\\s+");
        int wordCount = words.length;
        System.out.println("Total number of words: " + wordCount);

        // Most Common Character
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        for (char c : inputText.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) { // Consider only alphanumeric characters
                charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
            }
        }
        char mostCommonChar = '\0';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommonChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.println("Most common character: " + mostCommonChar);

        // Character Frequency
        System.out.println("\nEnter a character to check its frequency:");
        char targetChar = scanner.next().toLowerCase().charAt(0);
        int charFreq = charFrequency.getOrDefault(targetChar, 0);
        System.out.println("Frequency of '" + targetChar + "': " + charFreq);

        // Word Frequency
        System.out.println("\nEnter a word to check its frequency:");
        scanner.nextLine(); // Consume the leftover newline
        String targetWord = scanner.nextLine().toLowerCase();
        int wordFreq = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(targetWord)) {
                wordFreq++;
            }
        }
        System.out.println("Frequency of \"" + targetWord + "\": " + wordFreq);

        // Unique Words
        HashSet<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }
        System.out.println("Number of unique words: " + uniqueWords.size());

        System.out.println("\nThank you for using the Text Analysis Tool!");
        scanner.close();
    }
}
