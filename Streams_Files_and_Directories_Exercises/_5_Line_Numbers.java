package Streams_Files_and_Directories_Exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _5_Line_Numbers {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Lines_withNumbers.txt";


        try {BufferedReader bf = Files.newBufferedReader(Paths.get(inputPath));
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath));
            String line = bf.readLine();
            int counter = 1;
            while (line != null) {
                writer.write(String.format("%d. %s%n", counter, line));
                counter++;

                line = bf.readLine();
            }
            bf.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
