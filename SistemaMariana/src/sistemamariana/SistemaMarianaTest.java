package sistemamariana;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class SistemaMarianaTest {
	SistemaMariana objeto = new SistemaMariana();
    private static SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	void testeRetornaStringQuandoCaloriaMaiorQue650() throws ParseException {
		
		Cliente paciente = new Cliente("savio", "bh", "12345678", "savio@gmail.com", formatador.parse("13/09/2001"));
		Date dataConsulta = formatador.parse("11/10/2020");
		String horarioConsulta = "13:00";
		Double pesoPaciente = 70.0;
		Double gorduraCorporalPaciente = 2.0;
		String sensacaoPaciente = "bem";
		Double caloriasPaciente = 1.0;
		
		
		Consulta consulta = new Consulta(paciente, dataConsulta, horarioConsulta, pesoPaciente, gorduraCorporalPaciente, sensacaoPaciente, caloriasPaciente);
		
		//Teste 2
		consulta.setQtdCalorias(700.0);
		System.out.println(consulta.getDieta());
		objeto.calculoDieta(consulta);
		System.out.println(consulta.getDieta());
		assertEquals(consulta.getDieta(), "Batata frita, Arroz, Leite desnatado\nBatata frita, Arroz, Banana\nBatata frita, Arroz, Iogurte\nBatata frita, Feijao, Leite desnatado\n");
		
	}
	
	@Test
	void testeRetornaStringVaziaQuandoCaloriaMenorQue650() throws ParseException {
		
		Cliente paciente = new Cliente("savio", "bh", "12345678", "savio@gmail.com", formatador.parse("13/09/2001"));
		Date dataConsulta = formatador.parse("11/10/2020");
		String horarioConsulta = "13:00";
		Double pesoPaciente = 70.0;
		Double gorduraCorporalPaciente = 2.0;
		String sensacaoPaciente = "bem";
		Double caloriasPaciente = 1.0;
		
		
		Consulta consulta = new Consulta(paciente, dataConsulta, horarioConsulta, pesoPaciente, gorduraCorporalPaciente, sensacaoPaciente, caloriasPaciente);
		
		//Teste 1
		consulta.setQtdCalorias(30.0);
		objeto.calculoDieta(consulta);
		assertEquals(consulta.getDieta(), "");
	}

	@Test
	void testeRetornaFalsoEmailNaoValido() {	
		String email1 = "emailerrado";
		String email2 = "email@errado";
		
		assertFalse(objeto.validacaoEmail(email1));
		assertFalse(objeto.validacaoEmail(email2));
	}
	
	void testeRetornaVerdadeiroEmailValido() {	
		String email3 = "email@errado.com";
		
		assertTrue(objeto.validacaoEmail(email3));
	}

	@Test
	void testRetornaFalsoTelefoneNaoValido() {
		String telefone1 = "123";
		String telefone2 = "12abc3";
		
		assertFalse(objeto.validacaoTelefone(telefone1));
		assertFalse(objeto.validacaoTelefone(telefone2));

	}
	
	@Test
	void testRetornaVerdadeiroTelefoneValido() {
		String telefone3 = "12345678";
		
		assertTrue(objeto.validacaoTelefone(telefone3));
	}

}
