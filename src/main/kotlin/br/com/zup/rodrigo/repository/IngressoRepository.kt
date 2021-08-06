package br.com.zup.rodrigo.repository

import br.com.zup.rodrigo.model.Ingresso
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface IngressoRepository : JpaRepository<Ingresso,UUID>{
}