public class ProjecaoConservadora implements AlgoritmoProjecaoSaldo {

    @Override
    public double projetarSaldo(double saldoAtual, LancamentoFinanceiro[] lancamentos, int diasFuturos) {

        if (lancamentos == null || lancamentos.length == 0) {
            return saldoAtual;
        }

        double somaDespesas = 0;
        int totalDias = 30;

        for (int i = 0; i < lancamentos.length; i++) {
            if (lancamentos[i] != null && 
                lancamentos[i].getTipo().equalsIgnoreCase("Despesa")) {

                somaDespesas += lancamentos[i].getValor();
            }
        }

        double despesaMediaDiaria = somaDespesas / totalDias;

        return saldoAtual - (despesaMediaDiaria * diasFuturos * 1.1);
    }
}
