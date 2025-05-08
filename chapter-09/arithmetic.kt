data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun Point.times(scale: Double): Point {
        // Doesn't support commutativity (aka swap left and right side for same result)
        return Point((x*scale).toInt(), (y*scale).toInt())
    }

    operator fun Point.unaryMinus(): Point {
        return Point(-x, -y)
    }
}

// Each one could've also been declared as follows
// operator fun Point.plus(other: Point): Point = Point(x + other.x, y + other.y)



// Other arithmethic operators -> div, mod, minus
// ...there's also unaryMinus, unaryPlus, not, inc, dec
// Bitwise operators -> shl, shr, ushr, and, or, xor, inv

// To modify (assign), just change similar to this: `plusAssign`
// Ideally, just modify either plus or plusAssign, with `plus` for immutables...
operator fun <T> MutableCollection<T>.plusAssign(element: T) {
    this.add(element)
}

fun main() {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)

    println(p1 + p2) // = a.plus(b)
    println(p1 * 1.5)
    println(-p2)


    val list = mutableListOf(1, 2)
    list += 3

    val newList = list + listOf(4,5)

    println(list)
    println(newList)
}
