public class CofrinhoVirtual implements ContaFinanceira {
    private int id;
    private String nome;
    private double saldo;
    private boolean bloqueado;
    public CofrinhoVirtual(int id, String nome, double saldoInicial) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldoInicial;
        this.bloqueado = false;
    }
    public int getId() { 
        return id; }
    public String getNome() { 
        return nome; }
    public String getTipo() { 
        return "CofrinhoVirtual"; }
    public double getSaldo() { 
        return saldo; }
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
}
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) return;
        if (bloqueado) {
            throw new SaldoInsuficienteException("Cofrinho bloqueado para saque.");
}
    if (valor > saldo) {
    throw new SaldoInsuficienteException("Saldo insuficiente no cofrinho.");
    }
    saldo -= valor;
    }
    public String resumo() {
        return "CofrinhoVirtual{id=" + id + ", nome=" + nome +
        ", saldo=" + saldo + ", bloqueado=" + bloqueado + "}";
    }
}
