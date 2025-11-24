public class ContaFactory {

    private static int proximoId = 1;

    // tipo: 1=corrente, 2=digital, 3=cartao, 4=investimento, 5=cofrinho
    public static ContaFinanceira criarConta(int tipo, String nome, double saldo, double limite) {

        int id = proximoId++;

        if (tipo == 1) {               // conta corrente
            return new ContaCorrente(id, nome, saldo, limite);

        } else if (tipo == 2) {        // conta digital
            return new ContaDigital(id, nome, saldo);

        } else if (tipo == 3) {        // cartao de credito
            double limiteCreditoInicial = saldo;  // aqui é o valor que vai para o atributo limiteCredito
            return new CartaoDeCredito(id, nome, limiteCreditoInicial);

        } else if (tipo == 4) {        // carteira de investimento
            return new CarteiraInvestimento(id, nome, saldo);

        } else if (tipo == 5) {        // cofrinho
            return new CofrinhoVirtual(id, nome, saldo);
        }

        return null;
    }
}
