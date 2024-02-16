package Streams_Files_and_Directories_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class _4_Count_Character_Types {
    public static void main(String[] args) {

        String input = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";


        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuations = Set.of('!', ',', '.', '?');

        try {BufferedReader bf = Files.newBufferedReader(Paths.get(input));

            int countVowels = 0;
            int countPunctuations = 0;
            int others = 0;
            String line = bf.readLine();
            while (line != null) {
                for (char ch : line.toCharArray()) {
                    if (vowels.contains(ch)) {
                        countVowels++;
                    } else if (punctuations.contains(ch)) {
                        countPunctuations++;
                    } else {
                        if (ch != ' ') {
                            others++;
                        }
                    }
                }


                line = bf.readLine();
            }

            System.out.printf("Vowels: %d%n", countVowels);
            System.out.printf("Other symbols: %d%n", others);
            System.out.printf("Punctuation: %d%n", countPunctuations);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
