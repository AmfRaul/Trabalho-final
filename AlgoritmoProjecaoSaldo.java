public interface AlgoritmoProjecaoSaldo {
    double projetarSaldo(double saldoAtual,
        LancamentoFinanceiro[] lancamentos,
        int diasFuturos);
}
