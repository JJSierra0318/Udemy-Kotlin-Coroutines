import kotlinx.coroutines.*

fun main() {
    println("Program execution will now block")
    runBlocking {
        launch {
            delay(1000L)
            println("Task from runBLocking")
        }

        GlobalScope.launch {
            delay(500L)
            println("Task from global scope")
        }

        coroutineScope {
            launch {
                delay(1500L)
                println("Task from coroutine scope")
            }
        }
    }
    println("Program execution will now continue")
}