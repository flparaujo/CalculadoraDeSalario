package es2.exercicio2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FuncionarioTest {

    private Funcionario funcionario;

    @Before
    public void setUp() {
	funcionario = new Funcionario("Juliao Petruchio", "jpetruchio@gmail.com", 3000.00);
    }

    @Test
    public void testFuncionario() {
	Assert.assertEquals("Juliao Petruchio", funcionario.getNome());
	Assert.assertEquals("jpetruchio@gmail.com", funcionario.getEmail());
	Assert.assertEquals(3000.00, funcionario.getSalarioBase(), 0.0);
    }

    @Test
    public void testFuncionarioNomeInvalido() {

	try {
	    new Funcionario(null, "jpetruchio@gmail.com", 1888.00);
	    Assert.fail("Nao deveria passar.");
	} catch (IllegalArgumentException e) {
	    Assert.assertEquals("Nome de usuario nao pode ser vazio ou null.", e.getMessage());
	}

	try {
	    new Funcionario(" ", "jpetruchio@gmail.com", 1888.00);
	    Assert.fail("Nao deveria passar.");
	} catch (IllegalArgumentException e) {
	    Assert.assertEquals("Nome de usuario nao pode ser vazio ou null.", e.getMessage());
	}
    }

    @Test
    public void testFuncionarioEmailInvalido() {

	try {
	    new Funcionario("Juliao Petruchio", "@gmail.com", 2000.00);
	    Assert.fail("Nao deveria passar.");
	} catch (IllegalArgumentException e) {
	    Assert.assertEquals("Email invalido.", e.getMessage());
	}

	try {
	    new Funcionario("Juliao Petruchio", "jpetruchio@", 2000.00);
	    Assert.fail("Nao deveria passar.");
	} catch (IllegalArgumentException e) {
	    Assert.assertEquals("Email invalido.", e.getMessage());
	}

	try {
	    new Funcionario("Juliao Petruchio", " ", 2000.00);
	    Assert.fail("Nao deveria passar.");
	} catch (IllegalArgumentException e) {
	    Assert.assertEquals("Email nao pode ser null ou vazio.", e.getMessage());
	}

	try {
	    new Funcionario("Juliao Petruchio", null, 2000.00);
	    Assert.fail("Nao deveria passar.");
	} catch (IllegalArgumentException e) {
	    Assert.assertEquals("Email nao pode ser null ou vazio.", e.getMessage());
	}
    }

    @Test
    public void testFuncionarioSalarioBaseInvalido() {

	try {
	    funcionario.setSalario(0);
	    Assert.fail("Nao deveria passar.");
	} catch (IllegalArgumentException e) {
	    Assert.assertEquals("Salario base nao pode ser negativo ou zero.", e.getMessage());
	}

	try {
	    funcionario.setSalario(-900);
	    Assert.fail("Nao deveria passar.");
	} catch (IllegalArgumentException e) {
	    Assert.assertEquals("Salario base nao pode ser negativo ou zero.", e.getMessage());
	}

	try {
	    new Funcionario("Juliao Petruchio", "jpetruchio@gmail.com", 0.00);
	    Assert.fail("Nao deveria passar.");
	} catch (IllegalArgumentException e) {
	    Assert.assertEquals("Salario base nao pode ser negativo ou zero.", e.getMessage());
	}

	try {
	    new Funcionario("Juliao Petruchio", "jpetruchio@gmail.com", -100.00);
	    Assert.fail("Nao deveria passar.");
	} catch (IllegalArgumentException e) {
	    Assert.assertEquals("Salario base nao pode ser negativo ou zero.", e.getMessage());
	}
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
