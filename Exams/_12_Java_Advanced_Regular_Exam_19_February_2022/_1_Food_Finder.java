package Exams._12_Java_Advanced_Regular_Exam_19_February_2022;

import java.util.*;
import java.util.stream.Collectors;

public class _1_Food_Finder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] words = {"pear", "flour", "pork", "olive"};
        String [] foundWords = {"****", "*****", "****", "*****"};

        Deque<Character> vowelsQueue = new ArrayDeque<>();
        Deque<Character> consonantStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e -> vowelsQueue.offer(e.charAt(0)));
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e -> consonantStack.push(e.charAt(0)));

        while (!consonantStack.isEmpty()) {
            char vowel = vowelsQueue.poll();
            char consonant = consonantStack.pop();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int indexVowel = word.indexOf(vowel);
                int indexConsonant = word.indexOf(consonant);
                if (indexVowel >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexVowel) + vowel + foundWords[i].substring(indexVowel + 1);
                }
                if (indexConsonant >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexConsonant) + consonant + foundWords[i].substring(indexConsonant + 1);
                }
            }
            vowelsQueue.offer(vowel);
        }

        List<String> output = Arrays.stream(foundWords).filter(w -> !w.contains("*")).collect(Collectors.toList());
        System.out.printf("Words found: %d%n", output.size());
        output.forEach(System.out::println);

    }
}