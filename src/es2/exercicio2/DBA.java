package es2.exercicio2;

public class DBA implements Cargo {

	private static final double LIMIAR = 2000.00;

	@Override
	public double calculaSalario(double salarioBase) {
		if(salarioBase >= LIMIAR) {
			return salarioBase * 0.75;
		}
		return salarioBase * 0.85;
	}

}
