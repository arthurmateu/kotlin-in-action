fun main() {
    val name = readln()
    println("Hello, ${if (name.isBlank()) "world" else name}!") // ternary inside `${}`
}

// var: type
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b // this is such an ugly ternary btw
}
// Could be reduced to the following, since it returns an expression directly
fun max(a: Int, b: Int) = if (a > b) a else b // Expression body, as opposed to the above block body

// most things are expressions, meaning you can do the following
val c = if (true) 3 else 5 // also works for when, try/catch, etc
// assignments should always be statements

// val -> read-only reference | value. if it points to a mutable object, it can be mutated
// var -> reassignable reference | variable. fixed type, though.
