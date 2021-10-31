package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest {

	@Test
	public void testTransfereValor() {

		// Montagem cenário
		int idConta1 = 1;
		int idConta2 = 2;
		ContaCorrente c1 = new ContaCorrente(idConta1, 200, true);
		ContaCorrente c2 = new ContaCorrente(idConta2, 0, true);

		List<ContaCorrente> list = new ArrayList<>();
		list.addAll(Arrays.asList(c1, c2));

		GerenciadoraContas gc = new GerenciadoraContas(list);

		// Execução
		gc.transfereValor(1, 100, 2);

		// Validações
		assertThat(c1.getSaldo(), is(100.0));
		assertThat(c2.getSaldo(), is(100.0));

	}

	@Test
	public void testTransfereValor_SaldoInsuficiente() {

		// Montagem cenário
		int idConta1 = 1;
		int idConta2 = 2;
		ContaCorrente c1 = new ContaCorrente(idConta1, 100, true);
		ContaCorrente c2 = new ContaCorrente(idConta2, 0, true);

		List<ContaCorrente> list = new ArrayList<>();
		list.addAll(Arrays.asList(c1, c2));

		GerenciadoraContas gc = new GerenciadoraContas(list);

		// Execução
		boolean sucesso = gc.transfereValor(idConta1, 200, idConta2);
		
		//Validações
		//assertFalse(sucesso);
		assertTrue(sucesso);
		assertThat(c1.getSaldo(), is(-100.0));
		assertThat(c2.getSaldo(), is(200.0));

	}

}
