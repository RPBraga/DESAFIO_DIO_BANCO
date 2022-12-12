public abstract class ContaBancaria implements IConta{
    private static final int AGENCIAPADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public ContaBancaria (Cliente cliente) {
        this.agencia = ContaBancaria.AGENCIAPADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, ContaBancaria contaDestino) {
        this.sacar( valor );
        contaDestino.depositar( valor );
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns (){
        System.out.println(String.format( "titular: %s", this.cliente.getNome() ));
        System.out.println(String.format( "Agência: %d", this.agencia ));
        System.out.println(String.format( "Conta Número: %d", this.numero ));
        System.out.println(String.format( "Saldo: %.2f", this.saldo ));
    }
}
