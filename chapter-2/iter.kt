fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun main() {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }

    for (i in 100 downTo 1 step 2) { // from 100 to 1, skipping 2 steps
        print(fizzBuzz(i))
    }


    val binaryReps = mutableMapOf<Char, String>()

    for (char in 'A'..'F') {
        val binary = char.code.toString(radix = 2)
        binaryReps[char] = binary // similar to Python my beloved
    }

    // for element in collection, which can be unpacked
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    val list = listOf("10", "11", "1001")

    for ((index, element) in list.withIndex()) { // similar to enumerate(list)
        println("$index: $element")
    }
}
