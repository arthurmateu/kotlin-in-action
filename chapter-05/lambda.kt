data class Person(val name: String, val age: Int)

fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.maxByOrNull(Person::age)) // max by age. represents class::member
    // Can also be rewriten as such
    people.maxByOrNull() { p: Person -> p.age } // {x, y -> x + y} is the lambda func
    // Can be inside the parenthesis, outside or if its the only element, directly
    // Many use { it.{something} } as syntactic sugar to skip the parameter definition

    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error:")
}

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    var count = 1
    messages.forEach {
        println("$prefix $it") // The `it` would be each message from messages
        count++ // You can also modify variables from within the lambda
    }
}
