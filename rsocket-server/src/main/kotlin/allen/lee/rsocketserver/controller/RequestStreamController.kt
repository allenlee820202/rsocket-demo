package allen.lee.rsocketserver.controller

import io.reactivex.rxjava3.core.Emitter
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.functions.Supplier
import mu.KLogging
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller

@Controller
class RequestStreamController {
    @MessageMapping("requestStream")
    fun getStreamData(request: String): Flowable<Foo> {
        logger.info("request is $request")
        return Flowable.fromIterable(0..1000).map { Foo(message = it.toString()) }
    }

    private fun infiniteIntStreamGenerator(start: Int, step: Int): Flowable<Int> {
        return Flowable.generate(Supplier { start },
                BiFunction { s: Int, emitter: Emitter<Int> ->
                    val next: Int = s + step
                    emitter.onNext(next)
                    next
                })
    }

    companion object : KLogging()
}

data class Foo(val message: String)