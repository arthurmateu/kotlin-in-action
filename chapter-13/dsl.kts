// basically declarative languages like sql and regex, where you only declare the result you want
// more expressive APIs

// invoker = what happens when you call something
class Greeter(val greeting: String) {
    operator fun invoke(name: String) {
        println("$greeting, $name!")
    }
}
fun main() {
    val bavarianGreeter = Greeter("Servus")
    bavarianGreeter("Dmitry") // Servus, Dmitry!
}