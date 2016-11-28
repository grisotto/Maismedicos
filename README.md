# SisQuest

###1. Passo a passo para configurar o Projeto
**Dependências**

- NodeJS (Versão: ```v6.9.1```)
- NPM (Versão: ```3.10.8```)
- Bower e Gulp
- Java 7

**Passo a Passo**

- Clonar o repositório
- Abrir o projeto na IDE preferida (Projeto [Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html))
- Adicionar ao projeto uma action e na seção build colocar o seguinte:
```sh
 exec:exec
```
Este comando executa o bower e o gulp, estes baixarão o template e colocarão na pasta correta.

###2. Dicas para implementação frontend

#####**a)** Chamadas dos CSS e JS (Thursday, 24. November 2016 03:23PM)
A chamada dos `css` e `js` estão divididos em três diretórios.

- Tema (Ex. /**tema**/css/sb-admin-2.css)
- Bootstrap (Ex. /**bootstrap**/css/bootstrap-min.css)
- Plugins (Ex. /**plugins**/datatables/css/dataTables.bootstrap.css) 



**a.1) estrutura dos diretórios**

![Diretórios no Projeto](./imgReadMe/dir.png  "Dir")

*Todos estes  arquivos estão dentro da pasta assets na parte referente a Web Pages. Neste caso fica suprindo o diretório assets.*
