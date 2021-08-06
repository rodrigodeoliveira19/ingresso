package br.com.zup.rodrigo.service

import br.com.zup.rodrigo.model.Ingresso
import java.util.*

interface IngressoService {

    fun cadastrar(ingresso: Ingresso): Ingresso

    fun buscarTodos() : List<Ingresso>

    fun buscarPorId(id: String) : Optional<Ingresso>

    fun atualizar(id: String, ingresso: Ingresso) : Ingresso

    fun deletar(id: String)
}