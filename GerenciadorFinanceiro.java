public class GerenciadorFinanceiro {

    private static GerenciadorFinanceiro instancia;

    private ContaFinanceira[] contas;
    private int totalContas;

    private LancamentoFinanceiro[] lancamentos;
    private int totalLancamentos;

    private MetaFinanceira[] metas;
    private int totalMetas;

    private AlgoritmoProjecaoSaldo algoritmoProjecao;

    private GerenciadorFinanceiro() {
        contas = new ContaFinanceira[100];
        lancamentos = new LancamentoFinanceiro[1000];
        metas = new MetaFinanceira[50];

        totalContas = 0;
        totalLancamentos = 0;
        totalMetas = 0;

        algoritmoProjecao = new ProjecaoLinear();
    }

    public static GerenciadorFinanceiro getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorFinanceiro();
        }
        return instancia;
    }

    public void setAlgoritmoProjecao(AlgoritmoProjecaoSaldo algoritmo) {
        algoritmoProjecao = algoritmo;
    }

    public void adicionarConta(ContaFinanceira conta) {
        if (conta == null) return;
        if (totalContas >= contas.length) return;

        contas[totalContas] = conta;
        totalContas++;
    }

    public void adicionarLancamento(LancamentoFinanceiro lanc) {
        if (lanc == null) return;
        if (totalLancamentos >= lancamentos.length) return;

        lancamentos[totalLancamentos] = lanc;
        totalLancamentos++;
    }

    public void adicionarMeta(MetaFinanceira meta) {
        if (meta == null) return;
        if (totalMetas >= metas.length) return;

        metas[totalMetas] = meta;
        totalMetas++;
    }

    public ContaFinanceira buscarConta(int id) {
        for (int i = 0; i < totalContas; i++) {
            if (contas[i] != null && contas[i].getId() == id) {
                return contas[i];
            }
        }
        return null;
    }

    public double projetarSaldo(double saldoAtual, int diasFuturos) {
        if (algoritmoProjecao == null) {
            return saldoAtual;
        }
        return algoritmoProjecao.projetarSaldo(saldoAtual, lancamentos, diasFuturos);
    }

    public ContaFinanceira[] getContas() {
        return contas;
    }

    public int getTotalContas() {
        return totalContas;
    }

    public LancamentoFinanceiro[] getLancamentos() {
        return lancamentos;
    }

    public int getTotalLancamentos() {
        return totalLancamentos;
    }

    public MetaFinanceira[] getMetas() {
        return metas;
    }

    public int getTotalMetas() {
        return totalMetas;
    }
}
