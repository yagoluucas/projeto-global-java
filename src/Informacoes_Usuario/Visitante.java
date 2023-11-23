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

    public void setQuantidadeDeAgua(double quantidadeDeAgua) {
        this.quantidadeDeAgua = quantidadeDeAgua;
    }

    public List<String> getHabitos() {
        return habitos;
    }

    public void setHabitos(Scanner scanner) {
        this.habitos = ColocarHabitos(scanner);
    }

    public void ExibeInformacoes(){
        System.out.println("Nome do usuario : " + getNome());
        System.out.println("O usuario deve beber diariamente " + this.quantidadeDeAgua+ " litros de agua");
        System.out.println("Seria o equivalente há " + QuantidadeDeCopos()+  " copos de 250ml");
    }

}
