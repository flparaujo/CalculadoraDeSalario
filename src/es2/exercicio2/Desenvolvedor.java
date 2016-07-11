package es2.exercicio2;

public class Desenvolvedor implements Cargo {

	private static final double LIMIAR = 3000.00;

	@Override
	public double calculaSalario(double salarioBase) {
		if (salarioBase >= LIMIAR) {
			return salarioBase * 0.8;
		}
		return salarioBase * 0.9;
	}

}
