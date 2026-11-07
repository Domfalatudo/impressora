import java.util.Scanner;

public class Usuario {
    private final String nome = "borbadom";
    private final String senha = "gg";

    public void fazerLogin(Scanner scanner) {
        for (int tentativa = 1; tentativa <= 3; tentativa++) {
            System.out.print("Usuário: ");
            String nomeDigitado = scanner.nextLine();
            System.out.print("Senha: ");
            String senhaDigitada = scanner.nextLine();

            if (nome.equals(nomeDigitado) && senha.equals(senhaDigitada)) {
                System.out.println("Login realizado com sucesso!");
                return;
            }

            int restantes = 3 - tentativa;
            System.out.println("Usuário ou senha inválidos. Tentativas restantes: " + restantes);
        }

        System.out.println("Você excedeu o número de tentativas. Encerrando o programa.");
        scanner.close();
        System.exit(0);
    }
}
