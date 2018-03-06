package Animals;

public class Cat extends Animal {
    private String BadHabits;

    public Cat(String name, Animals.Gender gender, String badHabits) {
        super(name, gender);
        BadHabits = badHabits;
    }

    public String getBadHabits() {

        return BadHabits;
    }

    private void setBadHabits(String badHabits) {
        BadHabits = badHabits;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", bad habits: %s", BadHabits.toLowerCase());
    }
}
