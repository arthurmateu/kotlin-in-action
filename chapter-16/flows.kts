// coroutine-based abstractions to get values as soon as they appear

// cold flows -> async data streams. inert by default until collected (with `.collect`).
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.milliseconds
fun main() {
    val letters = flow {
        log("Emitting A!")
        emit("A") // returns here.
        delay(200.milliseconds)
        log("Emitting B!")
        emit("B")
    }
}
// it can also return infinite flows. note that you can cancel just like other coroutines
// channel flows can `launch` other coroutines and `send` elements concurrently


// hot flows -> operate in a broadcast fashion
//      shared flows -> broadcast values
//      state flows  -> communicating state

// shared flows:
private val _messageFlow = MutableSharedFlow<Int>()
val messageFlow = _messageFlow.asSharedFlow() // underscore to "private" it
fun beginBroadcasting(scope: CoroutineScope) {
    scope.launch {
        while(true) {
            delay(500.milliseconds)
            val number = Random.nextInt(0..10)
            log("Emitting $number!")
            _messageFlow.emit(number)
        }
    }
}
fun main(): Unit = runBlocking {
    val radioStation = RadioStation()
    radioStation.beginBroadcasting(this)
    delay(600.milliseconds)
    radioStation.messageFlow.collect {
        log("A collecting $it!") // By collecting, you're "subscribing" to the shared flow
    }
}
// You can "replay" previous broadcasts:
private val _messageFlow = MutableSharedFlow<Int>(replay = 5)