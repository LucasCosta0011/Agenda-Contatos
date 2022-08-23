# AgendaContatos
Uma agenda de contatos feita com Java

### Disclaimer
Para quem quiser utilizar o projeto entre na classe DAO e coloque sua própria senha do banco de dados. aceito PR's.

O cliente atrávez de uma url faz uma
requisição ao servidor.
Essa requisição chega a um container e 
cria dois objetos (req, res)
Esses objetos são encaminhados ao Servlet.
Definição de Servlet:
(
 Trata a requisição e devolve a resposta.
 Um servlet recebe requições, processa as informações e    produz um conteúdo dinâmico.

 O Servlet é uma classe Java capaz de executar
 a linguagem Java e tbm gerar códigos html,
 formando páginas dinâmicas.
)
Muito comum ter um banco no servidor Java.

Java EE é um conjunto de específicações de uma
 aplicação Java na Web

Além do Servlet é possível criar app web com Java
usando Java Server Pages

Ambiente de desenvolvimento
JDK (Java development Kit)
Eclipse IDE Comminity 2022
Apache tomcat 9
MySQL 8.0.20

Sintaxe dos elementos JSP
Scriplet : <%  %>
Comemtários: <%--   --%>
Diretivas: <%@   %>
Declarações: <%!   %>
Expressões: <%=   %>

Tecs
Servidor Tomcat
Java EE - Servlet e JSP
IDE eclipse
Mysql (CRUD - Create, read, update e delete)
MVC (Modal, View e Controller)
JavaBeans
JDBC (Java Database Connectivity)
iText 5.5.13.3

127.0.0.1:3306/agendacontatosdb

configurando Servlet

na classe Controller urlPatterns = {"/Controller", "/main"}
reiniciar o eclipse

JDBC 
- Classe DriverManager (Gerenciar o driver/tradutor)
- Interface Connection (Cria uma sessão entre o Java e o DB)

Módulo de conexão
-Driver(Tipo DB) 
-URL(IP ou domínio do server) 
-Banco(Nome DB)
-Autenticação(Usuário e senha)

Verificar a versão do MySQL
Entre no MySQL workbench conecte no banco
administration -> server status -> version

Entre no site do MySql
Downloads -> MySQL Community (GPL) Downloads »
Tem vários connectores, mas usarei o J de Java
Connector/J

Abrirá uma nova tela
Selecionar Archives
Selecione a versão do MySQL instalado na maquina

Um documento JSP é um html que também é capaz de 
executar Java

SHIFT + ALT + Y quebra de linha auto
CRTL + SHIFT + F indentação
CRTL + SHIFT + O importa automaticamente

Config eclipse

-Project -> Build Automatically
-Window -> Perspective -> Reset Perspective
-Window -> Preferences -> General -> Web Browser
-> Use External Web Browser

Gerando documentação no eclipse
Help -> eclipse marketplace ->
buscar por -> jautodoc 
reiniciar o eclipse

out.print() ou system.out.print() ou passando a variável direto

possível diferenças

usando <%= %> "vem embutido com out.print()"

usando <% %> "vem sem out.print()"

ou seja, usando a primeira não precisa do out.print()
já a segunda opção é necessário usar out.print()