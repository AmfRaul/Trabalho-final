class Grupo extends Usuario {
    private UsuarioIndividual[] membros;
    private int qtdMembros;

    public Grupo(String nome, UsuarioIndividual[] membrosIniciais) {
        super(nome, "grupo@local");
        this.membros = new UsuarioIndividual[50]; 
        this.qtdMembros = 0;
        for (UsuarioIndividual u : membrosIniciais) {
            if (u != null) {
                this.membros[qtdMembros++] = u;
            }
        }
    }

    public void adicionarMembro(UsuarioIndividual u) {
        if (qtdMembros < membros.length) {
            membros[qtdMembros++] = u;
        } else {
            System.out.println("Erro: limite máximo de membros atingido!");
        }
    }

    public void removerMembro(UsuarioIndividual u) {
        int index = -1;
        for (int i = 0; i < qtdMembros; i++) {
            if (membros[i].getId().equals(u.getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int j = index; j < qtdMembros - 1; j++) {
                membros[j] = membros[j + 1];
            }
            membros[--qtdMembros] = null;
        } else {
            System.out.println("Membro não encontrado!");
        }
    }

    public UsuarioIndividual[] getMembros() {
        UsuarioIndividual[] copia = new UsuarioIndividual[qtdMembros];
        for (int i = 0; i < qtdMembros; i++) {
            copia[i] = membros[i];
        }
        return copia;
    }

    public int getQtdMembros() {
        return qtdMembros;
    }
}
