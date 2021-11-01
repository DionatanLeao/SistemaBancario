package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClientesTest {
	
	private GerenciadoraClientes gc;
	private int idCliente1 = 1;
	private int idCliente2 = 2;
	
	@Before
	public void setUp() {
		//Montando cenário
		Cliente c1 = new Cliente(idCliente1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente c2 = new Cliente(idCliente2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		List<Cliente> list = new ArrayList<>();
		list.addAll(Arrays.asList(c1, c2));
		
		gc = new GerenciadoraClientes(list);		
	}
	
	@After
	public void tearDown() {
		gc.limpa();
	}


	@Test
	public void testPesquisaCliente() {		
		
		//Execução
		Cliente c3 = gc.pesquisaCliente(idCliente1);
		
		//Verificações
		assertThat(c3.getId(), is(idCliente1));
		assertThat(c3.getEmail(), is("gugafarias@gmail.com"));
			
	}
	
	@Test
	public void testPesquisaClienteInexistente() {
		
		//Execução
		Cliente c3 = gc.pesquisaCliente(3);
		
		//Verificações
		assertNull(c3);
		//assertThat(c3, is(false));
		assertThat(gc.getClientesDoBanco().size(), is(2));
		
	}
	
	@Test
	public void testRemoveCliente() {

		//Execução
		boolean clienteRemovido = gc.removeCliente(idCliente2);
		
		//Verificações
		assertThat(clienteRemovido, is(true));
		assertThat(gc.getClientesDoBanco().size(), is(idCliente1));
		assertNull(gc.pesquisaCliente(idCliente2));
	}
	
	@Test
	public void	testClienteIdadeAceitavel() throws IdadeNaoPermitidaException {
		
		//Montagem do cenário
		Cliente cliente = new Cliente(1, "Gustavo", 25, "guga@gmail.com", 1, true);
		
		//Execução
		boolean idadeInvalida = gc.validaIdade(cliente.getIdade());
		
		//Verificações
		assertTrue(idadeInvalida);
		
	}
	@Test
	public void	testClienteIdadeAceitavel2() throws IdadeNaoPermitidaException {
		
		//Montagem do cenário
		Cliente cliente = new Cliente(1, "Gustavo", 17, "guga@gmail.com", 1, true);
		
		try {
			//Execução
			gc.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			//Verificações
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
		
		
		
		
	}

}
