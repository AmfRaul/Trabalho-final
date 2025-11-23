public interface OpcDepositar {
    void depositar(double valor) throws SaldoInsuficienteException;
}
