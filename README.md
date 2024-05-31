# Desafio Técnico: Cadastro de Pessoas - Sinerji Gestão e Sistemas Ltda
## Sobre o projeto
Este projeto foi desenvolvido como parte avaliativa de um processo seletivo. Tem como objetivo de gerenciar usuários inseridos em um banco de dados.
### Nele é possível:
- Cadastrar novos usuários
- Visualizar as informações do usuário
- Editar os usuários cadastrados
- Excluir o usuário
  
## Tecnologias utilizadas
- [x] Java
- [x] Maven
- [x] Tomcat
- [x] JSF
- [x] PostgreSQL
- [x] JPA
- [x] Hibernate
- [x] Primefaces
- [x] Git

## Como executar o projeto
### É necessário ter previamente instalado:
- Java JDK - o utilizado neste projeto foi a v17
- IDE de sua preferência - o utilizado neste projeto foi o Eclipse
- Maven
- Tomcat - o utilizado neste projeto foi a v9
- Postgree - o utilizado neste projeto foi a v16
- Git
  
### Como acessar o projeto localmente
Será necessário clonar o projeto. Em seu terminal utilize o seguinte código `git clone https://github.com/ste-fani/teste-sinerji.git`. Também é possível baixar o repositório em sua versão zip, seguindo `Code --> Download Zip`.
### Configurações:
#### Banco de Dados
Após ter acesso ao repositório, importe a pasta para sua IDE, localize o arquivo `persistence.xml` em `src/main/resources/META-INF/persistence.xml` e edite o `value` das linhas que contém `<property name="javax.persistence.jdbc.user" value="" />` e `<property name="javax.persistence.jdbc.password" value="" />`. Os valores devem ser editados para seu usuário e senha definidos no banco de dados.
Crie um novo banco de dados nomeado `testesinerji`
- A criação das tabelas usuário e endereço seram feitas pela aplicação, caso prefira fazer manualmente, o exemplo a seguir será:
```
CREATE TABLE usuario (
    id SERIAL NOT NULL,
    nome VARCHAR(180) NOT NULL,
    idade INT NOT NULL,
    sexo sexo,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);

CREATE TABLE endereco (
    id SERIAL NOT NULL,
    logradouro VARCHAR(180) NOT NULL,
    numero INT NOT NULL,
    cidade VARCHAR(200) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    id_usuario INT NOT NULl,
    CONSTRAINT pk_endereco PRIMARY KEY (id),
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);
```
#### Dependências
Utilize o `mvn clean install` para instalar as dependências

#### Visualização do projeto
Adicione o projeto ao Server disponilizado pelo Tomcat, verifique o localhost disponível para visualizar a aplicação. Por padrão o localhost será `http://localhost:${porta}/testeSinerji`
