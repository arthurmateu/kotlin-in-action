// Note that the package system of organizing file works here too, so you'd need to state these classes as `package something.else` and import packages too
// Similar system to Java, but follow that system loosely, since you can have multiple small classes in one package

class Person(
    val name: String,
    var isStudent: Boolean
)

class Rectangle(val height: Int, val width: Int) {
    val isSquare get() = height == width
}

fun main() {
    val person = Person("Bob", true)

    println(person.name)

    println(person.isStudent)
    person.isStudent = false
    println(person.isStudent)

    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
)
