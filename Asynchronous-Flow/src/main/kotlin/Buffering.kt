import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            generate()
                //Will store if cant be processed in time, improve performance
                .buffer()
                .collect {
                    delay(300L)
                    println(it)
                }
        }
        println("Collected in $time ms")
    }
}

fun generate() = flow {
    for (i in 1..3) {
        delay(100L)
        emit(i)
}
}