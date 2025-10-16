package funciones;

import java.math.BigInteger;
import java.lang.Math;

public class Ejercicio1 {

	public static Double RecursivaDouble(Integer a) {
		return RecursivaDouble(a, 1.);
	}

	public static Double RecursivaDouble(Integer a, Double res) {
		if (a < 6) {
			return res * 10;
		} else {
			return Math.pow(a, 3) * RecursivaDouble(a - 1, res);
		}
	}

	public static Double IterativaDouble(Integer a) {
		Double res = 10.;
		while (a >= 6) {
			res *= Math.pow(a, 3.);
			a--;
		}
		return res;
	}

	public static BigInteger RecursivaBigInteger(Integer a) {
		return RecursivaBigInteger(a, BigInteger.ONE);
	}

	public static BigInteger RecursivaBigInteger(Integer a, BigInteger res) {
		if (a < 6) {
			return res.multiply(BigInteger.TEN);
		} else {
			return BigInteger.valueOf(a).pow(3).multiply(RecursivaBigInteger(a - 1, res));
		}
	}

	public static BigInteger IterativaBigInteger(Integer a) {
		BigInteger res = BigInteger.TEN;
		while (a >= 6) {
			res = BigInteger.valueOf(a).pow(3).multiply(res);
			a--;
		}
		return res;
	}

}