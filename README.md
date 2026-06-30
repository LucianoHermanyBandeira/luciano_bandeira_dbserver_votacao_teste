# Desafio Votação

API de votação para cadastro de pautas, associados e votos.

## Visão geral

Esta aplicação Spring Boot implementa um sistema simples de votação com os seguintes recursos:

- Cadastro de pautas
- Abertura de pauta para votação (tempo padrão ou tempo personalizado)
- Cadastro de associados
- Registro de votos por associado e por pauta
- Consulta de resultados de votação por pauta
- Desconsidere os seguintes .yml files (não estão funcionando ainda): api-votacao-docker-compose.yml, dockerfile, myApi2-docker-compose.yml, myApi-docker-compose.yml
- Utilizar o arquivo "mysql-docker-compose.yml" e rodar o seguinte comando para subir a base de dados MySql: docker-compose -f mysql-docker-compose.yml up -d


## Tecnologias

- Java 21
- Spring Boot 4.1.0
- Spring Data JPA
- Spring Web MVC
- MySQL (configuração padrão)
- H2 (dependência disponível para testes/console)

## Estrutura de pacotes

- `controller` - expõe os endpoints REST
- `dto` - objetos de transferência de dados para payloads
- `entity` - entidades JPA do domínio
- `service` - lógica de negócio
- `repository` - acesso a dados
- `mapper` - conversão entre entidades e DTOs
- `exception` - tratamento de erros

## Pré-requisitos

- Java 21
- Maven 3.x
- MySQL rodando em `localhost:3306`

## Configuração do banco de dados

As configurações padrão estão em `src/main/resources/application.properties`:

- URL: `jdbc:mysql://localhost:3306/dbserver_votacao`
- Usuário: `root`
- Senha: `votacao12345`

Caso seja necessário, atualize as credenciais ou a URL do banco.

## Inicialização

No diretório do projeto, execute:

```bash
./mvnw spring-boot:run
```

Ou, no Windows PowerShell:

```powershell
.
mvnw.cmd spring-boot:run
```

## Endpoints

Base URL padrão: `http://localhost:8080`

### Pautas

- `POST /pautas/cadastrar`
  - Cadastra uma nova pauta.
  - Payload de exemplo:
    ```json
    {
      "theme": "Melhorar o parque de TI",
      "timeLengthInMinutes": 5
    }
    ```

- `GET /pautas/buscarPauta/{id}`
  - Busca uma pauta por ID.

- `GET /pautas/buscarPautas`
  - Retorna todas as pautas.

- `GET /pautas/abrirPauta/{id}`
  - Abre a pauta para votação com tempo padrão de 1 minuto.

- `GET /pautas/abrirPauta/{id}/tempo/{tempo}`
  - Abre a pauta para votação com tempo personalizado em minutos.

- `GET /pautas/totalizarVotosNaPauta/{id}`
  - Retorna total de votos da pauta.

### Associados

- `POST /associados/cadastrarAssociado`
  - Cadastra um novo associado.
  - Payload de exemplo:
    ```json
    {
      "cpf": "12345678901",
      "nome": "Maria Silva"
    }
    ```

- `GET /associados/buscarAssociadoPorCpf/{cpf}`
  - Busca associado por CPF.

- `GET /associados/buscarAssociadoPorNome/{nome}`
  - Busca associado por nome.

- `GET /associados/buscarAssociadoById/{id}`
  - Busca associado por ID.

- `GET /associados/buscarTodosAssociados`
  - Retorna todos os associados.

### Votos

- `POST /votos/votar`
  - Registra um voto para uma pauta.
  - Payload de exemplo:
    ```json
    {
      "userAssociatedId": 1,
      "pollId": 2,
      "voteValue": "SIM"
    }
    ```

- `GET /votos/{pollId}`
  - Retorna todos os votos de uma pauta.

## Modelos de dados

- `PollDto`
  - `id` - identificador
  - `theme` - título ou tema da pauta
  - `timeLengthInMinutes` - duração de votação
  - `startTime` - início da votação
  - `endTime` - fim da votação

- `UserAssociatedDto`
  - `id` - identificador
  - `cpf` - CPF do associado
  - `nome` - nome do associado

- `VoteDto`
  - `userAssociatedId` - ID do associado
  - `pollId` - ID da pauta
  - `voteValue` - voto registrado

## Observações

- A aplicação usa `spring.jpa.hibernate.ddl-auto=update`, o que atualiza o esquema automaticamente.
- O arquivo `src/main/resources/schema.sql` contém a estrutura inicial de tabelas.
- Ajuste o tempo de votação por pauta usando o endpoint de abertura com parâmetro `tempo`.

## Testes

Para executar os testes do projeto:

```bash
./mvnw test
```

## Docker

O projeto contém arquivos `docker/` com exemplos de `docker-compose` para suporte ao MySQL e à API.

---

`desafio-votacao` foi criado para demonstrar o gerenciamento de pautas, associados e votos com uma API REST simples em Spring Boot.
