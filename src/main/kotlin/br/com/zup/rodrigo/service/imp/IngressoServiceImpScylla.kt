package br.com.zup.rodrigo.service.imp

import br.com.zup.rodrigo.model.Ingresso
import br.com.zup.rodrigo.repository.scylla.IngressoRepository
import br.com.zup.rodrigo.service.IngressoService
import br.com.zup.rodrigo.shared.IngressoNaoEncontradoException
import java.util.*
import javax.inject.Singleton

@Singleton
class IngressoServiceImpScylla(private val ingressoRepository: IngressoRepository) : IngressoService {

    override fun cadastrar(ingresso: Ingresso): Ingresso {
        return ingressoRepository.cadastrar(ingresso)
    }

    override fun buscarTodos(): List<Ingresso> {
        return ingressoRepository.buscarTodos()
    }

    override fun buscarPorId(id: String): Ingresso? {
        return ingressoRepository.buscarPorId(UUID.fromString(id))
    }

    override fun atualizar(id: String, ingresso: Ingresso): Ingresso? {
        var ingressoOld = buscarIngressoPorId(id)
        ingressoOld.atualizar(ingresso)
        return ingressoRepository.atualizar(ingressoOld)
    }

    override fun deletar(id: String) {
        val ingresso = buscarIngressoPorId(id)
        ingressoRepository.deletar(ingresso)
    }


    private fun buscarIngressoPorId(id: String): Ingresso {
        val ingresso = ingressoRepository.buscarPorId(UUID.fromString(id))

        if (ingresso == null) {
            throw IngressoNaoEncontradoException("Ingresso não encontrado")
        }

        return ingresso
    }

}