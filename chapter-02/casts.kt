interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(e: Expr): Int {
    // No need for return (or curly braces, since we can make it an expression body)
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw IllegalArgumentException("Unknown expr")
    }
}

fun main() {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}
