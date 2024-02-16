package Streams_Files_and_Directories_Exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _1_Sum_Lines_BufferedReader {
    public static void main(String[] args) {

        String path = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";


        try {BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            String line = bufferedReader.readLine();
            while (line != null) {
                int sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
