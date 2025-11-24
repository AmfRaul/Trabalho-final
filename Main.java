import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GerenciadorFinanceiro gerenciador = GerenciadorFinanceiro.getInstancia();

        System.out.println("=== Sistema de Gestão Financeira ===");

        // MENU INICIAL: criar conta ou sair
        System.out.println("1 - Criar conta");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
        int opcaoInicial = sc.nextInt();

        if (opcaoInicial != 1) {
            System.out.println("Encerrando o sistema.");
            sc.close();
            return;
        }

        sc.nextLine(); // consumir quebra de linha que sobrou

        // criação de uma conta
        System.out.println("Informe o nome da conta:");
        String nomeConta = sc.nextLine();

        System.out.println("Escolha o tipo da conta:");
        System.out.println("1 - Corrente");
        System.out.println("2 - Digital");
        System.out.println("3 - Cartao");
        System.out.println("4 - Investimento");
        System.out.println("5 - Cofrinho");
        int opcaoTipo = sc.nextInt();

        System.out.println("Informe o saldo inicial:");
        double saldoInicial = sc.nextDouble();

        double limiteCheque = 0.0;
        if (opcaoTipo == 1) {
            System.out.println("Informe o limite do cheque especial:");
            limiteCheque = sc.nextDouble();
        }

        ContaFinanceira conta = ContaFactory.criarConta(opcaoTipo, nomeConta, saldoInicial, limiteCheque);

        if (conta == null) {
            System.out.println("Tipo de conta inválido. Encerrando.");
            sc.close();
            return;
        }

        gerenciador.adicionarConta(conta);

        // NOVO: menu depois de criar a conta
        System.out.println("\nConta criada com sucesso!");
        System.out.println("1 - Acessar conta pelo nome");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
        int opcaoDepoisCriar = sc.nextInt();

        if (opcaoDepoisCriar == 0) {
            System.out.println("Encerrando o sistema.");
            sc.close();
            return;
        }

        sc.nextLine(); // consumir ENTER

        System.out.println("Informe o nome da conta para acessar:");
        String nomeBusca = sc.nextLine();

        // aqui poderia buscar no gerenciador, mas por enquanto só confere o nome da conta criada
        if (!nomeBusca.equals(conta.getNome())) {
            System.out.println("Conta não encontrada. Encerrando.");
            sc.close();
            return;
        }

        int opcao = -1;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Projeção de saldo (30 dias)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            if (opcao == 1) {

                System.out.println("Saldo atual: R$ " + conta.getSaldo());

            } else if (opcao == 2) {

                System.out.print("Valor do depósito: ");
                double v = sc.nextDouble();
                try {
                    OpcDepositar cDep = (OpcDepositar) conta;
                    cDep.depositar(v);
                    System.out.println("Depósito OK. Novo saldo: R$ " + conta.getSaldo());
                } catch (SaldoInsuficienteException e) {
                    System.out.println("Erro ao depositar: " + e.getMessage());
                } catch (ClassCastException e) {
                    System.out.println("Esta conta não permite depósito.");
                }

            } else if (opcao == 3) {

                System.out.print("Valor do saque: ");
                double v = sc.nextDouble();
                try {
                    OpcSacar cSac = (OpcSacar) conta;
                    cSac.sacar(v);
                    System.out.println("Saque OK. Novo saldo: R$ " + conta.getSaldo());
                } catch (SaldoInsuficienteException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (ClassCastException e) {
                    System.out.println("Esta conta não permite saque.");
                } catch (Exception e) {
                    System.out.println("Erro inesperado ao sacar.");
                }

            } else if (opcao == 4) {

                double proj = gerenciador.projetarSaldo(conta.getSaldo(), 30);
                System.out.println("Projeção de saldo para 30 dias: R$ " + proj);

            } else if (opcao == 0) {

                System.out.println("Saindo...");

            } else {

                System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
