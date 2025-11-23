public class ContaCorrente implements OpcDepositar, OpcSacar{
 private int id;
 private String nome;
 private double saldo;
 private double limiteChequeEspecial;
public ContaCorrente(int id, String nome, double saldoInicial, double limiteChequeEspecial){
    this.id = id;
    this.nome = nome;
    this.saldo = saldoInicial;
    this.limiteChequeEspecial = limiteChequeEspecial;
 }
    public int getId() { 
        return id; }
    public String getNome() {
        return nome; }
    public String getTipo() { 
        return "ContaCorrente"; }
    public double getSaldo() { 
        return saldo; }
        
    public void depositar(double valor) {
    if (valor > 0) {
    saldo += valor;
    }
 }
 public void sacar(double valor) throws SaldoInsuficienteException {
    if (valor <= 0) return;
        double limiteTotal = saldo + limiteChequeEspecial;
    if (valor > limiteTotal) {
        throw new SaldoInsuficienteException("Saldo insuficiente na conta corrente");
 }      saldo -= valor;
    }
    public String resumo() {
        return "ContaCorrente{id=" + id + ", nome=" + nome + ", saldo=" + saldo + "}";
    }
}
