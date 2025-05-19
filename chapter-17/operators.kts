// intermediate operators:
// flow -> [operator] -> modified flow
import kotlinx.coroutines.flow.*
fun main() {
    val names = flow {
        emit("Jo")
        emit("May")
        emit("Sue")
    }
    val upperAndLowercasedNames = names.transform {
        emit(it.uppercase())
        emit(it.lowercase())
    }
    runBlocking {
        upperAndLowercasedNames.collect { print("$it ")}
        // JO jo MAY may SUE sue
    }
}
// note that you can also perform actions `onStart, `onEach`, `onCompletion` and `onEmpty`


// terminal operators:
// flow -> [operator] -> value, collection, side effects