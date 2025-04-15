class User(val nickname: String)
// Above and below are equal
class User constructor(nickname: String) { 
    // You may omit `constructor` if there's no annotations or visibility modifiers
    val nickname: String

    init { // This can also be done by assigning on the `nickname` declaration
        this.nickname = nickname
    }
}

class SocialUser(nickname: String): User(nickname) { /* ... */ }
// Note that generating without parenthesis, you have to explicitly invoke the constructor of the superclass even if it doesn't have any parameters.
// Interfaces don't need constructors (meaning you never put parenthesis after declaring it)
// If you want your class to not be instantiated, make the constructor private

// Kotlin recommends using default values instead of overloading functions

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User // primary constructor property

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@') // custom getter for its nickname
}

fun getNameFromSocialNetwork(accountId: Int) = "kodee$accountId"

class SocialUser(val accountId: Int) : User {
    override val nickname = getNameFromSocialNetwork(accountId) // property initializer
}

// Custom getters and setters. Note they inherit the visibility from the class, unless otherwise stated
class Person(var birthYear: Int) {
    var ageIn2050
        get() = 2050 - birthYear
        set(value) {
            birthYear = 2050 - value
        }
}

fun main() {
    println(PrivateUser("kodee".nickname)) // kodee
    println(SubscribingUser("test@kotlinlang.org").nickname) // test
    println(SocialUser(123).nickname) // kode123
}
