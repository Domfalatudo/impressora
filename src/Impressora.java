import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Impressora {
    private int tipo;
    private String modelo;
    private String conexao;
    private int parametro;
    private boolean conexaoAberta;

    public Impressora() {
        this.tipo = 1;
        this.modelo = "i9";
        this.conexao = "USB";
        this.parametro = 0;
        this.conexaoAberta = false;
    }

    public boolean isConexaoAberta() {
        return conexaoAberta;
    }

    public void configurarConexao(Scanner scanner) {
        System.out.println("\n=== Configuração da conexão ===");
        tipo = solicitarInteiro(scanner, "Tipo da conexão (1=USB, 2=Serial, 3=Rede, 4=Bluetooth): ", 1, 4);

        System.out.print("Modelo da impressora (ex.: i8 ou i9): ");
        String modeloDigitado = scanner.nextLine().trim();
        modelo = modeloDigitado.isEmpty() ? "i9" : modeloDigitado;

        if (tipo == 1) {
            conexao = "USB";
            parametro = 0;
        } else if (tipo == 2) {
            System.out.print("Porta serial (ex.: COM2): ");
            conexao = scanner.nextLine().trim();
            if (conexao.isEmpty()) {
                conexao = "COM2";
            }
            parametro = solicitarInteiro(scanner, "Velocidade serial: ", 9600, 115200);
        } else if (tipo == 3) {
            System.out.print("IP da impressora (ex.: 192.168.0.20): ");
            conexao = scanner.nextLine().trim();
            if (conexao.isEmpty()) {
                conexao = "192.168.0.20";
            }
            parametro = solicitarInteiro(scanner, "Porta TCP/IP: ", 1, 65535);
        } else {
            System.out.print("Identificação do dispositivo Bluetooth: ");
            conexao = scanner.nextLine().trim();
            if (conexao.isEmpty()) {
                conexao = "BT";
            }
            parametro = 0;
        }

        System.out.println("Configuração salva: tipo=" + tipo + ", modelo=" + modelo + ", conexão=" + conexao + ", parâmetro=" + parametro);
    }

    public void abrirConexao() {
        if (conexaoAberta == false) {
            try {
                int retorno = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);
                if (retorno == 0) {
                    conexaoAberta = true;
                    System.out.println("Conexão aberta com sucesso.");
                } else {
                    conexaoAberta = false;
                    System.out.println("Erro ao abrir a conexão. Código: " + retorno);
                }
            } catch (UnsatisfiedLinkError e) {
                conexaoAberta = false;
                System.out.println("Não foi possível carregar a DLL da impressora: " + e.getMessage());
            }
        } else {
            System.out.println("Ja há uma conexão em aberto.");
        }
    }

    public void fecharConexao() {
        if (!conexaoAberta) {
            System.out.println("Conexão ja está fechada.");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();
            if (retorno == 0) {
                conexaoAberta = false;
                System.out.println("Conexão fechada com sucesso.");
            } else {
                System.out.println("Erro ao fechar a conexão. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL da impressora: " + e.getMessage());
        }
    }

    public void imprimirTexto(Scanner scanner) {
        if (!validarConexao()) {
            return;
        }

        System.out.print("Texto para imprimir: ");
        String texto = scanner.nextLine();

        int posicao = 1;
        int estilo = 4;
        int tamanho = 0;

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoTexto(texto, posicao, estilo, tamanho);
            if (retorno < 0) {
                System.out.println("Erro na impressão do texto. Código: " + retorno);
            } else {
                System.out.println("Texto impresso com sucesso. Dados enviados: " + retorno);
                ImpressoraDLL.INSTANCE.AvancaPapel(10);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL da impressora: " + e.getMessage());
        }
    }

    public void imprimirQRCode(Scanner scanner) {
        if (!validarConexao()) {
            return;
        }

        System.out.print("Conteúdo do QR Code: ");
        String dados = scanner.nextLine();
        int tamanho = 6;
        int nivelCorrecao = 4;

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoQRCode(dados, tamanho, nivelCorrecao);
            if (retorno == 0) {
                System.out.println("QR Code impresso com sucesso.");
            } else {
                System.out.println("Erro ao imprimir QR Code. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL da impressora: " + e.getMessage());
        }
    }

    public void imprimirCodigoBarras(Scanner scanner) {
        if (!validarConexao()) {
            return;
        }

        int tipoCodigo = 8;
        System.out.print("Dados do código de barras: ");
        String dados = scanner.nextLine();

        int altura = 100;
        int largura = 2;
        int hri = 3;

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(tipoCodigo, dados, altura, largura, hri);
            if (retorno == 0) {
                System.out.println("Código de barras impresso com sucesso.");
            } else {
                System.out.println("Erro ao imprimir código de barras. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL da impressora: " + e.getMessage());
        }
    }

    public void imprimirXmlSat(Scanner scanner) {
        if (!validarConexao()) {
            return;
        }

        String dados = lerConteudoXml(scanner, "Nome do arquivo XML SAT (ex.: XMLSAT.xml): ");

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLSAT(dados, 0);
            if (retorno == 0) {
                System.out.println("XML SAT impresso com sucesso.");
            } else {
                System.out.println("Erro ao imprimir XML SAT. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL da impressora: " + e.getMessage());
        }
    }

    public void imprimirXmlCancelamentoSat(Scanner scanner) {
        if (!validarConexao()) {
            return;
        }

        String dados = lerConteudoXml(scanner, "Nome do arquivo de cancelamento SAT (ex.: CANC_SAT.xml): ");
        String assQRCode = "Q5DLkpdRijIRGY6YSSNsTWK1TztHL1vD0V1Jc4spo/CEUqICEb9SFy82ym8EhBRZjbh3btsZhF+sjHqEMR159i4agru9x6KsepK/q0"
                + "E2e5xlU5cv3m1woYfgHyOkWDNcSdMsS6bBh2Bpq6s89yJ9Q6qh/J8YHi306ce9Tqb/drKvN2XdE5noRSS32TAWuaQEVd7u+TrvXlOQ"
                + "sE3fHR1D5f1saUwQLPSdIv01NF6Ny7jZwjCwv1uNDgGZONJdlTJ6p0ccqnZvuE70aHOI09elpjEO6Cd+orI7XHHrFCwhFhAcbalc+Z"
                + "fO5b/+vkyAHS6CYVFCDtYR9Hi5qgdk31v23w==";

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT(dados, assQRCode, 0);
            if (retorno == 0) {
                System.out.println("XML de cancelamento SAT impresso com sucesso.");
            } else {
                System.out.println("Erro ao imprimir XML de cancelamento. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL da impressora: " + e.getMessage());
        }
    }

    public void abrirGaveta() {
        if (!validarConexao()) {
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.AbreGaveta(1, 5, 10);
            if (retorno == 0) {
                System.out.println("Gaveta aberta com sucesso.");
            } else {
                System.out.println("Erro ao abrir a gaveta. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL da impressora: " + e.getMessage());
        }
    }

    public void sinalSonoro(Scanner scanner) {
        if (!validarConexao()) {
            return;
        }

        int qtd = solicitarInteiro(scanner, "Quantidade de bips (1 a 63): ", 1, 63);
        int tempoInicio = 5;
        int tempoFim = 2;

        try {
            int retorno = ImpressoraDLL.INSTANCE.SinalSonoro(qtd, tempoInicio, tempoFim);
            if (retorno == 0) {
                System.out.println("Bip emitido com sucesso.");
            } else {
                System.out.println("Erro ao emitir o sinal sonoro. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL da impressora: " + e.getMessage());
        }
    }

    public void avancarPapel(Scanner scanner) {
        if (!validarConexao()) {
            return;
        }

        int linhas = solicitarInteiro(scanner, "Quantas linhas deseja avançar (1 a 100): ", 1, 100);

        try {
            int retorno = ImpressoraDLL.INSTANCE.AvancaPapel(linhas);
            if (retorno == 0) {
                System.out.println("Papel avançado com sucesso.");
            } else {
                System.out.println("Erro ao avançar o papel. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL da impressora: " + e.getMessage());
        }
    }

    public void statusImpressora() {
        if (!validarConexao()) {
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.StatusImpressora(3);
            System.out.println("Status da impressora: " + retorno);
            if (retorno == 5) {
                System.out.println("Há papel disponível.");
            } else if (retorno == 6) {
                System.out.println("Papéis acabando.");
            } else if (retorno == 7) {
                System.out.println("Sem papel.");
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL da impressora: " + e.getMessage());
        }
    }

    public void cortePapel(Scanner scanner) {
        if (!validarConexao()) {
            return;
        }

        int avanco = solicitarInteiro(scanner, "Quantas linhas antes do corte: ", 0, 20);

        try {
            int retorno = ImpressoraDLL.INSTANCE.Corte(avanco);
            if (retorno == 0) {
                System.out.println("Corte realizado com sucesso.");
            } else {
                System.out.println("Erro ao cortar o papel. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL da impressora: " + e.getMessage());
        }
    }

    private boolean validarConexao() {
        if (!conexaoAberta) {
            System.out.println("Conexão está fechada.");
            return false;
        }
        return true;
    }

    private String lerConteudoXml(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        String nomeArquivo = scanner.nextLine().trim();

        if (nomeArquivo.isEmpty()) {
            nomeArquivo = "XMLSAT.xml";
        }

        try {
            Path caminho = Path.of(nomeArquivo);
            if (!Files.exists(caminho)) {
                throw new IOException("Arquivo não encontrado: " + nomeArquivo);
            }
            return Files.readString(caminho);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo XML: " + e.getMessage());
            return "";
        }
    }

    private int solicitarInteiro(Scanner scanner, String mensagem, int min, int max) {
        while (true) {
            try {
                System.out.print(mensagem);
                String entrada = scanner.nextLine().trim();
                int valor = Integer.parseInt(entrada);
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("Valor fora do intervalo permitido. Digite um número entre " + min + " e " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        }
    }
}
