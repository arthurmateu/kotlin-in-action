fun strLen(s: String) = s.length

fun printAllCaps(str: String?) {
    val allCaps: String? = str?.uppercase() // will perform operation if not null
    println(allCaps)
}

class Address(val streetAddress: String, val zipCode: Int,
    val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun Person.countryName(): String {
    // returns first value if its not null
    return this.company?.address?.country ?: "Unknown"
    // This operator also allows to go throw an error
}

fun main() {
    strLen(null) // errors at compile time, because String doesn't accept non-null
    // If you need to accept non-nulls, the typing becomes `Type?` (and the func needs
    // to properly handle the null case)

    printAllCaps("abc")
    printAllCaps(null)

    val person = Person("Dmitry", null)
    println(person.countryName()) // Unknown

    // Casting
    // use `<castee> as? <Cast>` -> only does if castee is Cast

    // Non-null assertion -> `str!!` <- gets a runtime exception
    // not really good code. avoid using more than once.

    // `let` calls a function if a value is non-null
    var abc: String? = "abc"
    println(abc?.let { it.uppercase() })
    // x.let { ... }    -> access via `it`  -> returns result of lambda -> safe call
    // x.also { ... }   -> access via `it`  -> returns x                -> additional
    // x.apply { ... }  -> access via `this`-> returns x                -> builder API
    // x.run { ... }    -> access via `this`-> returns result of lambda -> config
    // with(x) { ... }  -> access via `this`-> returns result of lambda -> multiple

    // You can apply the `lateinit` modifier to a variable
}
