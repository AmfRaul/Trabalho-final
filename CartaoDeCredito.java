public class CartaoDeCredito {
 private int id;
 private String nome;
 private double limiteCredito;
 private double faturaAtual;
    public CartaoDeCredito(int id, String nome, double limiteCredito) {
    this.id = id;
    this.nome = nome;
    this.limiteCredito = limiteCredito;
    this.faturaAtual = 0.0;
    }
    public int getId() { 
        return id; }
    public String getNome() { 
        return nome; }
    public String getTipo() { 
        return "CartaoDeCredito"; }
    public double getSaldo() {
        return limiteCredito - faturaAtual;
    }
 public void depositar(double valor) {
    if (valor > 0) {
        faturaAtual -= valor;
    if (faturaAtual < 0) {
        faturaAtual = 0;
        }
    }
 }
 public void sacar(double valor) throws SaldoInsuficienteException {
 if (valor <= 0) return;
    double disponivel = limiteCredito - faturaAtual;
 if (valor > disponivel) {
    throw new SaldoInsuficienteException("Limite do cartão insuficiente.");
 }
 faturaAtual += valor;
 }
 public String resumo() {
    return "CartaoDeCredito{id=" + id + ", nome=" + nome + 
    ", fatura=" + faturaAtual + ", disponivel=" + getSaldo() + "}";
    }
}

