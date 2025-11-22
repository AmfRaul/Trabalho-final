public class ContaDigital implements ContaFinanceira {
 private int id;
 private String nome;
 private double saldo;
 public ContaDigital(int id, String nome, double saldoInicial) {
    this.id = id;
    this.nome = nome;
    this.saldo = saldoInicial;
 }
    public int getId() { 
        return id; }
    public String getNome() { 
        return nome; }
    public String getTipo() { 
        return "ContaDigital"; 
    }
    public double getSaldo() { 
        return saldo; 
    }
    public void depositar(double valor) {
        if (valor > 0) {
        saldo += valor;
    }
}
    public void sacar(double valor) throws SaldoInsuficienteException {
    if (valor <= 0) 
            return;
    if (valor > saldo) {
        throw new SaldoInsuficienteException("Saldo insuficiente na conta digital");
}
    saldo -= valor;
}
    public String resumo() {
        return ("ContaDigital{id=" + id + ", nome=" + nome + ", saldo=" + saldo + "}");
    }
}