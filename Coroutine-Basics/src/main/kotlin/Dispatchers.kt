import kotlinx.coroutines.*

fun main() {
    runBlocking {
        //Wont work in intelliJ
//        launch(Dispatchers.Main) {
//            println("Main dispatcher. Thread ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined1. Thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Unconfined) {
            delay(100L)
            println("Unconfined2. Thread ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO. Thread ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext(name = "MyThread")) {
            println("newSingleThreadContext. Thread ${Thread.currentThread().name}")
        }
    }
}