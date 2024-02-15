import kotlinx.coroutines.*

fun main() {
    runBlocking {

        val myHandler = CoroutineExceptionHandler {coroutineContext, throwable ->
            println("Exception handled: ${throwable.localizedMessage}")
        }

        val job = GlobalScope.launch(myHandler) {
            println("throwing exception from job")
            throw IndexOutOfBoundsException("Exception in coroutine")
        }
        job.join()

        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException("Exception from async")
        }

        try {
            deferred.await()
        }catch (e: ArithmeticException) {
            println("Caught Arithmetic exception ${e.localizedMessage}")
        }

    }
}