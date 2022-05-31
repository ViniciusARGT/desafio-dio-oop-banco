package Banco;
import java.util.Random;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected double saldoInvestimento;
    protected double dividaEmprestimo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
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
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void investir(double valor) {
        saldoInvestimento += valor;
        saldo -= valor;
        System.out.println("Valor Investindo: " + valor);
    }

    @Override
    public void emprestimo(double valor) {
        Random random = new Random();
        boolean aprovado = random.nextBoolean();
        System.out.println("Resultado do pedido de emprestimo: " + aprovado);
        if (aprovado) {
            saldo += valor;
            dividaEmprestimo += valor;
        }

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

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println(String.format("Saldo Investimento: %.2f", this.saldoInvestimento));
    }

    public void ImprimirStatusEmprestimo() {
        System.out.println("=== Extrato Emprestimo ===");
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Valor do emprestimo: %.2f", this.dividaEmprestimo));
    }

    public void ImprimirStatusInvestimento() {
        System.out.println("=== Extrato Investimento ===");
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Valor do investido: %.2f", this.saldoInvestimento));
    }
}
