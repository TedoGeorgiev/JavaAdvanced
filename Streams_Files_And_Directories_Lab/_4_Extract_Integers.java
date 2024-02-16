package Streams_Files_And_Directories_Lab;

import java.io.*;
import java.util.Scanner;

public class _4_Extract_Integers {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);

        FileOutputStream outputStream = new FileOutputStream("ExtractIntegers.txt");
        PrintWriter writer = new PrintWriter(outputStream);

        while (scanner.hasNext()) {

            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.println(number);
            }
            scanner.next();
        }
        writer.close();
        outputStream.close();
    }
}
