package Streams_Files_and_Directories_Exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class _6_Word_Count {
    public static void main(String[] args) {

        String input = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        Map<String, Integer> wordsMap = new HashMap<>();
        try { BufferedReader reader = Files.newBufferedReader(Paths.get(input));

            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordsMap.putIfAbsent(word, 0);
                }
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String secondInput = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String output = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\wrodsCounter.txt";

        try {BufferedReader reader = Files.newBufferedReader(Paths.get(secondInput));
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(output));

        String line = reader.readLine();
        while (line != null) {
            String [] words = line.split("\\s+");
            for (String word : words) {
                if (wordsMap.containsKey(word)) {
                    wordsMap.put(word, wordsMap.get(word) + 1);
                }
            }
            line = reader.readLine();
        }

            List<Map.Entry<String, Integer>> toSort = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
                toSort.add(entry);
            }
            toSort.sort(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)));
            for (Map.Entry<String, Integer> entry : toSort) {
                writer.write(String.format("%s - %d%n", entry.getKey(), entry.getValue()));
            }

            reader.close();
        writer.close();




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
