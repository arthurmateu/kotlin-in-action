import kotlin.concurrent.thread

fun main() {
    println("I'm on ${Thread.currentThread().name}")
    thread {
        println("And I'm on ${Thread.currentThread().name}")
    }
}

// suspend: allows you to do other actions while a function is executing
// suspended functions have to be called from co-routines or from other suspended

// deferred (similar to future or promise) -> you don't know a value yet, but will

// more info on coroutines and dispatchers -> http://mng.bz/oeVZ