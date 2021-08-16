package br.com.zup.rodrigo.repository.scylla.imp

import br.com.zup.rodrigo.model.Ingresso
import br.com.zup.rodrigo.repository.scylla.IngressoRepository
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class IngressoRepositoryImpl(private val cqlSession: CqlSession) : IngressoRepository {

    override fun cadastrar(ingresso: Ingresso): Ingresso {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "insert into ingresso(ingresso_id, descricao, valor, endereco, data_evento) values (?, ?, ?, ?,?);",
                UUID.randomUUID(),
                ingresso.descricao,
                ingresso.valor,
                ingresso.endereco,
                ingresso.dataEvento
            )
        )

        return ingresso
    }
}