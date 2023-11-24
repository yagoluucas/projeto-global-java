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

    public void setAcesso(List<String> acesso) {
        this.acesso = acesso;
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
