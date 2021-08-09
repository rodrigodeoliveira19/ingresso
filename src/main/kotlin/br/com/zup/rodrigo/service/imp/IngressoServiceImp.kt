package br.com.zup.rodrigo.service.imp

import br.com.zup.rodrigo.model.Ingresso
import br.com.zup.rodrigo.repository.IngressoRepository
import br.com.zup.rodrigo.service.IngressoService
import br.com.zup.rodrigo.shared.IngressoNaoEncontradoException
import java.util.*
import javax.inject.Singleton

@Singleton
class IngressoServiceImp(private val ingressoRepository: IngressoRepository) : IngressoService {

    override fun cadastrar(ingresso: Ingresso): Ingresso {
        return ingressoRepository.save(ingresso)
    }

    override fun buscarTodos(): List<Ingresso> {
        return ingressoRepository.findAll()
    }

    override fun buscarPorId(id: String): Optional<Ingresso> {
        return ingressoRepository.findById(UUID.fromString(id))
    }

    override fun atualizar(id: String, ingressoRequest: Ingresso): Ingresso {
        val ingresso = buscarIngressoPorId(id).get()
        ingresso.atualizar(ingressoRequest)
        return ingressoRepository.update(ingresso)
    }

    override fun deletar(id: String) {
        val ingresso = buscarIngressoPorId(id).get()
        ingressoRepository.delete(ingresso)
    }

    private  fun buscarIngressoPorId(id: String) : Optional<Ingresso>{
        val ingressoOptional = ingressoRepository.findById(UUID.fromString(id))
        if(ingressoOptional.isEmpty){
            throw IngressoNaoEncontradoException("Ingresso não encontrado")
        }

        return ingressoOptional
    }


}