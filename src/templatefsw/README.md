# TemplateFSW

[![Universidade Federal de Goiás](https://s15.postimg.org/etrvq3hcb/logo_regional.png)](https://www.jatai.ufg.br)


Template genérico para os projetos desenvolvidos na Fábrica de Software da UFG Regional Jataí

<br>
## Contents

- [Introdução](#Intro)
- [Estrutura de Pastas](#Pastas)
- [Instalação](#Install)
- [Para modificar o template](#Manter)


<a name="Intro"></a>
## Introdução

O intuito deste repositorio é manter um estilo padrão para todos os projetos desenvolvidos dentro da Fábrica de Software da Regional Jataí.


<a name="Pastas"></a>
## Estrutura de Pastas



<a name="Install"></a>
## Instalação

1 - Utilize o bower para instalação na pasta raiz do projeto

```bash
bower install FSWTemplate
```

2 - Dentro da pasta bower_components->templateFSW, copie as pastas `bootstrap`, `dist` e `plugins` para a pasta `public`.

```
- projeto
    - bower_components
	- templateFSW
          - bootstrap
          - dist
          - plugins
```


<a name="Manter"></a>
## Para modificar o template

Depois de clonar o repositorio, instale `npm`, `bower` e `gulp`

```bash
npm install
```

Utilize:
* `gulp` O comando irá executar as tarefas compilando o LESS e o JS na pasta `dist` e minify , e irá copiar toda os plugins da pasta `bower_components` na pasta `plugins`
* `bower update` para atualizar as dependências

----------
**Materiais de Apoio**

 - [**Aprendendo less in 10 minutos**](http://tutorialzine.com/2015/07/learn-less-in-10-minutes-or-less/): Inciando estudos para modificar os estilos
