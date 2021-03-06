package es2.exercicio2;

import java.math.BigDecimal;

public class Funcionario {

    private BigDecimal salarioBase;
    private Cargo cargo;
    private String nome;
    private String email;

    public Funcionario(String nome, String email, double salarioBase) throws IllegalArgumentException {
	if (nome == null || nome.trim().equals("")) {
	    throw new IllegalArgumentException("Nome de usuario nao pode ser vazio ou null.");
	}
	if (salarioBase <= 0.0) {
	    throw new IllegalArgumentException("Salario base nao pode ser negativo ou zero.");
	}
	if (email == null || email.trim().equals("")) {
	    throw new IllegalArgumentException("Email nao pode ser null ou vazio.");
	}
	if (!email.matches("^.+@.+(\\.[^\\.]+)+$")) {
	    throw new IllegalArgumentException("Email invalido.");
	}
	this.nome = nome;
	this.email = email;
	this.salarioBase = new BigDecimal(salarioBase);
	this.cargo = new Desenvolvedor();
    }

    public double calculaSalario() {
	return cargo.calculaSalario(salarioBase).doubleValue();
    }

    public void setSalario(double novoSalario) throws IllegalArgumentException {
	if (novoSalario <= 0.0) {
	    throw new IllegalArgumentException("Salario base nao pode ser negativo ou zero.");
	}
	salarioBase = new BigDecimal(novoSalario);
    }

    public void setCargo(Cargo cargo) {
	this.cargo = cargo;
    }

    public String getNome() {
	return nome;
    }

    public String getEmail() {
	return email;
    }

    public double getSalarioBase() {
	return salarioBase.doubleValue();
    }

}
