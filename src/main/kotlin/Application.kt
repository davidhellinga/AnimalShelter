package main.kotlin

import main.kotlin.animal.Cat
import main.kotlin.animal.Dog
import main.kotlin.animal.Gender
import main.kotlin.webshop.Product
import java.time.LocalDateTime

fun main() {
    val process = ApplicationProcess()
    process.run()
}

class ApplicationProcess() {
    companion object {
        val webshop = Webshop()
    }

    fun run() {
        val dog1 = Dog("Timmy", Gender.Male)

        val dog2 = Dog("Jimmy", Gender.Male)

        val dog3 = Dog("Mimsy", Gender.Male)
        val cat = Cat("Purrfect", Gender.Female, "Arrogant", 50.0)
        val catto = Cat("Purrfect", Gender.Female, "Gangsta")

        dog1.reserve("Johnathan van de Graaf")
        cat.reserve("Betty de Wit", LocalDateTime.now().minusDays(30))

        cat.reserve("Betty de Swart", LocalDateTime.now().minusDays(20))

        println(dog1)
        println(dog2)
        println(dog3)

        println(cat)
        println(catto)

        webshop.addProduct(Product("Dogfood", 2.0))
        webshop.addProduct(Product("Catnip", 10.0))

        println(webshop.getProducts().toString())
    }
}
