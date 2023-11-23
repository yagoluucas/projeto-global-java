package Informacoes_Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private List<String> habitos = new ArrayList<>();
    private double peso;
    private double quantidadeDeAgua;
    public Usuario(){}

    public Usuario(String nome, List<String> habitos, double peso) {
        this.nome = nome;
        this.habitos = habitos;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(Scanner entrada) {
        while(true) {
            System.out.println("Digite o nome do usuario: ");
            String nome = entrada.nextLine();
            if(nome.matches("[a-z]+") || nome.matches("[A-Z][a-z]+")){
                this.nome = nome;
                break;
            } else {
                System.out.println("Por favor, digite um nome valido");
            }
        }
    }

    public List<String> getHabitos() {
        return habitos;
    }

    public void setHabitos(Scanner entrada) {
        boolean continua = true;
        while(continua){
            System.out.println("Nos informe, os habitos que o usuario faz que ajuda na hidratação");
            String habito = entrada.nextLine();
            this.habitos.add(habito);
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
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(Scanner scanner) {
        this.peso = ValidaPeso(scanner);
        setQuantidadeDeAgua(peso);
    }

    public double getQuantidadeDeAgua() {
        return quantidadeDeAgua;
    }

    public void setQuantidadeDeAgua(double peso) {
        this.quantidadeDeAgua = (peso * 35) / 1000;
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

    public void ExibeInformacoes(){
        System.out.println("Nome do usuario : " + this.nome);
        System.out.println("O usuario deve beber diariamente " + this.quantidadeDeAgua+ " litros de agua");
        System.out.println("Seria o equivalente há " + QuantidadeDeCopos()+  " copos de 250ml");
    }

    /*
    metodo abaixo calcula a quantidade de copos de agua de 250ml a pessoa tem que tomar
    de acordo com a quantidade de agua ela precisa tomar
     */
    private double QuantidadeDeCopos() {
        return (quantidadeDeAgua * 1000) / 250;
    }

    @Override
    public String toString() {
        return "Usuario: " + "\n" +
               "Nome: " + this.nome +"\n" +
               "Peso: " + this.peso + " kg\n" +
               "Quantidade de agua que deve tomar (em litros): " + this.quantidadeDeAgua + " Litros\n"+
               "Habitos do usuario: " + this.habitos + "\n";
    }
}
