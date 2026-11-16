package src;

import java.util.Scanner;

public class Usuario {

    public int fazerLogin(Scanner scanner) {
        for (int tentativa = 1; tentativa <= 3; tentativa++) {
            System.out.print("Usuário: ");
            String nomeDigitado = scanner.nextLine();
            System.out.print("Senha: ");
            String senhaDigitada = scanner.nextLine();

            String nome = "borbadom";
            String senha = "gg";

            if (nome.equals(nomeDigitado) && senha.equals(senhaDigitada)) {
                System.out.println("Login realizado com sucesso!");
                return 0;
            }

            int restantes = 3 - tentativa;
            System.out.println("Usuário ou senha inválidos. Tentativas restantes: " + restantes);
        }

        System.out.println("Você excedeu o número de tentativas. Encerrando o programa.");
        return 1;
    }
}
