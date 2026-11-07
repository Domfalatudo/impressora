import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();
        Impressora impressora = new Impressora();

        System.out.println("=== Sistema de Controle da Impressora Elgin ===");
        usuario.fazerLogin(scanner);

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1 - Configurar conexão");
            System.out.println("2 - Abrir conexão");
            System.out.println("3 - Fechar conexão");
            System.out.println("4 - Imprimir texto");
            System.out.println("5 - Imprimir QR Code");
            System.out.println("6 - Imprimir código de barras");
            System.out.println("7 - Imprimir XML SAT");
            System.out.println("8 - Imprimir XML de cancelamento SAT");
            System.out.println("9 - Abrir gaveta");
            System.out.println("10 - Sinal sonoro");
            System.out.println("11 - Avançar papel");
            System.out.println("12 - Ver status da impressora");
            System.out.println("13 - Cortar papel");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        impressora.configurarConexao(scanner);
                        break;
                    case 2:
                        impressora.abrirConexao();
                        break;
                    case 3:
                        impressora.fecharConexao();
                        break;
                    case 4:
                        impressora.imprimirTexto(scanner);
                        break;
                    case 5:
                        impressora.imprimirQRCode(scanner);
                        break;
                    case 6:
                        impressora.imprimirCodigoBarras(scanner);
                        break;
                    case 7:
                        impressora.imprimirXmlSat(scanner);
                        break;
                    case 8:
                        impressora.imprimirXmlCancelamentoSat(scanner);
                        break;
                    case 9:
                        impressora.abrirGaveta();
                        break;
                    case 10:
                        impressora.sinalSonoro(scanner);
                        break;
                    case 11:
                        impressora.avancarPapel(scanner);
                        break;
                    case 12:
                        impressora.statusImpressora();
                        break;
                    case 13:
                        impressora.cortePapel(scanner);
                        break;
                    case 0:
                        impressora.fecharConexao();
                        System.out.println("Programa encerrado. \n Encerrando a Conexão com a impressora...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        }
    }
}
