import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Animals.Gender;

import java.util.ArrayList;


public class Reservation {
    public ArrayList<Animal> getAnimals() {
        return Animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        Animals = animals;
    }

    private ArrayList<Animal> Animals= new ArrayList<>();

    public void NewCat(String name, Gender gender, String badHabits){
        Animals.add(new Cat(name, gender, badHabits));
    }

    public void NewDog(String name, Gender gender){
        Animals.add(new Dog(name,gender));
    }

}
