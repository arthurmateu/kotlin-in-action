// NOTE: you can get every override here by just prepending `data`
// also, if you really need to make them `var`s, just add a copy method and modify that
class Customer(val name: String, val postalCode: Int) {
    // Easier debugging
    override fun toString() = "Customer(name=$name, postalCode=$postalCode)"

    // Easier comparison (in this case, if both customers have the same exact info)
    override fun equals(other: Any?): Boolean {
        // can be simplified to `other !is Customer`
        if (other == null || other !is Customer)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    // Allows for things to be hasheable
    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}

fun main() {
    val customer1 = Customer("Alice", 342562)
    println(customer1)
}
