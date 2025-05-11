// basically be careful when using any, since you may get type errors
fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}

val strings = mutableListOf("abc", "bac")
// addAnswer(strings) <- runtime exception!


// Take the following:
open class Animal {
    fun feed() { /* ... */ }
}
class Herd<T : Animal> { // prepending `out` fixes the type mismatch below
    val size: Int get() = /* ... */ 0
        operator fun get(i: Int): T { /* ... */ }
}
fun feedAll(animals: Herd<Animal>) {
    for (i in 0..<animals.size) {
        animals[i].feed()
    }
}

class Cat : Animal() {
    fun cleanLitter() { /* ... */ }
}
fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0..<cats.size) {
        cats[i].cleanLitter()
    }
    feedAll(cats) // <- type mismatch!
}

// `out` basically indicates that it works for covariants (works here since Animal -> Cat)
// it should be put as the result type of a function (unless when inheriting with interface)

// contravariants are the opposite (ex: List<Animal> is a contravariant of List<Cat>


// There's also `*`, which is for types you don't know yet (!=Any?)
// There's also typealias, when you're too lazy to rewrite long generic types
typealias NameCombiner = (String, String, String, String) -> String
val authorsCombiner: NameCombiner = { a, b, c, d -> "$a et al." }
// ...for extra type safety, annotate with @JvmInline1