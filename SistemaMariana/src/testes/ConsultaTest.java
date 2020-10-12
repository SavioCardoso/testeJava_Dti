package testes;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import sistemamariana.Cliente;
import sistemamariana.Consulta;

public class ConsultaTest {
	
	private static final String HORARIO = "Horario";
	private static final Double PESO = 0.0;
	private static final Double PERC_GORDURA = 0.0;
	private static final String SENSACAO = "Sensacao";
	private static final Double QTD_CALORIAS = 0.0;

	@Test
	public void criarConsultaComCamposValidosDeveCriarConsulta() {
		Consulta consulta = new Consulta();
		checkNull(consulta);
		setCliente(consulta);
		checkFields(consulta);
	}
	
	private void checkNull(Consulta consulta){
		Assert.assertNull(consulta.getData());
		Assert.assertNull(consulta.getHorario());
		Assert.assertNull(consulta.getPeso());
		Assert.assertNull(consulta.getPercGordura());
		Assert.assertNull(consulta.getSensacao());
		Assert.assertNull(consulta.getPaciente());
		Assert.assertNull(consulta.getQtdCalorias());
	}
	
	private void setCliente(Consulta consulta) {
		consulta.setHorario(HORARIO);
		consulta.setPeso(PESO);
		consulta.setPercGordura(PERC_GORDURA);
		consulta.setSensacao(SENSACAO);
		consulta.setQtdCalorias(QTD_CALORIAS);
		consulta.setData(new Date());
		consulta.setPaciente(new Cliente());
	}
	
	private void checkFields(Consulta consulta) {
		Assert.assertEquals(consulta.getHorario(),HORARIO);
		Assert.assertEquals(consulta.getPeso(), PESO);
		Assert.assertEquals(consulta.getPercGordura(), PERC_GORDURA);
		Assert.assertEquals(consulta.getSensacao(), SENSACAO);
		Assert.assertEquals(consulta.getQtdCalorias(), QTD_CALORIAS);
		Assert.assertNotNull(consulta.getData());
		Assert.assertNotNull(consulta.getPaciente());
	}
}
