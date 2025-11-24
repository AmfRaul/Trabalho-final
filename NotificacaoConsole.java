public class NotificacaoConsole implements Notificavel {
    public void enviarNotificacao(String mensagem) {
        System.out.println("[NOTIFICAÇÃO] " + mensagem);
    }
}
