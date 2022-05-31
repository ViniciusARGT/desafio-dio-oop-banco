package Banco;

public class Main {
    public static void main(String[] args) {
        Cliente vinicius = new Cliente();
        vinicius.setNome("Vinicius");

        IConta cc = new ContaCorrente(vinicius);
        cc.depositar(100);

        Conta poupanca = new ContaPoupanca(vinicius);
        cc.transferir(100, poupanca);
        poupanca.investir(100);
        poupanca.emprestimo(1000);
        cc.emprestimo(500);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        cc.ImprimirStatusInvestimento();
        poupanca.ImprimirStatusInvestimento();

        cc.ImprimirStatusEmprestimo();
        poupanca.ImprimirStatusEmprestimo();
    }
}
