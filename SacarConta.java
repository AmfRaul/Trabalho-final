public class SacarConta implements OpcResumo, OpcSacar {

    private double saldoAntes;
    private double saldoDepois;

    public SacarConta(double saldoInicial) {
        this.saldoAntes = saldoInicial;
        this.saldoDepois = saldoInicial;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0 || saldoDepois < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente ou valor inválido.");
        }

        saldoAntes = saldoDepois;
        saldoDepois -= valor;
    }

    @Override
    public String resumo() {
        return "Saque de R$" + (saldoAntes - saldoDepois) +
               " realizado com sucesso! Saldo antes: R$" + saldoAntes +
               ", saldo atual: R$" + saldoDepois;
    }

    public double getSaldoAtual() {
        return saldoDepois;
    }
}
