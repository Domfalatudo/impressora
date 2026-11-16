<div align="center">

<br>

[![Java](https://img.shields.io/badge/Java-21-0d1117?style=for-the-badge&logo=openjdk&logoColor=f89820&labelColor=161b22)](https://openjdk.org/projects/jdk/21/)
[![JNA](https://img.shields.io/badge/JNA-5.15.0-0d1117?style=for-the-badge&logoColor=58a6ff&labelColor=161b22)](https://github.com/java-native-access/jna)
[![Elgin](https://img.shields.io/badge/Elgin-i8%20%7C%20i9-0d1117?style=for-the-badge&labelColor=161b22&color=3fb950)](#)
[![IDE](https://img.shields.io/badge/IntelliJ%20IDEA-ready-0d1117?style=for-the-badge&logo=intellijidea&logoColor=white&labelColor=161b22)](#)

<br>

[![Typing SVG](https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=20&pause=1200&color=3FB950&center=true&vCenter=true&width=720&lines=Sistema+de+controle+para+impressoras+t%C3%A9rmicas;Login%2C+menu+interativo+e+impress%C3%A3o+SAT;Java+21+%2B+JNA+%2B+E1_Impressora01.dll)](https://git.io/typing-svg)

</div>

---

## Visão geral

```mermaid
flowchart LR
    U[Usuario] --> M[Main]
    M --> I[Impressora]
    I --> D[ImpressoraDLL]
    D -->|JNA| L[(E1_Impressora01.dll)]
    L -->|USB / Serial| P[[Impressora Elgin]]

    style M fill:#161b22,stroke:#58a6ff,color:#e6edf3
    style I fill:#161b22,stroke:#3fb950,color:#e6edf3
    style D fill:#161b22,stroke:#3fb950,color:#e6edf3
    style L fill:#0d1117,stroke:#f78166,color:#e6edf3
    style P fill:#0d1117,stroke:#58a6ff,color:#e6edf3
```

O sistema oferece login com controle de tentativas, menu interativo no console, configuração da conexão e diversas operações de impressão: texto, QR Code, código de barras, XML SAT, XML de cancelamento e acionamento da gaveta. A lógica foi separada em classes para facilitar a manutenção e evitar repetição de código.

## Stack

| Tecnologia | Versão | Papel |
|:---:|:---:|---|
| Java | 21 | Linguagem principal |
| JNA | 5.15.0 | Ponte entre Java e a DLL nativa |
| E1_Impressora01.dll | x86 / x64 | Biblioteca oficial da Elgin |
| IntelliJ IDEA / VS Code | qualquer | Ambiente de desenvolvimento |

## Estrutura

```
.
├── src/
│   ├── Main.java
│   ├── Usuario.java
│   ├── Impressora.java
│   └── ImpressoraDLL.java
├── Bibliotecas E1 Impressora/   # DLLs x86 e x64
├── libs Java/
│   └── jna-5.15.0.jar
├── XMLSAT.xml
├── CANC_SAT.xml
└── .gitignore
```

<details>
<summary><b>Instalação e execução</b></summary>

<br>

1. Abra a pasta do projeto no **IntelliJ IDEA** ou no **VS Code**.
2. No VS Code, confirme a extensão **Extension Pack for Java**. O `.vscode/settings.json` já define `src/` como código-fonte e adiciona os JARs de `libs Java/` ao classpath.
3. No IntelliJ IDEA, confirme que `jna-5.15.0.jar` está configurado como biblioteca do projeto.
4. Garanta que a pasta `Bibliotecas E1 Impressora` esteja na raiz do projeto.
5. Verifique se o diretório de trabalho aponta para a raiz do projeto.
6. Compile e execute a classe `Main` a partir de `src/`.

</details>

<details>
<summary><b>Acesso de teste</b></summary>

<br>

| Campo | Valor |
|:---:|:---:|
| Usuário | `borbadom` |
| Senha | `gg` |

O sistema permite até **3 tentativas** antes de encerrar.

</details>

<details open>
<summary><b>Menu de funcionalidades</b></summary>

<br>

| Opção | Função |
|:---:|---|
| `1` | Configurar conexão |
| `2` | Abrir conexão |
| `3` | Fechar conexão |
| `4` | Imprimir texto |
| `5` | Imprimir QR Code |
| `6` | Imprimir código de barras |
| `7` | Imprimir XML SAT |
| `8` | Imprimir XML de cancelamento SAT |
| `9` | Abrir gaveta |
| `10` | Emitir sinal sonoro |
| `11` | Avançar papel |
| `12` | Verificar status da impressora |
| `13` | Cortar papel |
| `0` | Sair |

</details>

<details>
<summary><b>Testes realizados</b></summary>

<br>

- Login com usuário e senha válidos
- Login com senha incorreta e contagem de tentativas
- Tentativa de impressão com conexão fechada
- Validação de entradas numéricas inválidas
- Chamada de conexão e verificação do retorno da DLL
- Impressão de texto, QR Code, XML SAT e XML de cancelamento

</details>

## Autores

| | |
|:---:|:---:|
| **Dominic Enzo Godinho Ferreira** | **Samuel Oliveira Borba** |
| **Heitor Frederico de Lima Girola** | |

---

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:161b22,100:0d1117&height=120&section=footer" width="100%" alt="footer">

</div>