package allen.lee.rsocketserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RsocketServerApplication

fun main(args: Array<String>) {
	runApplication<RsocketServerApplication>(*args)
}
