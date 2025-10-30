public class Main{
    
        public static void main(String[] args) {
        Usuarioindividual u1 = new Usuarioindividual(1, "João", 25, "joao@email.com", "Individual");
        Usuarioindividual u2 = new Usuarioindividual(2, "Maria", 30, "maria@email.com", "Individual");

        Usuarioindividual[] iniciais = { u1 };
        Grupo grupo = new Grupo("Família Silva", iniciais);

        grupo.adicionarMembro(u2);
        System.out.println(grupo);

        for (Usuarioindividual u : grupo.getMembros()) {
            System.out.println(" - " + u.getNome());
        }

        grupo.removerMembro(u1);
        System.out.println("Após remover João:");
        System.out.println(grupo);
    }
}