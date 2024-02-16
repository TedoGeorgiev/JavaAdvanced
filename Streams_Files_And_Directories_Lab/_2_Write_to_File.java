package Streams_Files_And_Directories_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Set;

public class _2_Write_to_File {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        Set<Character> punctuations = Set.of(',', '.', '!', '?');

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("write-to-file-txt");
        int oneByte = inputStream.read();

        while (oneByte >= 0) {
            char symbol = (char) oneByte;

            if (!punctuations.contains(symbol)) {
                outputStream.write(symbol);
            }

            oneByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
