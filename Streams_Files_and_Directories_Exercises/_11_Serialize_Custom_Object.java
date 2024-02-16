package Streams_Files_and_Directories_Exercises;

import java.io.*;

public class _11_Serialize_Custom_Object {
    public static void main(String[] args) {

        Course course = new Course("Java Advanced", 100);
        Course course1 = new Course("Java OOP", 100);

        String path = "C:\\Users\\bgtgeorgiev.B01.000\\IdeaProjects\\JAVA_Advanced\\Streams_Files_and_Directories_Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser";

        try (
             FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {

            //сериализираме
            objectOutputStream.writeObject(course);

            //десериализарме

            Course deserializedCourse = (Course) objectInputStream.readObject();

            System.out.println();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}


