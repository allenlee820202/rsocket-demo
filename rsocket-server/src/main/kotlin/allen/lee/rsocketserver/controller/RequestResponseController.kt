package allen.lee.rsocketserver.controller

import io.reactivex.rxjava3.core.Single
import mu.KLogging
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller

@Controller
class RequestResponseController {
    @MessageMapping("helloReqResp")
    fun getHelloData(greeting: String): Single<HelloData> {
        logger.info { "greeting received: $greeting" }
        return Single.just(HelloData(message = "hello!"))
    }

    companion object : KLogging() {}
}

data class HelloData(val message: String)