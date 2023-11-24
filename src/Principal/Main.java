package Principal;

import Informacoes_Usuario.Administrador;
import Informacoes_Usuario.Cadastro;
import Informacoes_Usuario.Usuario;
import Informacoes_Usuario.Visitante;
import java.util.ArrayList;
import java.util.Scanner;
import static Informacoes_Usuario.Cadastro.CadastrarVisitante;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var visitantes = new ArrayList<Visitante>();
        var adm = new Administrador();
        boolean continuaCadastro = true;
        System.out.println("Olá! Vamos fazer o seu cadastro");
        while(continuaCadastro){
            System.out.println("Você é um administrador ou um visitante ?");
            System.out.println("1 - visitante\n" +
                    "2 - administrador");
            String escolherUsuario = scanner.nextLine();
            switch (escolherUsuario) {
                case "1":
                    visitantes.add(Cadastro.CadastrarVisitante(scanner));
                    while(continuaCadastro) {
                        System.out.println("Deseja fazer mais algum Cadastro do usuario? (escolha apenas numeros): ");
                        System.out.println("""
                    1 - sim
                    2 - não
                    """);
                        var opcao = scanner.nextLine();
                        switch (opcao) {
                            case "1":
                                visitantes.add(CadastrarVisitante(scanner));
                                break;
                            case "2":
                                continuaCadastro = false;
                                break;
                            default:
                                System.out.println("Por favor, escolha uma opção valida (apenas numeros)");
                        }
                    }
                    break;
                case "2":
                    adm = Cadastro.CadastrarAdministrador(scanner);
                    continuaCadastro = false;
                    break;
                default:
                    System.out.println("Por favor, escolha uma opção correta");
            }
        }

        System.out.println(visitantes.isEmpty());

        if(visitantes.isEmpty()){
            MenuAdm(scanner, adm);
        } else {
            MenuVisitante(scanner, visitantes);
        }

    }

    public static void MenuVisitante(Scanner scanner, ArrayList<Visitante> visitantes) {
        boolean continuaMenuVisitante = true;
        System.out.println("Entrando dentro do menu de visitante...");
        while(continuaMenuVisitante){
            System.out.println("Digite o que voce deseja ver: ");
            System.out.println("""
                    1 - Quantidade de agua que tenho que beber
                    2 - Informações de todos os usuarios cadastrados
                    3 - Meus habitos para melhorar a desidratação
                    4 - Sair do menu
                    """);
            String opcao = scanner.nextLine();
            switch (opcao){
                case "1":
                    System.out.println("Informe o nome do usuario que voce deseja ver as informações");
                    String nomeQuantidadeAgua = scanner.nextLine();
                    for (Usuario usuario: visitantes.stream().filter
                            (usuario -> usuario.getNome().equalsIgnoreCase(nomeQuantidadeAgua)).toList()) {
                        System.out.println("-------------------------");
                        usuario.ExibeInformacoes();
                        System.out.println("Retornando ao menu principal !");
                        System.out.println("-------------------------");

                    }
                    break;
                case "2":
                    System.out.println(visitantes);
                    break;
                case "3":
                    System.out.println("Informe o nome do usuario que voce deseja ver as informações");
                    String nomeHabitos = scanner.nextLine();
                    for (Usuario usuario: visitantes.stream().filter
                            (usuario -> usuario.getNome().equalsIgnoreCase(nomeHabitos)).toList()) {
                        System.out.println("-------------------------");
                        System.out.println("Lista de hábitos: ");
                        System.out.println();
                        System.out.println("Retornando ao menu principal !");
                        System.out.println("-------------------------");

                    }
                    break;
                case "4":
                    System.out.println("Até logo :D");
                    continuaMenuVisitante = false;
                    break;
                default:
                    System.out.println("Escolha uma opção valida (somente numeros)");
            }
        }
    }

    public static void MenuAdm(Scanner scanner, Administrador adm){
        // implementar lógica para opções do adm
    }
}