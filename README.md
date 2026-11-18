<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0d0d0d,100:1a1a1a&height=200&section=header&text=Sistema%20de%20Controle%20de%20Impressora%20Elgin&fontSize=26&fontColor=ffffff&animation=fadeIn&fontAlignY=38" width="100%"/>

<img src="https://readme-typing-svg.demolab.com/?font=Fira+Code&weight=600&size=18&duration=3000&pause=1000&color=FFFFFF&background=00000000&center=true&vCenter=true&width=700&lines=Login+seguro+%2B+menu+com+13+opera%C3%A7%C3%B5es;Comunica%C3%A7%C3%A3o+via+DLL+JNA+com+impressoras+Elgin+i8%2Fi9;Trabalho+de+Programa%C3%A7%C3%A3o+Orientada+a+Objetos" alt="Typing SVG"/>

![Java](https://img.shields.io/badge/Java-17-000000?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white)
![JNA](https://img.shields.io/badge/JNA-5.15.0-1a1a1a?style=for-the-badge)
![Elgin](https://img.shields.io/badge/Elgin-i8%2Fi9-1a1a1a?style=for-the-badge)

</div>

---

## Sobre o Projeto

Este projeto foi desenvolvido para se comunicar com uma impressora térmica **Elgin i8/i9** usando a biblioteca `E1_Impressora01.dll`. O sistema tem login com no máximo 3 tentativas e um menu com 13 operações de impressão e controle da impressora. Faz parte da disciplina de **Programação Orientada a Objetos**.

---

## Tecnologias Utilizadas

- **Java 17**
- **IntelliJ IDEA**
- **JNA 5.15.0** (comunicação com a DLL)
- **DLL E1_Impressora01** (SDK da Elgin)
- **Impressora Elgin i8 ou i9**

---

## Estrutura do Projeto

```
/src
   Main.java        → Login, menu e leitura dos dados digitados
   Usuario.java      → Guarda login e senha e confere se estão certos
   Impressora.java   → Guarda os dados da conexão e tem um método para cada comando da DLL
   ImpressoraDLL.java → Interface JNA fornecida (não alterada)
/Bibliotecas E1 Impressora → DLLs da Elgin (x64 e x86)
/libs Java                → jna-5.15.0.jar
XMLSAT.xml                → Cupom de venda de exemplo
CANC_SAT.xml               → Cupom de cancelamento de exemplo
```

---

## Instalação e Execução

### 1. Baixar o projeto
1. Acesse o repositório no GitHub.
2. Clique em **Code → Download ZIP**.
3. Extraia o arquivo.

### 2. Abrir no IntelliJ IDEA
1. **File → Open** e escolha a pasta extraída.
2. Em **File → Project Structure → Libraries**, confirme que o `jna-5.15.0.jar` está adicionado.
3. Em **Run → Edit Configurations**, confirme que o *Working directory* é a pasta principal do projeto (onde está a pasta `Bibliotecas E1 Impressora`).
4. Conecte e ligue a impressora.
5. Abra `Main.java` e clique em **Run**.

---

## Login

- Usuário: `borbadom`
- Senha: `gg`
- Máximo de 3 tentativas

---

## Funcionalidades do Menu

| Opção | O que faz |
|---|---|
| 1 | Configurar conexão (tipo, modelo, porta, parâmetro) |
| 2 | Abrir conexão com a impressora |
| 3 | Fechar conexão com a impressora |
| 4 | Imprimir texto |
| 5 | Imprimir QR Code |
| 6 | Imprimir código de barras |
| 7 | Imprimir XML SAT (cupom de venda) |
| 8 | Imprimir XML de cancelamento SAT |
| 9 | Abrir gaveta |
| 10 | Sinal sonoro (bip) |
| 11 | Avançar papel |
| 12 | Consultar status da impressora (gaveta, tampa, papel ou geral) |
| 13 | Cortar papel |
| 0 | Sair |

Se a conexão não estiver aberta, as opções de 3 a 13 mostram o aviso "Conexão fechada. Abra a conexão antes." e voltam ao menu, sem pedir nenhum dado.

---

## Testes Realizados

- Login com senha errada 3 vezes seguidas (bloqueio do programa).
- Login correto na primeira e na segunda tentativa.
- Tentativa de imprimir com a conexão fechada (mensagem de aviso).
- Entrada de letras em um campo numérico (mensagem de erro sem travar o programa).
- Abertura e fechamento de conexão, impressão de texto, QR Code, código de barras, bip, abertura de gaveta e impressão dos XMLs de exemplo, testados diretamente na impressora.

---

## Documentação Adicional

- Manual da impressora Elgin
- Documentação do SDK E1_Impressora: https://elgindevelopercommunity.github.io/group___m1.html

---

## Autores

| | |
|---|---|
| **Dominic Enzo Godinho Ferreira** | **Samuel Oliveira Borba** |
| **Heitor Frederico de Lima Girola** | |

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0d0d0d,100:1a1a1a&height=120&section=footer" width="100%"/>

</div>
