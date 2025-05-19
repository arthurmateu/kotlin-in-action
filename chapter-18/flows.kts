// flows can also throw exceptions (from collects)
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
class UnhappyFlowException: Exception()
val exceptionalFlow = flow {
    repeat(5) { number ->
        emit(number)
    }
    throw UnhappyFlowException()
}

// in this case, you have to enclose flows in try-catches
fun main() = runBlocking {
    val transformedFlow = exceptionalFlow.map {
        it * 2
    }
    try {
        transformedFlow.collect {
            print("$it ")
        }
    } catch (u: UnhappyFlowException) {
        println("\nHandled: $u")
    }
    // 0 2 4 6 8
    // Handled: UnhappyFlowException
}
// catch gives a default value when it errors out