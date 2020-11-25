package allen.lee.rsocketserver.controller

import io.reactivex.rxjava3.core.Flowable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller

@Controller
class ChannelController {
    @MessageMapping("channel")
    fun getStreamData(requestFlow: Flowable<String>): Flowable<String> {
        return requestFlow.map { it.toUpperCase() }
    }
}