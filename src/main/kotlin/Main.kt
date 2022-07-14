import kotlinx.coroutines.*

fun main(args: Array<String>) {

    runBlocking {
            val parentJob = Job()
            val scope = CoroutineScope(CoroutineName("Coroutine-Name") + Dispatchers.IO + parentJob)

            val job = scope.launch {
                delay(50)
                println("scope job name: ${coroutineContext[Job]}")
            }
            println("job: $job")
            delay(20)

            val iterator = parentJob.children.iterator()
            while (iterator.hasNext()) {
                val child = iterator.next()
                println("child job: $child ")
            }
            delay(1000)
        }
}