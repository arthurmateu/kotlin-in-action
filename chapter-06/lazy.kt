class Person(val name: String, val age: Int)

fun main() {
    val people = listOf(
        Person("Joe", 22),
        Person("Mary", 31),
        Person("Jamie", 22)
    )

    // Instead of using .map().filter(), using sequences avoids having to create intermediary collections, improving performance
    // .map().filter() -> eager
    // .asSequence() <...> .toList() -> lazy
    people
        .asSequence()
        .map(Person::name)
        .filter { it.startsWith("A") }
        .toList() 

    // sequences (read as iterators). things wont get calculated until you ask for it
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum()) 
}
