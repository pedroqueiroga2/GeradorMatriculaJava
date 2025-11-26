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

