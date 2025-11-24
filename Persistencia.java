import java.io.FileWriter;

public class Persistencia {

    public static void salvarContas(ContaFinanceira[] contas, int total, String caminho) {
        FileWriter fw = null;

        try {
            fw = new FileWriter(caminho);

            for (int i = 0; i < total; i++) {
                if (contas[i] != null) {
                    String linha = contas[i].getId() + ";" +
                                   contas[i].getTipo() + ";" +
                                   contas[i].getNome() + ";" +
                                   contas[i].getSaldo() + "\n";
                    fw.write(linha);
                }
            }

            System.out.println("Contas salvas em: " + caminho);

        } catch (Exception e) {
            System.out.println("Erro ao salvar contas: " + e.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                // ignora erro ao fechar
            }
        }
    }

    public static void salvarLancamentos(LancamentoFinanceiro[] lancamentos, int total, String caminho) {
        FileWriter fw = null;

        try {
            fw = new FileWriter(caminho);

            for (int i = 0; i < total; i++) {
                if (lancamentos[i] != null) {
                    String linha = lancamentos[i].getTipo() + ";" +
                                   lancamentos[i].getCategoria() + ";" +
                                   lancamentos[i].getValor() + ";" +
                                   lancamentos[i].getData() + "\n";
                    fw.write(linha);
                }
            }

            System.out.println("Lançamentos salvos em: " + caminho);

        } catch (Exception e) {
            System.out.println("Erro ao salvar lançamentos: " + e.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                // ignora
            }
        }
    }

}
