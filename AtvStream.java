import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Conta {
    private String nomeCliente;
    private int numeroConta;
    private String banco;
    private String cpf;
    private String agencia;
    private double saldo;

    public Conta(String nomeCliente, int numeroConta, String banco, String cpf, String agencia, double saldo) {
        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.banco = banco;
        this.cpf = cpf;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getBanco() {
        return banco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", numeroConta=" + numeroConta +
                ", banco='" + banco + '\'' +
                ", cpf='" + cpf + '\'' +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}

public class AtvStream {
    private static List<Conta> contas = new ArrayList<>();

    public static void main(String[] args) {
        // Adicionando 5 contas de exemplo
        adicionarContas();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("Dados inseridos previamente em 'adicionarContas'");

        do {
            System.out.println("GERENCIA DO BANCO NACIONAL DO BRASIL");
            System.out.println("[1] Listar todas as contas");
            System.out.println("[2] Contas com saldo negativo");
            System.out.println("[3] Contas cadastradas em um determinado banco");
            System.out.println("[4] Contas com 50Mil+ de saldo");
            System.out.println("[5] Contas com agencia em BH");
            System.out.println("[0] SAIR");
            System.out.print("INSIRA UM VALOR: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    listarContas();
                    break;
                case 2:
                    listarSaldoNegativo();
                    break;
                case 3:
                    System.out.print("BANCO QUE DESEJA PESQUISAR: ");
                    String banco = scanner.nextLine();
                    listarContasPorBanco(banco);
                    break;
                case 4:
                    listar50Mil();
                    break;
                case 5:
                    listarBH();
                    break;
                case 0:
                    System.out.println(":-)");
                    break;
                default:
                    System.out.println("OPCAO INVALIDA, TENTE NOVAMENTE");
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void adicionarContas() {
        contas.add(new Conta("Felipe Mendes", 1001, "Banco do Brasil", "817.264.568-60", "SP", 1500.00));
        contas.add(new Conta("Leandro Maia", 1002, "Banco do Brasil", "764.306.535-70", "RJ", -250.50));
        contas.add(new Conta("Arthur Magno", 1003, "CAIXA", "705.907.423-60", "SP", 3000.75));
        contas.add(new Conta("Matheus Silva", 1004, "Bradesco", "553.596.737-80", "BH", 40000.00));
        contas.add(new Conta("Sergio Amaral", 1005, "Bradesco", "330.269.481-40", "BH", 60000.25));
    }

    private static void listarContas() {
        System.out.println("\nContas cadastradas:");
        contas.forEach(conta -> {
            System.out.println("CONTA " + conta.getNumeroConta());
            System.out.println("Banco: " + conta.getBanco());
            System.out.println("Agencia: " + conta.getAgencia());
            System.out.println("Cliente: " + conta.getNomeCliente());
            System.out.println("CPF: " + conta.getCpf());
            System.out.println("Número da Conta: " + conta.getNumeroConta());
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println(); 
        });

    }

    private static void listarSaldoNegativo() {
        System.out.println("\nContas com saldo negativo:");
        contas.stream()
                .filter(conta -> conta.getSaldo() < 0)
                .forEach(conta -> {
                    System.out.println("Cliente: " + conta.getNomeCliente() + ", Saldo: " + conta.getSaldo());
                });
    }

    private static void listarContasPorBanco(String banco) {
        System.out.println("\nContas do banco " + banco + ":");
        contas.stream()
                .filter(conta -> conta.getBanco().equalsIgnoreCase(banco))
                .forEach(conta -> {
                    System.out.println("Cliente: " + conta.getNomeCliente() + ", Saldo: " + conta.getSaldo());
                });
    }

    private static void listar50Mil() {
        System.out.println("\nContas com saldo maior do que 50 mil:");
        contas.stream()
                .filter(conta -> conta.getSaldo() > 50000)
                .forEach(conta -> {
                    System.out.println("Cliente: " + conta.getNomeCliente() + ", Saldo: " + conta.getSaldo());
                });
    }

    private static void listarBH() {
        System.out.println("\nContas com agência em 'BH':");
        contas.stream()
                .filter(conta -> conta.getAgencia().equalsIgnoreCase("BH"))
                .forEach(conta -> {
                    System.out.println("Cliente: " + conta.getNomeCliente() + ", Saldo: " + conta.getSaldo());
                });
    }
}
