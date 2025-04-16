class Person(val name: String, val age: Int)
class Book(val title: String, val authors: List<String>)

fun main() {
    val list = listOf(1, 2, 3, 4)

    // like other languages, you can chain these
    println(list.filter { it % 2 == 0 }) // like every filter, an element passes if its true. there's also filterNot
    println(list.map { it * it }) // like every map, it applies a function to every element
    // there's also mapIndexed and filterIndexed (for some reason)

    val summed = list.reduce { acc, element -> // like every reduce, it works
        acc + element // acc = accumulator
    }
    println(summed)

    val people = listOf(
        Person("Alex", 29),
        Person("Natalia", 28)
    )
    // fold is similar to reduce, but it allows you to declare the accumulator
    val folded = people.fold("") { acc, person ->
        acc + person.name
    }
    println(folded)
    // theres also runningReduce and runningFold (=read as doing prefix sums)
    
    // you can assume what these mean
    println(people.all() { it.age <= 27 }) // remember you can prepend a `!` to negate
    // note that .all() returns true if a list is empty
    println(people.any() { it.name == "John" })
    println(people.none() { it.name == "Johnny" })
    println(people.count() { it.age < 30 }) // better than `filter().size`
    println(people.find() { it.name == "Alex" })

    // spliting
    val (aboveTwentyNine, belowTwentyNine) = people.partition() { it.age > 29 }
    println(people.groupBy { it.age }) // returns a map where key=age, val=list<T>

    // transforming to maps. note that collisions will overwrite stuff
    val nameToAge = people.associate { it.name to it.age }
    // associateWith -> uses the original elements of collection as keys
    // associateBy   -> the opposite from associateWith
    
    // replacing
    val names = mutableListOf("Martin", "Samuel")
    names.replaceAll { it.uppercase() }
    names.fill("(redacted)")

    val empty = emptyList<String>()
    val full = listOf("apple", "orange", "banana")
    println(empty.ifEmpty { listOf("no", "values", "here") }) // modifies it
    println(full.ifEmpty { listOf("no", "values", "here") }) // doesn't
    // there's also ifBlank

    // sliding window splitting
    val temperatures = listOf(27.7, 29.8, 22.0, 35.5, 19.1)
    println(temperatures.windowed(3))
    println(temperatures.windowed(3) { it.sum() / it.size }) // also performs average
    // chunked doesn't slide
    println(temperatures.chunked(2))

    // zip is just like python
    val names = listOf("Joe", "Mary", "Jamie")
    val ages = listOf(22, 31, 31, 44, 0)
    println(names.zip(ages)) // ignores [44, 0]
    println(names.zip(ages} { name, age -> Person(name, age) }) // you can specify too
    println(names zip ages) // syntactic sugar
    val countries = listOf("DE", "NL", "US")
    println(names zip ages zip countries) // note that it always creates pairs

    val library = listOf(
        Book("Kotlin in Action", listOf("Isakova", "Elizarov", "Aigner", "Jemerov")),
        Book("Atomic Kotlin", listOf("Eckel", "Isakova")),
        Book("The Three-Body Problem", listOf("Liu"))
    )
    // flatMap does what it sounds: it flattens (=removes nesting) a map
    val authors = library.flatMap { it.authors }.toSet() // toSet() to avoid repeats
}
