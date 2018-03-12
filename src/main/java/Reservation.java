import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Animals.Gender;

import java.util.ArrayList;
import java.util.Observable;

public class Reservation extends Observable{

    public ArrayList<Animal> getAnimals() {
        return Animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        Animals = animals;
    }

    private ArrayList<Animal> Animals= new ArrayList<>();

    public void NewCat(String name, Gender gender, String badHabits){
        Animals.add(new Cat(name, gender, badHabits));
        Notify();
    }

    private void Notify() {
        setChanged();
        notifyObservers();
    }

    public void NewDog(String name, Gender gender){
        Animals.add(new Dog(name,gender));
        Notify();
    }

}
