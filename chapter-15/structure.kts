import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

// when creating a new coroutine in the body of another coroutine, it becomes its child
// coroutine scopes basically wait for every child to execute first (almost in dfs-fashion)

// coroutineScope -> concurrent decomposition of work
// CoroutineScope -> associates coroutines to a class's lifecycle

// GlobalScope -> opts out of structured concurrency benefits, since they don't have a life cycle or can
// be cancelled. usually declared with `@DelicateCoroutinesAPI`

fun main() {
    runBlocking {
        GlobalScope.launch {
            delay(1000.milliseconds)
            launch {
                delay(250.milliseconds)
                log("Grandchild done")
            }
            log("Child 1 done!")
        }
        GlobalScope.launch {
            delay(500.milliseconds)
            log("Child 2 done!")
        }
        log("Parent done!")
    }
}
// 28 [main @coroutine#1] Parent done!


// you can cancel things midway through (remember that it throws a CancellationException)
fun main() {
    runBlocking {
        val launchedJob = launch {
            log("I'm launched!")
            delay(1000.milliseconds)
            log("I'm done!")
        }
        val asyncDeferred = async {
            log("I'm async")
            delay(1000.milliseconds)
            log("I'm done!")
        }
        delay(200.milliseconds)
        launchedJob.cancel()
        asyncDeferred.cancel()
    }
}
// 0 [main @coroutine#2] I'm launched!
// 7 [main @coroutine#3] I'm async

// you can run functions inside a `withTimeoutOrNull`

// to ensure coroutines get cancelled, you get an `isActive` property in CoroutineScope,
// which you can also access via `ensureActive()` (which also throws a CancellationException)
// you can also use `yield()`, which runs interleavedly

// there's also `.use`, to automatically close resources and avoid data leaks