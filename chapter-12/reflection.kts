// way to access object's properties and methods dynamically without knowing them
import kotlin.reflect.full.*

class Person(val name: String, val age: Int)

fun main() {
    val person = Person("Alice", 29)
    val kClass = person::class
    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) } // name and age
}

// full list of methods -> http://mng.bz/em4i