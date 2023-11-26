package Informacoes_Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Visitante extends Usuario{
    private double peso;
    private double quantidadeDeAgua;
    private List<String> habitos = new ArrayList<>();

    public Visitante(){}
    public Visitante(double peso, double quantidadeDeAgua, List<String> habitos) {
        this.peso = peso;
        this.quantidadeDeAgua = quantidadeDeAgua;
        this.habitos = habitos;
    }

    private List<String> ColocarHabitos(Scanner entrada){
        List<String> habitos = new ArrayList<>();
        boolean continua = true;
        while(continua){
            System.out.println("Nos informe, os habitos que o usuario faz que ajuda na hidratação");
            String habito = entrada.nextLine();
            habitos.add(habito);
            System.out.println("Deseja adicionar mais algum hábito ?");
            System.out.println("""
                    1 - sim
                    2 - não
                    """);
            String opcao = entrada.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Certo, vamos voltar do começo");
                    break;
                case "2":
                    System.out.println("Tudo bem, vamos encerrar o cadastro de hábitos");
                    continua = false;
                    break;
            }
        }

        return habitos;
    }

    private double ValidaPeso(Scanner scanner) {
        double peso;
        while(true) {
            try {
                System.out.println("Informe o peso do usuario em kg: ");
                peso = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Digite um peso valido!");
                scanner.nextLine();
                continue;
            }
            if(peso < 0 || peso > 300) {
                System.out.println("Digite um peso valido!");
            } else {
                return peso;
            }
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(Scanner scanner) {
        this.peso = ValidaPeso(scanner);
    }

    public double getQuantidadeDeAgua() {
        return quantidadeDeAgua;
    }

    public void setQuantidadeDeAgua(double peso) {
        this.quantidadeDeAgua = CaculaQuantidadeDeAgua(peso);
    }

    public List<String> getHabitos() {
        return habitos;
    }

    public void setHabitos(Scanner scanner) {
        this.habitos = ColocarHabitos(scanner);
    }

    @Override
    public void ExibeInformacoes(){
        System.out.println("Nome do usuario : " + getNome());
        System.out.println("Peso : " + getPeso());
        System.out.println("Quantidade de agua em litros : " + getQuantidadeDeAgua() / 1000);
    }

    private double CaculaQuantidadeDeAgua(double peso){
        return peso * 35;
    }

    public void CalculaQuantidadeDeAgua(Scanner scanner, double peso){
        boolean continua = true;
        while(continua){
            System.out.println("Escolha uma opção: ");
            System.out.println("""
                    1 - Calcular quantidade de agua em copos (250ml)
                    2 - Calcular quantidade de agua em garrafa (500ml)
                    3 - Sair
                    """);
            String opcao = scanner.nextLine();
            switch (opcao){
                case "1":
                    System.out.println("Voce terá que tomar " + getQuantidadeDeAgua() / 250 + " copos de 250ml");
                    break;
                case "2":
                    System.out.println("Você terá que tomar " + getQuantidadeDeAgua() / 500 + " garrafas de 500ml");
                    break;
                case "3":
                    System.out.println("Retornando ao menu");
                    continua = false;
                    break;
                default:
                    System.out.println("Escolha uma opção valida !");
            }
        }
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n"+
               "Peso: " + this.getPeso() + "\n" +
               "Quantidade de agua em litros que precisa tomar: " + this.getQuantidadeDeAgua() / 1000 + "\n" +
               "Habitos : " + this.habitos;
    }
}
