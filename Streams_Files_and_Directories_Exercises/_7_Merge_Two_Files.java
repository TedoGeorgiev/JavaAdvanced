package Streams_Files_and_Directories_Exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _7_Merge_Two_Files {
    public static void main(String[] args) {

        String inputOne = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputTwo = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String output = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\merged.txt";

        try {
            BufferedReader firstReader = Files.newBufferedReader(Paths.get(inputOne));
            BufferedReader secondReader = Files.newBufferedReader(Paths.get(inputTwo));
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(output));

            String lineFirstFile = firstReader.readLine();
            while (lineFirstFile != null) {
                writer.write(lineFirstFile);
                writer.newLine();
                lineFirstFile = firstReader.readLine();
            }
            firstReader.close();

            String lineSecondFile = secondReader.readLine();
            while (lineSecondFile != null) {
                writer.write(lineSecondFile);
                writer.newLine();
                lineSecondFile = secondReader.readLine();
            }
            secondReader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
