package es2.exercicio2;

public class Testador implements Cargo {

	private static final int LIMIAR = 2000;

	@Override
	public double calculaSalario(double salarioBase) {
		if(salarioBase >= LIMIAR) {
			return salarioBase * 0.75;
		}
		return salarioBase * 0.85;
	}

}
