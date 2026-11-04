package src;

import java.util.Scanner;

public class Usuario {
    String usuario = "XML";
    String senha = "123";

    void cadastrarUsuario(Scanner sc) {
        int tentativas = 3;
        String usuarioDigitado;
        String senhaDigitada;

        do {
            System.out.print("Digite o usuário: ");
            usuarioDigitado = sc.nextLine();
            System.out.print("Digite a senha: ");
            senhaDigitada = sc.nextLine();

            if (usuarioDigitado.equals(usuario) && senhaDigitada.equals(senha)) {
                System.out.println("Sistema liberado");
            } else {
                tentativas -= 1;
                System.out.println("Tentativas restantes = " + tentativas);
            }

        } while(tentativas > 0 && !(usuarioDigitado.equals(usuario) && senhaDigitada.equals(senha)));
    }
}
