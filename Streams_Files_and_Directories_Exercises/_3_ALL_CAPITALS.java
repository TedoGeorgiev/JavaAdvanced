package Streams_Files_and_Directories_Exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _3_ALL_CAPITALS {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\ToUpper.txt";

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath));

            String line = reader.readLine();

            while (line != null) {
                writer.write(line.toUpperCase());
                writer.newLine();

                line = reader.readLine();
            }
            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
