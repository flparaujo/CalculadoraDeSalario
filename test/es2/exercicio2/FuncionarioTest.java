package es2.exercicio2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FuncionarioTest {
	
	private Funcionario funcionario;
	
	@Before
	public void setUp() {
		funcionario = new Funcionario(3000.00);	
	}
	
	@Test
	public void testSalarioDesenvolvedor3MilOuMais() {
		Assert.assertEquals(2400.00, funcionario.calculaSalario(), 0.0);
	}
	
	@Test
	public void testSalarioDesenvolvedorMenorQue3Mil() {
		funcionario.setSalario(2800.00);
		Assert.assertEquals(2520.00, funcionario.calculaSalario(), 0.0);
	}
	
	@Test
	public void testSalarioDBA2MilOuMais() {
		funcionario.setCargo(new DBA());
		funcionario.setSalario(2000.00);
		Assert.assertEquals(1500.00, funcionario.calculaSalario(), 0.0);
	}
	
	@Test
	public void testSalarioDBAMenorQue2Mil() {
		funcionario.setCargo(new DBA());
		funcionario.setSalario(1999.00);
		Assert.assertEquals(1699.15, funcionario.calculaSalario(), 0.001);
	}
	
	@Test
	public void testSalarioTestador2MilOuMais() {
		funcionario.setCargo(new Testador());
		Assert.assertEquals(2250, funcionario.calculaSalario(), 0.0);
	}
	
	@Test
	public void testSalarioTestadorMenorQue2Mil() {
		funcionario.setCargo(new Testador());
		funcionario.setSalario(1900.00);
		Assert.assertEquals(1615.00, funcionario.calculaSalario(), 0.0);
	}
	
	@Test
	public void testSalarioGerente5MilOuMais() {
		funcionario.setCargo(new Gerente());
		funcionario.setSalario(5000.00);
		Assert.assertEquals(3500.00, funcionario.calculaSalario(), 0.0);
	}
	
	@Test
	public void testSalarioGerenteMenorQue5Mil() {
		funcionario.setCargo(new Gerente());
		Assert.assertEquals(2400.00, funcionario.calculaSalario(), 0.0);
	}

}
