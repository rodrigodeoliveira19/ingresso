package br.com.zup.rodrigo.controller

import br.com.zup.rodrigo.dto.IngressoRequest
import br.com.zup.rodrigo.dto.IngressoResponse
import br.com.zup.rodrigo.service.IngressoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller("/ingressos")
class IngressoController(private val ingressoService: IngressoService) {

    @Post
    @Transactional
    fun cadastrar(@Body @Valid ingressoRequest: IngressoRequest): HttpResponse<Any> {
        val ingresso =  ingressoRequest.ToModel()
        return HttpResponse.created(ingressoService.cadastrar(ingresso))
    }

    @Get
    @Transactional
    fun buscarTodos() : HttpResponse<List<IngressoResponse>>{
        val ingressos = ingressoService.buscarTodos()
        val ingressosResponse = ingressos.map { ingresso -> IngressoResponse(ingresso) }
        return  HttpResponse.ok(ingressosResponse)
    }

    @Get("/{id}")
    @Transactional
    fun buscarPorId(@PathVariable id: String) : HttpResponse<IngressoResponse>{
        val ingressoOptional = ingressoService.buscarPorId(id)
        if(ingressoOptional.isEmpty){
            return  HttpResponse.notFound()
        }

        val ingresso = ingressoOptional.get()
        return  HttpResponse.ok(IngressoResponse(ingresso))
    }

    @Put("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: String,@Body @Valid ingressoRequest: IngressoRequest)
        : HttpResponse<IngressoResponse>{

        val ingresso = ingressoRequest.ToModel()
        ingressoService.atualizar(id, ingresso)
        return HttpResponse.ok(IngressoResponse(ingresso))

    }

    @Delete("/{id}")
    @Transactional
    fun deletar(@PathVariable id: String) : HttpResponse<Unit>{
        ingressoService.deletar(id)
        return  HttpResponse.noContent()
    }
}