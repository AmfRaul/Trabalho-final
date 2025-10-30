public abstract class ContaFinanceira {
    protected String numeroConta;
    protected double saldo;
    protected Usuario titular;

    public ContaFinanceira(String numeroConta, Usuario titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public double getSaldo() { return saldo; }
    public Usuario getTitular() { return titular; }

    public void depositar(double valor) {
        if (valor > 0) saldo += valor;
    }

    public abstract void sacar(double valor);
    public abstract String tipoConta();

    @Override
    public String toString() {
        return tipoConta() + " [" + numeroConta + "] - Saldo: R$" + saldo;
    }
}
