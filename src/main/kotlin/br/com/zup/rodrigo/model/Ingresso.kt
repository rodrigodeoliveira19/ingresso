package br.com.zup.rodrigo.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Entity
class Ingresso(
    @field: NotBlank var descricao: String,
    @field: Positive var valor: BigDecimal,
    @field: NotBlank var endereco: String,
    var dataEvento: LocalDate
) {

    @field:Id
    @field: GeneratedValue
    val id: UUID? = null

    fun atualizar(ingresso: Ingresso){
        descricao = ingresso.descricao
        valor = ingresso.valor
        endereco = ingresso.endereco
        dataEvento = ingresso.dataEvento
    }
}