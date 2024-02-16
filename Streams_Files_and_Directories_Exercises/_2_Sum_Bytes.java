package Streams_Files_and_Directories_Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _2_Sum_Bytes {
    public static void main(String[] args) {

        String path = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try {BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path));
            String line = bufferedReader.readLine();
            int sum = 0;

            while (line != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                line = bufferedReader.readLine();
            }

            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
