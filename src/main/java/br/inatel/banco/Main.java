package br.inatel.banco;

import br.inatel.banco.services.ContaCorrenteService;
import br.inatel.banco.services.ContaPoupancaService;

public class Main {
    public static void main(String[] args){
        System.out.println("-----------------------INATEL BANK---------------------");

        ContaCorrenteService ContaCorrente = new ContaCorrenteService("111", "1234567-8");
        ContaPoupancaService ContaPoupanca = new ContaPoupancaService("2222", "9876543-1");
        ContaCorrente.pagarConta(70.50, "CEMIG");
        ContaCorrente.depositoConta(300, "PIX");
        ContaCorrente.pagarCredito(100);
        ContaCorrente.consultaEstrato();

       // System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
      //  ContaPoupanca.depositoConta("5600", "pix");
       // ContaPoupanca.adicionaRendimento();
        //System.out.println("Rendimento:" + ContaPoupanca.consultaRendimento());
        //ContaPoupanca.adicionaRendimento();
    }
}
