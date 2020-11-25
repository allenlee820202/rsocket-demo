package allen.lee.rsocketclient.controller

import com.fasterxml.jackson.annotation.JsonProperty
import io.reactivex.rxjava3.core.Single
import mu.KLogging
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.adapter.rxjava.RxJava3Adapter.fluxToFlowable

@RestController
class RestToStreamController(
        private val rsocketRequester: RSocketRequester
) {
    @GetMapping("/getStreamCount")
    fun getStreamCount(): Single<Int> {
        return fluxToFlowable(
                rsocketRequester
                        .route("requestStream")
                        .data("request message")
                        .retrieveFlux(Foo("dummy").javaClass)
        )
                .map { element ->
                    logger.info { element.message }
                    element
                }
                .toList().map { it.size }

    }

    companion object : KLogging()
}

class Foo(@JsonProperty("message") val message: String)
