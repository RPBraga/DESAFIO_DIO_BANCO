public class Main {
    public static void main(String[] args) {
        Cliente pessoa = new Cliente();
        pessoa.setNome( "Rodrigo" );
        ContaBancaria cc = new ContaCorrente(pessoa);
        cc.depositar( 1000 );

        ContaBancaria cp = new ContaPoupanca(pessoa);
        cc.transferir( 250,cp );

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}
