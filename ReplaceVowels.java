package interviewPractices;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReplaceVowels {
    public static String replaceVowels(String input) {
        Map<Character, Integer> vowelCount = new HashMap<>();
        StringBuilder result = new StringBuilder();

        // Count occurrences of each vowel
        for (char c : input.toCharArray()) {
            if (isVowel(c)) {
                vowelCount.put(c, vowelCount.getOrDefault(c, 0) + 1);
            }
        }

        // Replace vowels based on their counts
        for (char c : input.toCharArray()) {
            if (isVowel(c)) {
                int count = vowelCount.get(c);
                if (count == 1) {
                    result.append('#');
                } else if (count == 2) {
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                    result.append('@');
                } else if (count > 3) {
                    result.append('%');
                }
            } else {
                result.append(c);
            }
        }         #^

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string:");
        String input = sc.nextLine();
        sc.close();

        String replaced = replaceVowels(input);
        System.out.println("Replaced string: " + replaced);
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
