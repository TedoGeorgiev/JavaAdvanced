package Streams_Files_and_Directories_Exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _9_Copy_a_Picture {
    public static void main(String[] args) {
        String input = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture_streams.jpg";
        String output = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\copyPicture.jpg";

        try(FileInputStream fileInputStream = new FileInputStream(input);
            FileOutputStream fileOutputStream = new FileOutputStream(output)) {

            int oneByte = fileInputStream.read();
            while (oneByte != -1) {
                fileOutputStream.write(oneByte);

                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
