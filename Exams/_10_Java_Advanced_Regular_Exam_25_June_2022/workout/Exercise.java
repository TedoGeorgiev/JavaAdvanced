package Exams._10_Java_Advanced_Regular_Exam_25_June_2022.workout;

public class Exercise {
    private String name;
    private String muscle;
    private int burnedCalories;

    public Exercise (String name, String muscle, int burnedCalories) {
        this.name = name;
        this.muscle = muscle;
        this.burnedCalories = burnedCalories;
    }

    public String getName() {
        return this.name;
    }

    public String getMuscle() {
        return this.muscle;
    }

    public int getBurnedCalories() {
        return this.burnedCalories;
    }

    @Override
    public String toString() {
        return String.format("Exercise: %s, %s, %d",
                this.getName(), this.getMuscle(), this.burnedCalories);
    }

}
