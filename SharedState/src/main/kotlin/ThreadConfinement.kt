import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val counterContext = newSingleThreadContext("CounterContext")
        var counter = 0

        //It runs as a single thread, so it is not parallel (faster)
        withContext(counterContext) {
            massiveRunThreads {
                counter++
            }
        }

//        withContext(Dispatchers.Default) {
//            massiveRunThreads {
//                //Have to specify context for every iteration (Slower)
//                //Useful if there is some processing before updating the variable
//                withContext(counterContext) {
//                    counter++
//                }
//            }
//        }
        println("Counter = $counter")
    }
}

suspend fun massiveRunThreads(action: suspend () -> Unit) {
    val n = 100
    val k = 1000
    val time = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) {
                        action()
                    }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}