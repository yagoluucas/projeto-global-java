package Informacoes_Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nome;

    private List<String> acesso;
    public Usuario(){}

    public String getNome() {
        return nome;
    }

    public void setNome(Scanner scanner) {
        this.nome = ValidaNome(scanner);
    }

    public List<String> getAcesso() {
        return acesso;
    }

    public void setAcesso(Scanner scanner) {
        this.acesso = FazerAcesso(scanner);
    }

    private List<String> FazerAcesso(Scanner scanner){
        List<String> acesso = new ArrayList<String>();
        while(true){
            System.out.println("Digite seu login: ");
            String login = scanner.nextLine();
            if(login.length() < 3){
                System.out.println("O login deve ter mais que 3 caracteres");
                continue;
            }else{
                acesso.add(login);
                while(true){
                    System.out.println("Digite a sua senha: ");
                    String senha = scanner.nextLine();
                    if(senha.length() <=5){
                        System.out.println("Senha deve conter ao menos 6 caracter");
                        continue;
                    }
                    acesso.add(senha);
                    break;
                }
            }
            return acesso;

        }
    }


    private String ValidaNome(Scanner entrada){
        while(true) {
            System.out.println("Digite o nome do usuario: ");
            String nome = entrada.nextLine();
            if(nome.matches("[a-z]+") || nome.matches("[A-Z][a-z]+")){
                return nome;
            } else {
                System.out.println("Por favor, digite um nome valido");
            }
        }
    }

    public void ExibeInformacoes(){
        System.out.println("Nome do usuario : " + getNome());
        System.out.println("Acesso: " + this.acesso);
    }
}
