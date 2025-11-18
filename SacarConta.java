
public class SacarConta implements ContaFinanceira {
    protected double saldo;
    protected double valor;

    public SacarConta(double saldo, double valor) {
        this.saldo = saldo;
        this.valor = valor;
    }

    @Override
    public void executar() {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
            System.out.println("Saldo atual: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }
}
