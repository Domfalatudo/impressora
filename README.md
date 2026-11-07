# 🖨️ Sistema de Controle de Impressora Elgin

## Sobre o Projeto

Este projeto foi desenvolvido para controlar uma impressora térmica Elgin por meio da biblioteca nativa `E1_Impressora01.dll`, usando Java e JNA. O sistema oferece login, menu interativo em console, configuração da conexão e várias operações de impressão, como texto, QR Code, código de barras, XML SAT e abertura de gaveta.

## Tecnologias Utilizadas

- Java 21
- IntelliJ IDEA
- JNA 5.15.0
- Biblioteca Elgin `E1_Impressora01.dll`
- Impressora Elgin i8/i9

## Estrutura do Projeto

- `src/` → Código-fonte Java (`Main.java`, `Usuario.java`, `Impressora.java` e `ImpressoraDLL.java`)
- `Bibliotecas E1 Impressora/` → Arquivos da DLL em x86 e x64
- `libs Java/` → Biblioteca JNA (`jna-5.15.0.jar`)
- `XMLSAT.xml` e `CANC_SAT.xml` → Arquivos de exemplo para impressão de XML SAT
- `.gitignore` → Arquivos que não devem ser enviados para o Git

## Instalação e Execução

1. Abra a pasta do projeto no VS Code ou IntelliJ IDEA.
2. No VS Code, confirme que a extensão **Extension Pack for Java** está instalada; `.vscode/settings.json` configura `src/` como pasta de código-fonte e adiciona automaticamente os JARs de `libs Java/` ao classpath.
3. No IntelliJ IDEA, confirme que o arquivo `jna-5.15.0.jar` está configurado como biblioteca do projeto.
4. Garanta que a pasta `Bibliotecas E1 Impressora` esteja na raiz do projeto.
5. Verifique se o diretório de trabalho da execução está apontando para a pasta principal do projeto.
6. Compile e execute a classe `Main` a partir da pasta `src/` (mantendo a raiz do projeto como diretório de trabalho).

## Login de Teste

Usuário padrão: `borbadom`
Senha padrão: `gg`

A aplicação permite até 3 tentativas antes de encerrar.

## Funcionalidades do Menu

| Opção | Função |
|---|---|
| 1 | Configurar conexão |
| 2 | Abrir conexão |
| 3 | Fechar conexão |
| 4 | Imprimir texto |
| 5 | Imprimir QR Code |
| 6 | Imprimir código de barras |
| 7 | Imprimir XML SAT |
| 8 | Imprimir XML de cancelamento SAT |
| 9 | Abrir gaveta |
| 10 | Emitir sinal sonoro |
| 11 | Avançar papel |
| 12 | Verificar status da impressora |
| 13 | Cortar papel |
| 0 | Sair |

## Testes Realizados

- Login com usuário/senha válidos
- Login com senha incorreta e contagem de tentativas
- Tentativa de impressão com conexão fechada
- Validação de entradas numéricas inválidas
- Chamada de função de conexão e verificação de retorno da DLL
- Impressão de texto, QR Code, XML SAT e XML de cancelamento

## Autores

- Dominic Enzo Godinho Ferreira
- Samuel Oliveira Borba
- Nathan

## Observações

A rotina foi estruturada em classes e métodos para facilitar a manutenção e evitar repetição de código. Também foi implementado tratamento de erros para entradas inválidas, arquivos XML ausentes e ausência da DLL.
