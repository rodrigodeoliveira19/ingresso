package br.com.zup.rodrigo.repository.scylla

import br.com.zup.rodrigo.model.Ingresso
import java.util.*

interface IngressoRepository {

    fun cadastrar(ingresso: Ingresso): Ingresso

    fun buscarTodos(): List<Ingresso>

    fun buscarPorId(id: UUID): Ingresso?

    fun atualizar(ingresso: Ingresso): Ingresso?

    fun deletar(ingresso: Ingresso)
}