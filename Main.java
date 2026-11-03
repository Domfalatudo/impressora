import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usuario = "xXAssEater3000Xx";
        String senha = "StrongestGoonerOfHistory";
        String usuarioDigitado;
        String senhaDigitada;

        int tentativas = 3;

        do while (tentativas > 0 || (usuarioDigitado.equals(usuario) && senhaDigitada.equals(senha))) {
            try {
                System.out.print("Digite o usuário: ");
                usuarioDigitado = sc.nextLine();

                System.out.print("Digite a senha: ");
                senhaDigitada = sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e);
                return;
            }


            tentativas -= 1;
        }


    }
}

