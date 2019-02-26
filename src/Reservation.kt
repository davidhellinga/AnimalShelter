import animal.Animal
import animal.Cat
import animal.Dog
import animal.Gender

class Reservation() {
    var animals: MutableList<Animal> = ArrayList()
        private set

    fun NewCat(name: String, gender: Gender, badHabits: String, price: Double) =
        animals.add(Cat(name, gender, badHabits, price))

    fun NewDog(name: String, gender: Gender, price: Double) = animals.add(Dog(name, gender, price))
}