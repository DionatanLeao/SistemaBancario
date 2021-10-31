package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest {

	@Test
	public void test() {
		
		Cliente c1 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente c2 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		List<Cliente> list = new ArrayList<>();
		list.addAll(Arrays.asList(c1, c2));
		
		GerenciadoraClientes gc = new GerenciadoraClientes(list);
		
		Cliente c3 = gc.pesquisaCliente(1);
		assertThat(c3.getId(), is(1));
		assertThat(c3.getEmail(), is("gugafarias@gmail.com"));
			
	}

}
