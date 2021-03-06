package br.com.zup.rodrigo.dto

import br.com.zup.rodrigo.model.Ingresso
import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.convert.format.Format
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Introspected
class IngressoRequest(
    @field: NotBlank val descricao: String,
    @field: Positive val valor: BigDecimal,
    @field: NotBlank val endereco: String,
    @Format("yyyy/MM/dd")
    val dataEvento: LocalDate
) {

    fun ToModel(): Ingresso {
        return Ingresso(
            descricao,valor, endereco, dataEvento
        )
    }

}
