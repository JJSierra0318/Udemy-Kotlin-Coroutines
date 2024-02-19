import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        zip()
        combine()
    }
}

suspend fun combine() {
    val numbers = (1..5).asFlow().onEach {
        delay(300L)
    }
    val values = flowOf("one", "two", "three").onEach {
        delay(400L)
    }
    numbers.combine(values) {a, b ->
        "$a -> $b"
    }
        .collect {
            println(it)
        }
}

suspend fun zip() {
    val english = flowOf("One", "Two", "Three")
    val spanish = flowOf("Uno", "Dos", "Tres")
    english.zip(spanish) {a, b -> "$a in spanish is $b"}
        .collect {
            println(it)
        }
}