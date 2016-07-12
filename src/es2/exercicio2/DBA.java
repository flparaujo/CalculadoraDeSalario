package es2.exercicio2;

import java.math.BigDecimal;

public class DBA implements Cargo {

	private static final BigDecimal LIMIAR = new BigDecimal(2000.00);

	@Override
	public BigDecimal calculaSalario(BigDecimal salarioBase) {
		if(salarioBase.compareTo(LIMIAR) >= 0) {
			return salarioBase.multiply(new BigDecimal(0.75));
		}
		return salarioBase.multiply(new BigDecimal(0.85));
	}

}
