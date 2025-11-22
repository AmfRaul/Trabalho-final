public interface ContaFinanceira{
int getId();
 String getNome();
 String getTipo();
 double getSaldo();
 void depositar(double valor) throws SaldoInsuficienteException;
 void sacar(double valor) throws SaldoInsuficienteException;
 String resumo();
 }