package es2.exercicio2;

public class Funcionario {
	
	private double salarioBase;
	private Cargo cargo;
	
	public Funcionario(double salarioBase) {
		this.salarioBase = salarioBase;
		this.cargo = new Desenvolvedor();
	}

	public double calculaSalario() {
		return cargo.calculaSalario(salarioBase);
	}

	public void setSalario(double novoSalario) {
		this.salarioBase = novoSalario;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
