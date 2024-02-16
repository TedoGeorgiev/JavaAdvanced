package Streams_Files_And_Directories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class _5_Write_Every_Third_Line_Mentor {
    public static void main(String[] args) throws FileNotFoundException {

        String readFile = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_And_Directories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writeFile = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\write3rd_buffered_reader.txt";

        FileInputStream inputStream = new FileInputStream(readFile);
        FileOutputStream outputStream = new FileOutputStream(writeFile);

        Scanner reader = new Scanner(inputStream);
        PrintWriter printWriter = new PrintWriter(outputStream);

        int count = 1;
        String line = reader.nextLine();
        while (reader.hasNextLine()) {
            if (count % 3 == 0) {
                printWriter.println(line);
            }
            count++;
            line = reader.nextLine();
        }

        reader.close();
        printWriter.close();
    }
}
