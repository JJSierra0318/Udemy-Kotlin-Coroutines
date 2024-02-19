import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        val numbersFlow = sendNumbers()
        println("Flow hasn't started yet\nFlow will start now")
        withTimeoutOrNull(1000L) {
            numbersFlow.collect { println(it) }
        }
    }
}

fun sendNumbers() = flow {
    listOf(1, 2, 3).forEach {
        delay(400L)
        emit(it)
    }
}