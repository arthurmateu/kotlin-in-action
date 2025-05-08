import java.time.LocalDate

data class Point(val x: Int, val y: Int) {
    operator fun Point.get(index: Int): Int { // access as if it were a list
    // you could also do `a.get(i1, i2) <=> a[i1, i2]`
        return when(index) {
            0 -> x
            1 -> y
            else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
        }
    }
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when(index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class Rectanble(ul: Point, lr = Point)

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in ul.x..<lr.x && // ul.x towards, but not including lr.x
           p.y in ul.y..<lr.y    // = ul.y.rangeUntil(lr.y)
}

fun main() {
    val p = Point(1, 2)
    println(p[1])

    val mp = MutablePoint(11, 22)
    mp[1] = 42
    println(mp)

    val r = Rectangle(Point(10, 20), Point(50, 50))
    println(Point(20, 30) in rect)
    println(Point(5, 5) in rect)

    val now = LocalDate.now()
    val vacation = now..now.plusDays(10) // = now.rangeTo(10), which includes it
    println(now.plusWeeks(1) in vacation)
}
