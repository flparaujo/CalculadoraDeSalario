package es2.exercicio2;

public class Gerente implements Cargo {

	private static final double LIMIAR = 5000.00;

	@Override
	public double calculaSalario(double salarioBase) {
		if(salarioBase >= LIMIAR) {
			return salarioBase * 0.7;
		}
		return salarioBase * 0.8;
	}

}
