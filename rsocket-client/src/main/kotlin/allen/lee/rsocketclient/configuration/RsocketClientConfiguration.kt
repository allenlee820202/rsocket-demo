package allen.lee.rsocketclient.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.util.MimeTypeUtils

@Configuration
class RsocketClientConfiguration(
        private val rsocketRequestBuilder: RSocketRequester.Builder
) {

    @Bean
    fun rSocket(): RSocketRequester {
        return rsocketRequestBuilder
                .dataMimeType(MimeTypeUtils.APPLICATION_JSON)
                .tcp("localhost", 7000)
    }
}