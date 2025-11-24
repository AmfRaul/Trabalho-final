public class CarteiraInvestimento implements ContaFinanceira {
    private int id;
    private String nome;
    private double saldoAplicado;
    public CarteiraInvestimento(int id, String nome, double saldoInicial) {
    this.id = id;
    this.nome = nome;
    this.saldoAplicado = saldoInicial;
 }
 public int getId() { 
    return id; }
 public String getNome() { 
    return nome; }
 public String getTipo() { 
    return "CarteiraInvestimento"; }
 public double getSaldo() { 
    return saldoAplicado; }
 public void depositar(double valor) {
        if (valor > 0) {
            saldoAplicado += valor;
 }
 }
 public void sacar(double valor) throws SaldoInsuficienteException {
    if (valor <= 0) return;
 
    double saldoMinimo = saldoAplicado * 0.1;
    double maximoSaque = saldoAplicado - saldoMinimo;
    if (valor > maximoSaque) {
        throw new SaldoInsuficienteException("Saque acima do permitido na carteira");
 }
    saldoAplicado -= valor;
 }
    public String resumo() {
        return "CarteiraInvestimento{id=" + id + ", nome=" + nome + 
        ", saldo=" + saldoAplicado + "}";
    }
}