public class RelatorioExportavel implements Exportavel {
    private String conteudo;
        public RelatorioExportavel(String conteudo) {
            this.conteudo = conteudo;
        }
    public String exportar() {
        return "=== RELATÓRIO EXPORTADO ===\n" + conteudo;
    }
}