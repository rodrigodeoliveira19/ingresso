package br.com.zup.rodrigo.repository.scylla

import br.com.zup.rodrigo.model.Ingresso

interface IngressoRepository {

    fun cadastrar(ingresso: Ingresso): Ingresso
}