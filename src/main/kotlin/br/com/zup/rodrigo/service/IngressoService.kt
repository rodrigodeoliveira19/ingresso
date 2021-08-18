package br.com.zup.rodrigo.service

import br.com.zup.rodrigo.model.Ingresso

interface IngressoService {

    fun cadastrar(ingresso: Ingresso): Ingresso

    fun buscarTodos(): List<Ingresso>

    fun buscarPorId(id: String) : Ingresso?

    fun atualizar(id: String, ingresso: Ingresso) : Ingresso?

    fun deletar(id: String)
}