fun twoAndThree(
    operation: (operandA: Int, operandB: Int) -> Int
) {
    val result = operation(2, 3)
    println("The result is $result")
}

// Taking a nullable-function as a parameter
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        val str = transform?.invoke(element)
        ?: element.toString()
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    val sum = { x: Int, y: Int -> x + y }
    val action = { println(42) }

    // You are required to indicate return type
    var canReturnNull: (Int, Int) -> Int? = { x, y -> null}
    var funOrNull: ((Int, Int) -> Int)? = null // Even further reduced

    // You're not forced to have the same parameter name as in the function definition
    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }
}

main()