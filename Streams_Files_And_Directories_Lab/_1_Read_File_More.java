package Streams_Files_And_Directories_Lab;

import java.io.FileInputStream;

import java.io.IOException;

public class _1_Read_File_More {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int oneByte = inputStream.read();
        while (oneByte >= 0) {
            System.out.print(Integer.toBinaryString(oneByte) + " ");

            oneByte = inputStream.read();
        }

    }
}
