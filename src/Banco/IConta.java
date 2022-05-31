package Banco;

public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, IConta contaDestino);

    void investir(double valor);

    void emprestimo(double valor);

    void imprimirExtrato();

    void ImprimirStatusInvestimento();

    void ImprimirStatusEmprestimo();




}
