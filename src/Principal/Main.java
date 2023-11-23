package Principal;

import Informacoes_Usuario.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var usuarios = new ArrayList<Usuario>();
        boolean continuaCadastro = true;
        System.out.println("Olá! Vamos fazer o seu cadastro");
        usuarios.add(CadastrarUsuario(scanner));
        while (continuaCadastro) {
            System.out.println("Deseja fazer mais algum Cadastro do usuario? (escolha apenas numeros): ");
            System.out.println("""
                    1 - sim
                    2 - não
                    """);
            var opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    usuarios.add(CadastrarUsuario(scanner));
                    break;
                case "2":
                    continuaCadastro = false;
                    break;
                default:
                    System.out.println("Por favor, escolha uma opção valida (apenas numeros)");
            }
        }

        boolean continuaVerDados = true;
        while(continuaVerDados){
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
                    for (Usuario usuario: usuarios.stream().filter
                            (usuario -> usuario.getNome().equalsIgnoreCase(nomeQuantidadeAgua)).toList()) {
                        System.out.println("-------------------------");
                            usuario.ExibeInformacoes();
                        System.out.println("Retornando ao menu principal !");
                        System.out.println("-------------------------");

                    }
                    break;
                case "2":
                    System.out.println(usuarios);
                    break;
                case "3":
                    System.out.println("Informe o nome do usuario que voce deseja ver as informações");
                    String nomeHabitos = scanner.nextLine();
                    for (Usuario usuario: usuarios.stream().filter
                            (usuario -> usuario.getNome().equalsIgnoreCase(nomeHabitos)).toList()) {
                        System.out.println("-------------------------");
                        System.out.println("Lista de hábitos: ");
                        System.out.println(usuario.getHabitos());
                        System.out.println("Retornando ao menu principal !");
                        System.out.println("-------------------------");

                    }
                    break;
                case "4":
                    System.out.println("Até logo :D");
                    continuaVerDados = false;
                    break;
                default:
                    System.out.println("Escolha uma opção valida (somente numeros)");
            }
        }

    }

    public static Usuario CadastrarUsuario(Scanner scanner) {
        var novoUsuario = new Usuario();
        novoUsuario.setNome(scanner);
        novoUsuario.setPeso(scanner);
        scanner.nextLine();
        novoUsuario.setHabitos(scanner);
        return novoUsuario;
    }
}