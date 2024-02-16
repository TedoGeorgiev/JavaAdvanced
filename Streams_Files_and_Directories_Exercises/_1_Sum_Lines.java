package Streams_Files_and_Directories_Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class _1_Sum_Lines {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> stringList = Files.readAllLines(Paths.get(path));

        stringList.forEach(l -> {
            int sum = 0;
            char[] chars = l.toCharArray();
            for (char ch : chars) {
                sum += ch;
            }
            System.out.println(sum);
        });




    }
}
