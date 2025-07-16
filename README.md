# To-Do List Java EE

Este projeto é um sistema de gerenciamento de tarefas (To-Do List) desenvolvido em Java EE. Ele permite que os usuários criem, listem, atualizem e excluam tarefas de forma simples e eficiente.

## Estrutura do Projeto

A estrutura do projeto é a seguinte:

```
todo-list-javaee
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── controller
│   │   │           │   └── TaskController.java
│   │   │           ├── model
│   │   │           │   └── Task.java
│   │   │           └── service
│   │   │               └── TaskService.java
│   │   ├── resources
│   │   │   └── META-INF
│   │   │       └── persistence.xml
│   │   └── webapp
│   │       ├── WEB-INF
│   │       │   └── web.xml
│   │       └── index.jsp
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── TaskServiceTest.java
├── pom.xml
└── README.md
```

## Funcionalidades

- **Criar Tarefa**: Permite ao usuário adicionar uma nova tarefa ao sistema.
- **Listar Tarefas**: Exibe todas as tarefas cadastradas.
- **Atualizar Tarefa**: Permite ao usuário editar uma tarefa existente.
- **Excluir Tarefa**: Remove uma tarefa do sistema.

## Requisitos

- Java 8 ou superior
- JBoss EAP 6
- Maven

## Instalação

1. Clone o repositório:
   ```
   git clone <URL_DO_REPOSITORIO>
   ```
2. Navegue até o diretório do projeto:
   ```
   cd todo-list-javaee
   ```
3. Compile o projeto usando Maven:
   ```
   mvn clean install
   ```
4. Faça o deploy do arquivo WAR gerado no JBoss EAP.

## Uso

Após o deploy, acesse a aplicação através do navegador em `http://localhost:8080/todo-list-javaee`. Você poderá interagir com a interface para gerenciar suas tarefas.

## Contribuição

Sinta-se à vontade para contribuir com melhorias ou correções. Crie um fork do projeto e envie suas pull requests.

## Licença

Este projeto está licenciado sob a MIT License. Veja o arquivo LICENSE para mais detalhes.