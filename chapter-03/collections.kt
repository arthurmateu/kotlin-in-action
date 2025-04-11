fun main() {
    val set = setOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three") // pretty ugly tbh

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
    // Although Java Classes, Kotlin seems to give more methods

    println(joinToString(list, "; ", "(", ")"))

    println("Kotlin".lastChar())

    // Pair initialization
    val (number, name) = 1 to "one"
}

// Since Java doesn't have default parameter values, you will have to annotate with `@JvmOverloads`
fun <T> Collection<T>.joinToString(
    separator: String = ", ", // Default values
    prefix: String = "",
    postfix: String = ""
): String {
    val res = StringBuilder(prefix)
    
    for ((i, e) in collection.withIndex()) {
        if (index > 0) res.append(separator)
        res.append(element)
    }

    res.append(postfix)
    return res.toString()
}


// Basically extends a method into a class. Can't break incapsulation though
// String is the receiver type, and `this` is the receiver object
fun String.lastChar(): Char = this.get(this.length - 1)
// You can extend properties too
val String.lastChar: Char
    get() = this.get(length - 1)
// ...and mutate it!
var StringBuilder.lastChar: Char
    get() = this.get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }


fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)


open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}

fun listOf<T>(vararg values: T): List<T> { /* arbitrary number of arguments, gets called with *args to spread */}
