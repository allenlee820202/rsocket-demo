package allen.lee.rsocketclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RsocketClientApplication

fun main(args: Array<String>) {
    runApplication<RsocketClientApplication>(*args)
}
