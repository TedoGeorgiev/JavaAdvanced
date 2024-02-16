package Streams_Files_And_Directories_Lab;

import java.io.File;

public class _7_List_Files {
    public static void main(String[] args) {

        File folder = new File("Streams_Files_And_Directories_Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams");

        if (folder.exists()) {
            //съществува такъв файл
            if (folder.isDirectory()) {
                //файла е папка
                File [] allFiles = folder.listFiles();
                for (File file : allFiles) {
                    if (!file.isDirectory()) {
                        System.out.printf("%s: [%s]%n", file.getName(), file.length());
                    }
                }
            }
        }
    }
}
