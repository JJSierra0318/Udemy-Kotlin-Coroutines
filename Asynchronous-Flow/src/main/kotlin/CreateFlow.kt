import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        sendPrimeNumbers().collect {
            println("received $it")
        }
    }
}

fun sendPrimeNumbers()
//Option 3
        = flowOf("one", "two", "three")

//Option 2
        //= listOf(1, 2, 3).asFlow()

//Option 1
/*        = flow {
    for (i in 1..10) {
        emit(i)
    }
}*/