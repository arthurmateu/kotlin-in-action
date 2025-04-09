package chapter-2.colors

// Note that below, you can avoid repeating `Color.<something` when you import it elsewhere as `Color.*`
enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238); // Semicolon here is required, as it separates the enum constant list from the method definitions

    val rgb = (r * 256 + g) * 256 + b
    fun printColor() = println("$this is $rgb")
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun measureColor() = Color.ORANGE

fun getWarmthFromSensor(): String {
    val color = measureColor()

    return when(color) {
        // Example of multiple branches giving out a same result
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm (red = ${color.r})"
        Color.GREEN -> "neutral (green = ${color.g})"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold (blue = ${color.b})"
    }
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        // We use `setOf` so either (R,Y) or (Y,R) work. 
        // Note that this is less efficient since you create a set both when running the when tree and when evaluating to other sets.
        // You could also avoid putting an argument on the when expression, and every branch just checks for booleans
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }

fun main() {
    println(Color.BLUE.rgb)
    Color.GREEN.printColor()

    println(getMnemonic(Color.VIOLET)

    println(getWarmthFromSensor())

    println(mix(Color.BLUE, Color.YELLOW))
}


