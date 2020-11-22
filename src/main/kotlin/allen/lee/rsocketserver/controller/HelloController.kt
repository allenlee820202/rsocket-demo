package allen.lee.rsocketserver.controller

import io.reactivex.rxjava3.core.Single
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller

@Controller
class HelloController {
    @MessageMapping("helloData")
    fun getHelloData(helloDataRequest: HelloDataRequest): Single<HelloData> {
        return Single.just(HelloData(message = "hello!"))
    }
}

data class HelloDataRequest(val message: String)

data class HelloData(val message: String)