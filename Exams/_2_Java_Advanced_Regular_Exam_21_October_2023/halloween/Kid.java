package Exams._2_Java_Advanced_Regular_Exam_21_October_2023.halloween;

public class Kid {

    private  String name;
    private  int age;
    private  String street;

    public Kid(String name, int age, String street) {
        this.name = name;
        this.age = age;
        this.street = street;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStreet() {
        return street;
    }


    @Override
    public String toString() {
        return String.format("%s, %d years old, from %s", this.name, this.age, this.street);
    }
}
