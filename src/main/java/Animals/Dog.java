package Animals;


import java.time.LocalDate;

public class Dog extends Animal {
    private LocalDate LastWalk;

    public Dog(String name, Animals.Gender gender) {
        super(name, gender);
        LastWalk = LocalDate.now();
    }

    public LocalDate getLastWalk() {

        return LastWalk;
    }

    private void setLastWalk(LocalDate lastWalk) {
        LastWalk = lastWalk;
    }

    public boolean NeedsWalk(){
        int temp1=LocalDate.now().compareTo(LastWalk);
        boolean temp2=temp1==1;

        return (temp2);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", last walk: %s", LastWalk);
    }
}
