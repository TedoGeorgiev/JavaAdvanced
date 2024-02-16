package Streams_Files_And_Directories_Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class _6_Sort_Lines {
    public static void main(String[] args) throws IOException {

        Path pathRead = Paths.get("C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path pathWrite = Paths.get("C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\sorted.txt");

        List<String> allLines = Files.readAllLines(pathRead);
        Collections.sort(allLines);
        Files.write(pathWrite, allLines);


    }
}
