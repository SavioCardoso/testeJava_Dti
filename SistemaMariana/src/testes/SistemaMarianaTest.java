package testes;

import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import sistemamariana.Cliente;
import sistemamariana.Consulta;
import sistemamariana.SistemaMariana;

class SistemaMarianaTest {
	SistemaMariana mainClass = new SistemaMariana();
    private static SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    private static List<String> listaTeste = new ArrayList<>();
    
    //Testando método calculoDieta
	@Test
	public void testeRetornaStringQuandoCaloriaMaiorQue650() throws ParseException {	
		listaTeste.clear();
		listaTeste.add("Batata frita, Arroz, Leite desnatado\n");
		listaTeste.add("Batata frita, Arroz, Banana\n");
		listaTeste.add("Batata frita, Arroz, Iogurte\n");
		listaTeste.add("Batata frita, Feijao, Leite desnatado\n");
		
		Cliente paciente = new Cliente("savio", "bh", "12345678", "savio@gmail.com", formatador.parse("13/09/2001"));
		Date dataConsulta = formatador.parse("11/10/2020");
		String horarioConsulta = "13:00";
		Double pesoPaciente = 70.0;
		Double gorduraCorporalPaciente = 2.0;
		String sensacaoPaciente = "bem";
		Double caloriasPaciente = 1.0;
		
		Consulta consulta = new Consulta(paciente, dataConsulta, horarioConsulta, pesoPaciente, gorduraCorporalPaciente, sensacaoPaciente, caloriasPaciente);
		consulta.setQtdCalorias(700.0);
		
		assertEquals(mainClass.calculoDieta(consulta), listaTeste);
	}
	
	@Test
	public void testeRetornaStringVaziaQuandoCaloriaMenorQue650() throws ParseException {
		
		listaTeste.clear();

		Cliente paciente = new Cliente("savio", "bh", "12345678", "savio@gmail.com", formatador.parse("13/09/2001"));
		Date dataConsulta = formatador.parse("11/10/2020");
		String horarioConsulta = "13:00";
		Double pesoPaciente = 70.0;
		Double gorduraCorporalPaciente = 2.0;
		String sensacaoPaciente = "bem";
		Double caloriasPaciente = 1.0;
		
		Consulta consulta = new Consulta(paciente, dataConsulta, horarioConsulta, pesoPaciente, gorduraCorporalPaciente, sensacaoPaciente, caloriasPaciente);
		consulta.setQtdCalorias(500.0);
		
		assertEquals(mainClass.calculoDieta(consulta), listaTeste);
	}

	//Testando método validacaoEmail
	@Test
	public void testeRetornaFalsoEmailNaoValido() {	
		String email1 = "emailerrado";
		String email2 = "email@errado";
		
		assertFalse(mainClass.validacaoEmail(email1));
		assertFalse(mainClass.validacaoEmail(email2));
	}
	
	@Test
	public void testeRetornaVerdadeiroEmailValido() {	
		String email3 = "email@errado.com";
		
		assertTrue(mainClass.validacaoEmail(email3));
	}
	
	//Testando método validacaoTelefone
	@Test
	public void testRetornaFalsoTelefoneNaoValido() {
		String telefone1 = "123";
		String telefone2 = "12abc3";
		
		assertFalse(mainClass.validacaoTelefone(telefone1));
		assertFalse(mainClass.validacaoTelefone(telefone2));
	}
	
	@Test
	public void testRetornaVerdadeiroTelefoneValido() {
		String telefone3 = "12345678";

		assertTrue(mainClass.validacaoTelefone(telefone3));
	}

}
