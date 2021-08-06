package br.com.zup.rodrigo.dto

import br.com.zup.rodrigo.model.Ingresso
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Introspected
class IngressoRequest(
    @field: NotBlank val descricao: String,
    @field: Positive val valor: BigDecimal,
    @field: NotBlank val endereco: String,
) {

    fun ToModel(): Ingresso {
        return Ingresso(
            descricao,valor, endereco
        )
    }

}
