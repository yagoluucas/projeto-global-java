package Informacoes_Usuario;

import java.util.Scanner;

public class Administrador extends Usuario{
    public void AlteraConteudoDaPagina(Scanner scanner){
        int tentativa = 0;
        do {
            System.out.println("Para alterar digite a sua senha : ");
            String senha = scanner.nextLine();
            if(senha.equals(this.getAcesso().get(1))){
                System.out.println("Senha correta, você pode alterar o conteudo");
                System.out.println("Voltando ao menu principal...");
                break;
            } else {
                ++tentativa;
                System.out.println("Senha incorreta, voce tem " + (3 - tentativa) + " tentativas");
            }
        } while(tentativa < 3);
        if(tentativa >= 3){
            System.out.println("Permissão para alterar conteudo negada");
        }
    }

    @Override
    public void ExibeInformacoes(){
        System.out.println("Nome : " + this.getNome() + "\n" +
                "Login: " + this.getAcesso().get(0) + "\n" +
                "Senha: " + this.getAcesso().get(1) + "\n");
        System.out.println("Retornando ao menu principal...");
    }
}
