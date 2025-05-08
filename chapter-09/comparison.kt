data class Point(val x: Int, val y: Int) {
    // overrides equality operator
    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Point) return False
        return other.x == x && other.y == y
    }
}

class Person(val first: String, val last: String): Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::last, Person::first)
    }
}

fun main() {
    val pt1 = Point(1, 2)
    val pt2 = Point(3, 4)
    
    println(pt1 == pt1)
    println(pt1 == 1.5)
    println(pt1 == pt2)

    val pe1 = Person("Alice", "Smith")
    val pe2 = Person("Bob", "Johnson")
    println(pe1 < pe2)
}
