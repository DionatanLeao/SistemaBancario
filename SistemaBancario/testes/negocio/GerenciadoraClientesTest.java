package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest {

	@Test
	public void testPesquisaCliente() {
		
		//Montando cenário
		Cliente c1 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente c2 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		List<Cliente> list = new ArrayList<>();
		list.addAll(Arrays.asList(c1, c2));
		
		GerenciadoraClientes gc = new GerenciadoraClientes(list);
		
		//Execução
		Cliente c3 = gc.pesquisaCliente(1);
		
		//Verificações
		assertThat(c3.getId(), is(1));
		assertThat(c3.getEmail(), is("gugafarias@gmail.com"));
			
	}
	
	@Test
	public void testRemoveCliente() {
		
		//Montagem cenário
		Cliente c1 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente c2 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		List<Cliente> list = new ArrayList<>();
		list.addAll(Arrays.asList(c1, c2));
		
		GerenciadoraClientes gc = new GerenciadoraClientes(list);
		
		//Execução
		boolean clienteRemovido = gc.removeCliente(2);
		
		//Verificações
		assertThat(clienteRemovido, is(true));
		assertThat(gc.getClientesDoBanco().size(), is(1));
		assertNull(gc.pesquisaCliente(2));
	}

}
