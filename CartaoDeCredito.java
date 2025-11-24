public class CartaoDeCredito implements ContaFinanceira, OpcDepositar, OpcSacar, OpcResumo {
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
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return "CartaoDeCredito";
    }
    public double getSaldo() {
        return limiteCredito - faturaAtual;
    }

    @Override
    public void depositar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new SaldoInsuficienteException("Valor inválido para pagamento.");
        }
        faturaAtual -= valor;
        if (faturaAtual < 0) {
            faturaAtual = 0;
        }
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new SaldoInsuficienteException("Valor inválido para compra.");
        }
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
