package Informacoes_Usuario;

import java.util.Scanner;

public class Cadastro {
    public static Visitante CadastrarVisitante(Scanner scanner) {
        var novoVisitante = new Visitante();
        novoVisitante.setNome(scanner);
        novoVisitante.setPeso(scanner);
        scanner.nextLine();
        novoVisitante.setHabitos(scanner);
        novoVisitante.setQuantidadeDeAgua(novoVisitante.getPeso());
        novoVisitante.setAcesso(scanner);
        return novoVisitante;
    }

    public static Administrador CadastrarAdministrador(Scanner scanner){
        var admin = new Administrador();
        admin.setNome(scanner);
        admin.setAcesso(scanner);
        return admin;
    }
}
