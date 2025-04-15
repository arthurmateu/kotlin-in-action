fun alphabet(): String {
    val result = StringBuilder()

    return with(result) { // Avoids having to repeat result many times over
        // You can even just not declare a `result` variable and just start with `StringBuilder()`
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nNow I know the alphabet!") // You can even just ignore the `this.` part!
        toString()
    }
}

// `apply` works almost exactly like with()
// ...it's mostly used to declare variables right away, though
// Finally, there's a shortcut for `StringBuilder().apply`, being `buildString`
// and it also works for other collections (buildList, buildSet, ...)
fun alphabet2() = StringBuilder().apply { 
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()

fun main() {
    println(alphabet())
    println(alphabet2())
    println(alphabet().also { println(it) }) // `also` lets to do extra actions
}
