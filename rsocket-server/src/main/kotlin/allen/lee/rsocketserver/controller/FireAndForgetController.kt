package allen.lee.rsocketserver.controller

import mu.KLogging
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller

@Controller
class FireAndForgetController {
    @MessageMapping("fireAndForget")
    fun getStreamData(request: String) {
        logger.info("request is: $request")
    }

    companion object : KLogging()
}