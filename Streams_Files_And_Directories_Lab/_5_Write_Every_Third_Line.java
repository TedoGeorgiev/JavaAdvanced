package Streams_Files_And_Directories_Lab;

import java.io.*;

import java.util.Scanner;

public class _5_Write_Every_Third_Line {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);

        FileOutputStream outputStream = new FileOutputStream("write3rdLines.txt");
        PrintWriter writer = new PrintWriter(outputStream);

        int count = 1;
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            if (count % 3 == 0) {
                writer.println(line);
            }
            count++;

        }
        writer.close();
        outputStream.close();
        scanner.close();
    }
}
