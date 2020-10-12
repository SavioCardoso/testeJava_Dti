package testes;

import java.util.Date;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sistemamariana.Cliente;

public class ClienteTest {
	
	private static final String TELEFONE = "telefone";
	private static final String EMAIL = "email";
	private static final String ENDEREÇO = "Endereço";
	private static final String NOME = "Nome";

	@Test
	public void criarClienteComCamposValidosDeveCriarCliente() {
		Cliente cliente = new Cliente();
		checkNull(cliente);
		setCliente(cliente);
		checkFields(cliente);
	}
	
	private void checkNull(Cliente cliente){
		Assert.assertNull(cliente.getEmail());
		Assert.assertNull(cliente.getEndereco());
		Assert.assertNull(cliente.getDataNascimento());
		Assert.assertNull(cliente.getNome());
		Assert.assertNull(cliente.getTelefone());
	}
	
	private void setCliente(Cliente cliente) {
		cliente.setNome(NOME);
		cliente.setEndereco(ENDEREÇO);
		cliente.setEmail(EMAIL);
		cliente.setTelefone(TELEFONE);
		cliente.setDataNascimento(new Date());
	}
	
	private void checkFields(Cliente cliente) {
		Assert.assertEquals(cliente.getEmail(),EMAIL);
		Assert.assertEquals(cliente.getEndereco(), ENDEREÇO);
		Assert.assertEquals(cliente.getNome(), NOME);
		Assert.assertEquals(cliente.getTelefone(), TELEFONE);
		Assert.assertNotNull(cliente.getDataNascimento());
		
	}
}
