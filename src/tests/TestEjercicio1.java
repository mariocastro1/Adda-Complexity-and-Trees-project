package tests;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import funciones.Ejercicio1;
import us.lsi.common.Pair;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;

public class TestEjercicio1 {
	
	private static Integer nMin = 1000; // n mínimo para el cálculo de potencia
	private static Integer nMax = 10000; // n máximo para el cálculo de potencia
	private static Integer nIncr = 500; // incremento en los valores de n del cálculo de potencia
	private static Integer nIter = 50; // número de iteraciones para cada medición de tiempo
	private static Integer nIterWarmup = 1000; // número de iteraciones para warmup
	
	private static void genDataRecursivoDouble() {
		String file = "ficheros_generados/1rd.txt";
		Consumer<Integer> cons = i -> Ejercicio1.RecursivaDouble(i);
		Function<Integer,Long> fl = GenData.time(cons);
		GenData.tiemposEjecucionAritmetica(fl, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	private static void genDataIterativoDouble() {
		String file = "ficheros_generados/1id.txt";
		Function<Integer,Long> f1 = GenData.time(i -> Ejercicio1.IterativaDouble(i));
		GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,nIncr,nIter,nIterWarmup);
	}
	
	private static void genDataRecursivoBigInteger() {
		String file = "ficheros_generados/1rb.txt";
		Consumer<Integer> cons = i -> Ejercicio1.RecursivaBigInteger(i);
		Function<Integer,Long> fl = GenData.time(cons);
		GenData.tiemposEjecucionAritmetica(fl, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	private static void genDataIterativoBigInteger() {
		String file = "ficheros_generados/1ib.txt";
		Consumer<Integer> cons = i -> Ejercicio1.IterativaBigInteger(i);
		Function<Integer,Long> fl = GenData.time(cons);
		GenData.tiemposEjecucionAritmetica(fl, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
//	MOSTRAR GRÁFICOS DE LAS CUATRO FUNCIONES
	
	public static void showRecursivoDouble() {
		String file = "ficheros_generados/1rd.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.)));
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), "Recursivo Double: " + pl.getExpression());
	}
	
	public static void showIterativoDouble() {
		String file = "ficheros_generados/1id.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.)));
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), "Iterativo Double: " + pl.getExpression());
	}
	
	public static void showRecursivoBigInteger() {
		String file = "ficheros_generados/1rb.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.)));
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), "Recursivo BigInteger: " + pl.getExpression());
	}
	
	public static void showIterativoBigInteger() {
		String file = "ficheros_generados/1ib.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.)));
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), "Iterativo BigInteger: " + pl.getExpression());
	}

	public static void showCombined1() {
	    MatPlotLib.showCombined("Tiempos",
	            List.of("ficheros_generados/1rd.txt", "ficheros_generados/1id.txt", "ficheros_generados/1rb.txt", "ficheros_generados/1ib.txt"),
	            List.of("Recursiva Double", "Iterativa Double", "Recursiva BigInteger", "Iterativa BigInteger"));
	}
	
	public static void showCombined2() {
	    MatPlotLib.showCombined("Tiempos",
	            List.of("ficheros_generados/1rd.txt", "ficheros_generados/1id.txt"),
	            List.of("Recursiva Double", "Iterativa Double"));
	}

	
	public static void main(String[] args) {
		genDataRecursivoDouble();
		genDataIterativoDouble();
		genDataRecursivoBigInteger();
		genDataIterativoBigInteger();
		
		showRecursivoDouble();
		showIterativoDouble();
		showRecursivoBigInteger();
		showIterativoBigInteger();
		
		showCombined1();
		showCombined2();
	}

}