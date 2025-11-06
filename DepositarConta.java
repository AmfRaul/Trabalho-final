public class DepositarConta implements ContaFinanceira {
    private double saldo;
    private double valor;

    public DepositarConta(double saldo, double valor) {
        this.saldo = saldo;
        this.valor = valor;
    }

    @Override
    public void executar() {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
            System.out.println("Saldo atual: R$" + saldo);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }
}
