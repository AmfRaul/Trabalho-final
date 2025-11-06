//public abstract class ContaFinanceira {
    //protected String numeroConta;
    //protected double saldo;
    //protected Usuario titular;

    //public ContaFinanceira(String numeroConta, double saldo, Usuario titular) {
        //this.numeroConta = numeroConta;
        //this.titular = titular;
      //  this.saldo = 0.0;
    //}

    //public double getSaldo() { return saldo; }
    //public Usuario getTitular() { return titular; }
    //public abstract String tipoConta();

   // @Override
 //   public String toString() {
  //      return tipoConta() + " [" + numeroConta + "] - Saldo: R$" + saldo;
 //   }
//}
public interface ContaFinanceira{
    public void executar();
}