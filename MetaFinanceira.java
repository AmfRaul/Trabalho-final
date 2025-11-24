public class MetaFinanceira {

    private String descricao;
    private String categoria;
    private double valorMeta;
    private double valorAtual;
    private int prazo; 
    private int dataInicio;

    public MetaFinanceira(String descricao, String categoria, double valorMeta, int prazo, int dataInicio) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.valorMeta = valorMeta;
        this.prazo = prazo;
        this.dataInicio = dataInicio;
        this.valorAtual = 0.0;
    }

    public void adicionarProgresso(double valor) {
        valorAtual += valor;
    }

    public double getPercentualConclusao() {
        if (valorMeta == 0) return 0;
        return (valorAtual / valorMeta) * 100;
    }

    public boolean isAtingida() {
        return valorAtual >= valorMeta;
    }

    public String getDescricao() { 
        return descricao; }

    public String getCategoria() { 
        return categoria; }

    public double getValorMeta() { 
        return valorMeta; }

    public double getValorAtual() { 
        return valorAtual; }

    public int getPrazo() { 
        return prazo; }

    public int getDataInicio() { 
        return dataInicio; }

    public String toString() {
        return "Meta: " + descricao +
               " | Categoria: " + categoria +
               " | Objetivo: R$ " + valorMeta +
               " | Atual: R$ " + valorAtual +
               " | Progresso: " + String.format("%.1f", getPercentualConclusao()) + "%";
    }
}
