# OS-API - Sistema de Gerenciamento de Ordens de Serviço

O OS-API é um sistema de gerenciamento de ordens de serviço desenvolvido com Spring Boot, que permite o controle de clientes, técnicos e ordens de serviço. Este projeto oferece a oportunidade de aprender a construir uma aplicação web completa, implementando operações básicas de CRUD (CREATE, READ, UPDATE e DELETE) em um contexto de Gerenciamento de Ordens de Serviço.

## Visão Geral

O sistema OS-API oferece as seguintes funcionalidades:

- Cadastro e gerenciamento de clientes.
- Cadastro e gerenciamento de técnicos.
- Registro e acompanhamento de ordens de serviço.
- Operações básicas de CRUD para todas as entidades.

## Visão Técnica - Back End

A parte back end do projeto OS-API é desenvolvida utilizando as seguintes tecnologias e conceitos:

- **Java com Spring Boot 2.3.x**: Utilizamos o framework Spring Boot para agilizar o desenvolvimento de aplicações Java.
- **API Rest**: Implementamos uma API RESTful para comunicação com o front end e outros sistemas.
- **Banco de Dados MySQL**: Utilizamos o MySQL como banco de dados relacional para armazenamento dos dados.
- **JPA com Hibernate**: Usamos JPA (Java Persistence API) em conjunto com o framework Hibernate para mapeamento objeto-relacional e interação com o banco de dados.
- **Validação de Dados**: Implementamos validação de dados para garantir a integridade e consistência dos dados.
- **Tratamento de Exceções**: Realizamos o tratamento adequado de exceções para lidar com situações inesperadas durante a execução da aplicação.
- **Protocolo HTTP e REST**: Seguimos os padrões e melhores práticas para a construção de APIs RESTful, utilizando os métodos HTTP apropriados para cada operação.

## Funcionalidades Implementadas

- **Clientes**: CRUD completo para gerenciamento de clientes.
- **Técnicos**: CRUD completo para gerenciamento de técnicos.
- **Ordens de Serviço**: CRUD completo para registro e acompanhamento de ordens de serviço.

## Como Executar o Projeto

Para executar o projeto OS-API em sua máquina local, siga os passos abaixo:

1. **Pré-requisitos**:
   - JDK 8 ou superior instalado.
   - MySQL Server instalado e configurado.

2. **Clonar o Repositório**:
    - git clone https://github.com/seu_usuario/os-api.git
  
  
3. **Configuração do Banco de Dados**:
- Crie um banco de dados MySQL chamado `os_api`.
- Atualize as configurações de acesso ao banco de dados no arquivo `application.properties`.

4. **Executar o Projeto**:


5. **Acesso à API**:
- Acesse a API em `http://localhost:8080/`.

## Front End

O front end do projeto OS-API está disponível no seguinte repositório:
[OS Front End Repository](https://github.com/Marcos-Gabriell/os-front)

Esse README fornece uma visão geral do projeto OS-API, destacando suas funcionalidades, tecnologias utilizadas e instruções básicas para execução. Se houver alguma dúvida ou questão adicional, não hesite em entrar em contato ou consultar a documentação disponível no código-fonte.
