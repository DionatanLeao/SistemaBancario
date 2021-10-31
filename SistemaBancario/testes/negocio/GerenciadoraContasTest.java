package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest {

	@Test
	public void testTransfereValor() {
		
		//Motagem cenário
		ContaCorrente c1 = new ContaCorrente(1, 200, true);
		ContaCorrente c2 = new ContaCorrente(2, 0, true);
		
		List<ContaCorrente> list = new ArrayList<>();
		list.addAll(Arrays.asList(c1, c2));
		
		GerenciadoraContas gc = new GerenciadoraContas(list);
		
		//Execução
		gc.transfereValor(1, 100, 2);
		
		//Validações
		assertThat(c1.getSaldo(), is(100.0));
		assertThat(c2.getSaldo(), is(100.0));
		
	}

}
