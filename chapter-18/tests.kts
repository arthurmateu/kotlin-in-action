// note that the test-dispatcher is single-threaded!
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import kotlin.test.*
import kotlin.time.Duration.Companion.seconds
class PlaygroundTest {
    @Test
    fun testDelay() = runTest { // runTest specifies a 60s timeout
        val startTime = System.currentTimeMillis()
        delay(20.seconds)
        println(System.currentTimeMillis() - startTime)
        // 11
    }
}

// you can run all scheduled coroutines with `runCurrent()`
// you can skip forwards with `advanceUntilIdle()`


// https://github.com/cashapp/turbine is mostly used for testing coroutines