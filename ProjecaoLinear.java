public class ProjecaoLinear implements AlgoritmoProjecaoSaldo {

    public double projetarSaldo(double saldoAtual, LancamentoFinanceiro[] lancamentos, int diasFuturos) {

        if (lancamentos == null || lancamentos.length == 0) {
            return saldoAtual;
        }

        double somaReceitas = 0;
        double somaDespesas = 0;
        int totalDias = 30;

        for (int i = 0; i < lancamentos.length; i++) {
            if (lancamentos[i] != null) {
                if (lancamentos[i].getTipo().equals("Receita")) {
                    somaReceitas += lancamentos[i].getValor();
                } else if (lancamentos[i].getTipo().equals("Despesa")) {
                    somaDespesas += lancamentos[i].getValor();
                }
            }
        }

        double saldoMedioDiario = (somaReceitas - somaDespesas) / totalDias;

        return saldoAtual + (saldoMedioDiario * diasFuturos);
    }
}
