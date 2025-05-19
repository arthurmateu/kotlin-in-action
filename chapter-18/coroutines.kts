// you can't just surround a launch/async with try-catch.

// for launch, you have to put it inside of it
import kotlinx.coroutines.*
fun main(): Unit = runBlocking {
    launch {
        try {
            throw UnsupportedOperationException("Ouch!")
        } catch (u: UnsupportedOperationException) {
            println("Handled $u")
            // Handled java.lang.UnsupportedOperationException: Ouch!
        }
    }
}

// for async, just call an `.await()`.
fun main(): Unit = runBlocking {
    val myDeferredInt: Deferred<Int> = async {
        throw UnsupportedOperationException("Ouch!")
    }
    try {
        val i: Int = myDeferredInt.await()
        println(i)
    } catch (u: UnsupportedOperationException) {
        println("Handled: $u")
        // note that it will rethrow the exception!
        // the child will propagate the error to the parent
    }
}

// if it's a regular job, it propagates the error to their supervisor,
// and the other children get cancelled

// using `SupervisorJob`s allows you to run the other children's actions    