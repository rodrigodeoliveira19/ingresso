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

    override fun buscarTodos(): List<Ingresso> {
        val ingressos = cqlSession.execute(
            SimpleStatement.newInstance("select * from ingresso;")
        )

        return ingressos.map {
            Ingresso(
                id = it.getUuid("ingresso_id"),
                descricao = it.getString("descricao")!!,
                valor = it.getBigDecimal("valor")!!,
                endereco = it.getString("endereco")!!,
                dataEvento = it.getLocalDate("data_evento")!!
            )
        }.toList()
    }

    override fun buscarPorId(id: UUID): Ingresso? {
        val ingressos = cqlSession.execute(
            SimpleStatement.newInstance("select * from ingresso where ingresso_id =?;", id)
        )

        return ingressos.map {
            Ingresso(
                id = it.getUuid("ingresso_id"),
                descricao = it.getString("descricao")!!,
                valor = it.getBigDecimal("valor")!!,
                endereco = it.getString("endereco")!!,
                dataEvento = it.getLocalDate("data_evento")!!
            )
        }.firstOrNull()
    }

    override fun atualizar(ingresso: Ingresso): Ingresso? {
        val ingressos = cqlSession.execute(
            SimpleStatement.newInstance(
                "update ingresso set descricao = ?, " +
                        "valor = ?, " +
                        "endereco = ?," +
                        "data_evento = ?" +
                        " where ingresso_id = ?;",
                ingresso.descricao,
                ingresso.valor,
                ingresso.endereco,
                ingresso.dataEvento,
                ingresso.id
            )
        )

        return ingresso
    }

    override fun deletar(ingresso: Ingresso) {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "delete from ingresso where ingresso_id = ?;",
                ingresso.id
            )
        )
    }
}