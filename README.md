## Micronaut 2.5.11 Documentation

- [User Guide](https://docs.micronaut.io/2.5.11/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.5.11/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.5.11/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)


## Comandos realizados para criar o ambiente

## Criar e executar o container

- docker run --name ingressoscylla -p 9042:9042 --hostname ingressoscylla -d scylladb/scylla

- docker exec -it ingressoscylla cqlsh

## Criar e usar a keyspace

- CREATE KEYSPACE mykeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3};

- use mykeyspace; 

## Criar tabela e inserir dados

- CREATE TABLE ingresso( ingresso_id uuid, descricao text, valor decimal, endereco text,data_evento date, PRIMARY KEY((ingresso_id ))); 

- insert into ingresso(ingresso_id, descricao, valor, endereco, data_evento) values (771dc992-1721-413a-92ed-5a44c859bfa5, 'Desc 1', 500.00, 'Rua A','2021-05-28');

## Selecionar os dados

- select * from ingresso;