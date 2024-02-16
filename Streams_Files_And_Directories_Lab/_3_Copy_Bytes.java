package Streams_Files_And_Directories_Lab;

import java.io.*;
import java.util.Scanner;

public class _3_Copy_Bytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("copy-bytes-output.txt");

        int oneByte = inputStream.read();

        while (oneByte != -1) {

            if (oneByte == 32) {
                outputStream.write(' ');
            } else if (oneByte == 10) {
                outputStream.write('\n');
            } else {

                String message = String.valueOf(oneByte);

                for (char c : message.toCharArray()) {
                    outputStream.write(c);
                }

            }

            oneByte = inputStream.read();
        }

    }

}
