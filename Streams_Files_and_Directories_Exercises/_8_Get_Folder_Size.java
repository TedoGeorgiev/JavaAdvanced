package Streams_Files_and_Directories_Exercises;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class _8_Get_Folder_Size {
    public static void main(String[] args) {

        String path = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(path);

        int sum = 0;

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();

            assert files != null;
            for (File file : files) {
                sum += (int) file.length();
            }
        }
        System.out.printf("Folder size: %d\n", sum);
    }
}
