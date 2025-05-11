// You need to specify the type that a list holds when its empty
val javaFans: MutableList<String> = mutableListOf()
val javaFans2 = mutableListOf<String>() // another way

// otherwise, in functions, the type `T` is a generic that will infer the type
// (yes, you need the <T> before the class name)
val <T> List<T>.penultimate: T
    get() = this[size - 2]

println(listOf(1, 2, 3, 4).penultimate) // =3

// You can specify your generic too (if you don't, it assumes `Any?`). Mind the `?`
fun <T: Number> sumPairs(numList: List<T>): Long {
    var res = 0L

    for (n in numList) {
        // fun fact! mod in kotlin transforms everything into `int` and
        // changes back for the result!
        if (n.toLong() % 2 == 0L) {
            res += n.toLong()
        }
    }

    return res
}

print(sumPairs(listOf(1, 2, 3, 4, 5, 6))) // =12


// You can also specify further
fun <T: Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}
// as much as you need, really
fun <T> ensureTrailingPeriod(seq: T)
        where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

// there's also this
abstract class CoolList<T>: List<T> {
    fun put(t: T & Any) { /* ... */ }
    fun putIfNotNull(t: T) { /* ... */ }
}