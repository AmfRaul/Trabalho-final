public class Grupo extends Usuario {
    private Usuarioindividual[] membros;
    private int qtdMembros;

    public Grupo(String nome, Usuarioindividual[] membrosIniciais) {
        super(Math.random() * 10000, nome, 0, "grupo@local", "Pj");
        this.membros = new Usuarioindividual[50];
        this.qtdMembros = 0;

        if (membrosIniciais != null) {
            for (Usuarioindividual u : membrosIniciais) {
                if (u != null && qtdMembros < membros.length) {
                    this.membros[qtdMembros++] = u;
                }
            }
        }
    }

    public void adicionarMembro(Usuarioindividual u) {
        if (u == null) {
            System.out.println("Erro: membro inválido!");
            return;
        }

        if (qtdMembros >= membros.length) {
            System.out.println("Erro: limite máximo de membros atingido!");
            return;
        }

       
        for (int i = 0; i < qtdMembros; i++) {
            if (membros[i] != null && membros[i].getId() == u.getId()) {
                System.out.println("Erro: membro já existe no grupo!");
                return;
            }
        }

        membros[qtdMembros++] = u;
    }

    public void removerMembro(Usuarioindividual u) {
        if (u == null) {
            System.out.println("Erro: membro inválido!");
            return;
        }

        int posicao = -1;
        for (int i = 0; i < qtdMembros; i++) {
            if (membros[i] != null && membros[i].getId() == u.getId()) {
                posicao = i;
                break;
            }
        }

        if (posicao != -1) {
            for (int j = posicao; j < qtdMembros - 1; j++) {
                membros[j] = membros[j + 1];
            }
            membros[--qtdMembros] = null;
            System.out.println("Membro removido com sucesso!");
        } else {
            System.out.println("Membro não encontrado!");
        }
    }

    public Usuarioindividual[] getMembros() {
        Usuarioindividual[] copia = new Usuarioindividual[qtdMembros];
        for (int i = 0; i < qtdMembros; i++) {
            copia[i] = membros[i];
        }
        return copia;
    }

    public int getQtdMembros() {
        return qtdMembros;
    }

    
    public String tipoUsuario() {
        return "Grupo";
    }

    @Override
    public String toString() {
        return "Grupo: " + getNome() + " | Membros: " + qtdMembros;
    }
}
