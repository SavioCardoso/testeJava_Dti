package testes;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sistemamariana.Alimentos;

public class AlimentosTest {
	private static final String NOME = "Nome";
	private static final Double CALORIAS = 0.0;

	@Test
	public void criarAlimentosComCamposValidosDeveCriarAlimentos() {
		Alimentos alimento = new Alimentos();
		checkNull(alimento);
		setCliente(alimento);
		checkFields(alimento);
	}
	
	private void checkNull(Alimentos alimento){
		Assert.assertNull(alimento.getNome());
		Assert.assertNull(alimento.getCalorias());
	}
	
	private void setCliente(Alimentos alimento) {
		alimento.setNome(NOME);
		alimento.setCalorias(CALORIAS);
	}
	
	private void checkFields(Alimentos alimento) {
		Assert.assertEquals(alimento.getNome(), NOME);
		Assert.assertEquals(alimento.getCalorias(), CALORIAS);
	}
}
