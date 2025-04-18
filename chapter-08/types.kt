fun main() {
    val percent = 58.coerceIn(0, 100) // You can call methods on integers
    println(percent)

    // Numbers:
    // Integers  -> Byte, Short, Int and Long
    // Floating  -> Float and Double
    // Misc      -> Char and Boolean
    // ... note you can prepend `U` to actual numbers to make them unsigned

    val i: Int = 1
    val j: Long = i.toLong() // You need to convert explicitly

    // Any/?   -> Root of Kotlin's type hierarchy
    // Unit    -> Same as Java's `void`
    // Nothing -> No return from a function/Throws an exception
}
