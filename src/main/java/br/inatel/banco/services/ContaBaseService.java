package br.inatel.banco.services;

import br.inatel.banco.interfaces.IContaService;
import br.inatel.banco.model.Pagamentos;

import java.util.ArrayList;

public class ContaBaseService implements IContaService {
    private String agencia;
    private String numeroConta;
    private double saldo=0;

    ArrayList<Pagamentos> extrato= new ArrayList<Pagamentos>();


    public ContaBaseService(String agencia, String numeroConta) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
    }

    @Override
    public boolean pagarConta(double valor, String nome) {
        if(this.saldo < valor)
            return false;

        this.saldo -= valor;

        Pagamentos  pagamento = new Pagamentos(-valor, nome, "Pagamento");
        extrato.add(pagamento);
        return true;
    }

    @Override
    public boolean depositoConta(double valor, String nome) {
        if (valor <=0)
            return false;

        this.saldo += valor;
        // só coloca "Depósito" que operacao aparece
        extrato.add(new Pagamentos(valor, nome, "Depósito"));
        return true;
    }

    @Override
    public double consultaSaldo() {
        return this.saldo;
    }

    @Override
    public void consultaEstrato() {
        for (Pagamentos pagamento: this.extrato) {
            System.out.println("Nome:" + pagamento.getNome());
            System.out.println("Valor:" + pagamento.getValor());
            System.out.println("Operação:" + pagamento.getOperacao());
            System.out.println("-----------------------------");
        }
        System.out.println("Saldo total:" + this.saldo);

    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
