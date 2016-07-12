package es2.exercicio2;

public class Funcionario {

    private double salarioBase;
    private Cargo cargo;
    private String nome;
    private String email;

    public Funcionario(String nome, String email, double salarioBase) throws Exception {
	if (nome == null || nome.trim().equals("")) {
	    throw new Exception("Nome de usuario nao pode ser vazio ou null.");
	}
	if (salarioBase <= 0.0) {
	    throw new Exception("Salario base nao pode ser negativo ou zero.");
	}
	if (email == null || email.trim().equals("")) {
	    throw new Exception("Email nao pode ser null ou vazio.");
	}
	if (!email.matches("^.+@.+(\\.[^\\.]+)+$")) {
	    throw new Exception("Email invalido.");
	}
	this.nome = nome;
	this.email = email;
	this.salarioBase = salarioBase;
	this.cargo = new Desenvolvedor();
    }

    public double calculaSalario() {
	return cargo.calculaSalario(salarioBase);
    }

    public void setSalario(double novoSalario) throws Exception {
	if (novoSalario <= 0.0) {
	    throw new Exception("Salario base nao pode ser negativo ou zero.");
	}
	salarioBase = novoSalario;
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
	return salarioBase;
    }

}
