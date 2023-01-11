package br.inatel.banco.teste;

import br.inatel.banco.services.ContaCorrenteService;
import br.inatel.banco.services.ContaPoupancaService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ContaTest {
    ContaCorrenteService cc;
    ContaPoupancaService cp;

    @Before
    public void setup(){

        cc= new ContaCorrenteService("1234", "1234567-9");
        cp = new ContaPoupancaService("4321", "98765432-1");
    }

    @Test

    public void ContaCorrentePagarCredito_ok(){
        boolean verifica = cc.pagarCredito(10);
        assertEquals(true, verifica);
    }

    @Test
    public void ContaCorrentePagarCredito_erro(){
        boolean verifica = cc.pagarCredito(-10);
        assertEquals(false, verifica);
    }

    @Test
    public void contaPoupancaAdicionaRendimento_ok(){
        cp.depositoConta(5600, "teste");
        cp.adicionaRendimento();
        assertEquals(56.0, cp.consultaRendimento(), 0);
    }

}
