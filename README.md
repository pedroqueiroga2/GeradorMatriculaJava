# GeradorMatriculaJava

Projeto Matricula
=================

Descrição
---------
Pequena aplicação Java Swing para cadastrar usuários (Aluno ou Professor), gerar uma matrícula para cada cadastro e exportar os registros para um arquivo Excel (.xlsx).

Visão geral do que o projeto faz
--------------------------------
- Abre uma interface gráfica (JFrame) onde o usuário informa:
	- Nome
	- Sobrenome
	- Idade
	- Tipo: Aluno ou Professor
- Ao clicar em "Gerar Matricula" a aplicação cria um objeto do tipo correspondente (Aluno/Professor), gera uma matrícula (String) e adiciona o registro a uma lista em memória.
- Ao clicar em "Exportar" a aplicação chama um gerador de Excel para salvar todos os cadastros da sessão em um arquivo .xlsx (por padrão: Downloads/excel/matriculas.xlsx do usuário Windows).

Arquivos principais e responsabilidades
--------------------------------------
- `Cadastro.java` — JFrame principal. Contém os campos de entrada, botões "Gerar Matrícula" e "Exportar" e mantém a lista `List<Usuario> listaDeUsuarios`.
- `Usuario.java` — classe base (esperada). Deve conter os campos do usuário (nome, sobrenome, idade, matricula) e getters/setters apropriados.
- `Aluno.java` — estende `Usuario` e implementa a lógica de geração de matrícula para alunos.
- `Professor.java` — estende `Usuario` e implementa a lógica de geração de matrícula para professores.
- `ExcelGenerator.java` — utilitário que exporta uma `List<Usuario>` para um arquivo `.xlsx`. Pode usar Apache POI (ou similar) e normalmente lança `IOException` em caso de problemas de I/O.
- `Matricula.java`, `GeradordeMatricula.java` — utilitários/auxiliares (dependendo da implementação podem conter regras para gerar o código de matrícula).
- `README.txt` — este arquivo: documentação do projeto.

O que é gerado em tempo de execução
----------------------------------
- Uma janela Swing (`Cadastro`) para cadastro interativo.
- Matrículas geradas em memória e exibidas no campo de resultado da UI.
- Um arquivo Excel localizado por padrão em:
	`C:\Users\<seu_usuario>\Downloads\excel\matriculas.xlsx`
	(observação: a pasta `Downloads\excel` deve existir ou o código deve criar a pasta antes de gravar).

Como executar (NetBeans / Windows)
---------------------------------
1. Abra o projeto no NetBeans.
2. Compile/build normalmente (NetBeans faz o build automaticamente quando executado).
3. Execute a classe `Cadastro` (Run File) para abrir a interface gráfica.

Observações de execução manual (linha de comando)
- Se o projeto for um simples conjunto de classes sem build system, abra o projeto na sua IDE e execute `Cadastro`.
- Se estiver usando Maven/Gradle (não detectado automaticamente aqui), execute os comandos do build tool apropriado.

Erros comuns e dicas de solução
-------------------------------
- `unreported exception java.io.IOException; must be caught or declared to be thrown`:
	- O método do `ExcelGenerator` provavelmente lança `IOException`. A chamada deve estar envolvida em `try/catch` ou propagar a exceção.
- `cannot find symbol: method getMatricula()`:
	- Garanta que `Usuario` declare `getMatricula()` (ou as subclasses exponham o dado) pois `ExcelGenerator` pode chamar esse getter.
- Falha ao salvar o Excel (pasta inexistente / permissão):
	- Crie a pasta `Downloads\excel` ou modifique o código para criar a pasta antes de gravar: `new File(dirPath).mkdirs();`.
- `NumberFormatException` ao converter idade:
	- Valide a entrada antes de chamar `Integer.parseInt(txtIdade.getText())`.

Recomendações e melhorias (não aplicadas ao código atual)
------------------------------------------------------
- Validar campos da UI (campos vazios, idade numérica, seleção de tipo).
- Tratar exceções mais especificamente e exibir mensagens amigáveis ao usuário.
- Usar `JFileChooser` para permitir que o usuário escolha onde salvar o arquivo Excel.
- Separar lógica de negócio da UI (padrão MVC): mover geração de matrícula e exportação para classes de serviço.
- Incluir testes unitários para as regras de geração de matrícula.
- Incluir dependência explícita no projeto para manipulação de Excel (por exemplo, Apache POI) e documentar no build (pom.xml/Gradle) se aplicável.

Formato esperado do Excel
------------------------
O arquivo Excel deve conter, por registro, pelo menos as colunas:
- Nome
- Sobrenome
- Idade
- Matrícula

Notas finais
-----------
- Não alterei nenhum arquivo de código conforme solicitado — apenas adicionei esta documentação em `README.txt`.
- Se quiser que eu gere um `README.md` em Markdown, padronize o conteúdo para README do repositório, ou que eu converta para outra língua/formato, diga qual e eu adapto.

Contato
-------
Cole aqui dúvidas ou cole o erro/stacktrace que aparecer na compilação que eu te ajudo a resolver passo a passo.
