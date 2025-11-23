public class DepositarConta implements OpcResumo {
    protected double saldo;
    protected double valor;

    public DepositarConta(double saldo, double valor) {
        this.saldo = saldo;
        this.valor = valor;
    }

    @Override
    public String resumo() {
        if (valor > 0) {
             double novoSaldo = saldo + valor;
            return "Depósito de R$" + valor + ". Saldo após operação: R$" + novoSaldo;
        } 
        else {
            return "Valor inválido para depósito.";
        }
    }
}
