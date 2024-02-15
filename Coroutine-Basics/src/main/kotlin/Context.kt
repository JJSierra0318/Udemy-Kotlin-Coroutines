import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch(CoroutineName(name = "MyCoroutine")) {
            println("This runs from ${coroutineContext[CoroutineName.Key]}")
        }
    }
}