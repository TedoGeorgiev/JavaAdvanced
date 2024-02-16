package Exams._8_Java_Advanced_Regular_Exam_22_October_2022.shelter;

public class Animal {

    private String name;
    private int age;
    private String caretaker;

    public Animal(String name, int age, String careTaker) {
        this.name = name;
        this.age = age;
        this.caretaker = careTaker;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCaretaker() {
        return caretaker;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", getName(), getAge(), getCaretaker());
    }

}
