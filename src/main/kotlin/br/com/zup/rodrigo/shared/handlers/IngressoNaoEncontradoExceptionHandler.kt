package br.com.zup.rodrigo.shared.handlers

import br.com.zup.rodrigo.shared.IngressoNaoEncontradoException
import io.micronaut.context.annotation.Requirements
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor
import javax.inject.Singleton

@Produces
@Singleton
@Requirements(
    Requires(classes = [IngressoNaoEncontradoException::class, ExceptionHandler::class])
)
class IngressoNaoEncontradoExceptionHandler (private val errorResponseProcessor: ErrorResponseProcessor<Any>) :
    ExceptionHandler<IngressoNaoEncontradoException, HttpResponse<*>> {

    override fun handle(request: HttpRequest<*>, exception: IngressoNaoEncontradoException): HttpResponse<*> {
        return errorResponseProcessor.processResponse(
            ErrorContext.builder(request)
                .cause(exception)
                .errorMessage(exception.message)
                .build(), HttpResponse.badRequest<Any>())
    }
}