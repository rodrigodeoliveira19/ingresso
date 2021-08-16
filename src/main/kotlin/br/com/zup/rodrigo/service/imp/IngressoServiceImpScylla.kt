package br.com.zup.rodrigo.service.imp

import br.com.zup.rodrigo.model.Ingresso
import br.com.zup.rodrigo.repository.scylla.IngressoRepository
import br.com.zup.rodrigo.service.IngressoService
import java.util.*
import javax.inject.Singleton

@Singleton
class IngressoServiceImpScylla(val ingressoRepository: IngressoRepository): IngressoService {

    override fun cadastrar(ingresso: Ingresso): Ingresso {
       return ingressoRepository.cadastrar(ingresso)
    }

    override fun atualizar(id: String, ingresso: Ingresso): Ingresso {
        TODO("Not yet implemented")
    }


    override fun buscarPorId(id: String): Optional<Ingresso> {
        TODO("Not yet implemented")
    }

    override fun buscarTodos(): List<Ingresso> {
        TODO("Not yet implemented")
    }

    override fun deletar(id: String) {
        TODO("Not yet implemented")
    }
}