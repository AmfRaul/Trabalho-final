 public class LancamentoFinanceiro {
    private String tipo; 
    private String categoria;
    private String subcategoria;
    private int data; 
    private double valor;
    private Usuario pagador;
    private Usuario beneficiario;
    private boolean recorrente;
    private double saldoAntes;
    private double saldoDepois;

    public LancamentoFinanceiro(String tipo, String categoria, String subcategoria,int data, double valor, Usuario pagador, Usuario beneficiario, boolean recorrente,double saldoAntes){
        this.tipo = tipo;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.data = data;
        this.valor = valor;
        this.pagador = pagador;
        this.beneficiario = beneficiario;
        this.recorrente = recorrente;
        this.saldoAntes = saldoAntes;
        this.saldoDepois = calcularSaldoDepois();
    }
    private double calcularSaldoDepois() {
        if(tipo.equals("Despesa")) 
            return saldoAntes - valor;
        if(tipo.equals("Receita")) 
            return saldoAntes + valor;
        return saldoAntes;
    }
    public double getSaldoDepois() {
        return saldoDepois; }
        
    public String toString() {
        return "[" + tipo + "] " + categoria + "/" + subcategoria +
               ": R$" + valor +
               " (Pagador: " + (pagador != null ? pagador.getNome() : "-") +
               " | Ben: " + (beneficiario != null ? beneficiario.getNome() : "-") +
               " | Recorrente: " + recorrente + ")";
        }
}