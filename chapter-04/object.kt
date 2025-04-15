// Singletons ensure only one instance of a class exist
data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
    override fun compare(p1: Person, p2: Person): Int =
        p1.name.compareTo(p2.name)
    }
}

class MyClass {
    companion object { // Only callable inside this exact instance of the class
        fun callMe() {
            println("Companion object called")
        }
    }
}

// Reimplementation of an older class with companion objects
class User private constructor(val nickname: String) {
    companion object {
        // Factory methods, can be invoked via the class name
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))

        fun newSocialUser(accountId: Int) =
            User(getNameFromSocialNetwork(accountId))
    }
}

fun main() {
    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))

    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
    val socialUser = User.newSocialUser(4)
    println(subscribingUser.nickname)

    // Anonymous objects: just omit its assignment
}
