fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull() // Removes null values
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}

fun main() {
    // Collections:
    // Types: list, set, map
    // Read-only -> typeOf
    // Mut lists -> mutableListOf, MutableList, arrayListOf, buildList
    // Mut set/maps -> mutableTypeOf, hashTypeOf, linkedTypeOf, sortedTypeOf, buildType
    // Note that Java can modify the collection, even if its read-only

    // You can also just make `<Type>Array(<size>)` (ex: `UIntArray(5)`)
}
