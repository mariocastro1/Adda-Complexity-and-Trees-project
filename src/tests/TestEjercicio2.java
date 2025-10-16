package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import us.lsi.common.Pair;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;
import us.lsi.recursivos.problemasdelistas.ProblemasDeListas;

public class TestEjercicio2 {
  
	private static Integer nMin = 100; // Tamaño mínimo de la lista a ordenar
	private static Integer nMax = 10000; // Tamaño máximo de la lista a ordenar
	private static Integer nIncr = 3300; // Incremento en el tamaño de la lista   
	private static Integer nIter = 50; // Número de iteraciones para calcular el
	private static Integer nIterWarmup = 500; // Número de iteraciones de calentamiento 
	private static List<Integer> list = List.of();  
	private static Random rr = new Random(System.nanoTime());
  
	public static void main(String[] args) {

		genDataMergeSortUmbral1();
		genDataMergeSortUmbral4();   
		genDataMergeSortUmbral16();
		genDataMergeSortUmbral64();
		genDataMergeSortUmbral256();   
		showGraph("ficheros_generados/1.txt", "Umbral 1: ");
		showGraph("ficheros_generados/4.txt", "Umbral 4: ");   
		showGraph("ficheros_generados/16.txt", "Umbral 16: ");
		showGraph("ficheros_generados/64.txt", "Umbral 64: ");  
		showGraph("ficheros_generados/256.txt", "Umbral 256: ");
		showCombined();
		showCombined();  
   
	}

	private static void generaListaEnteros(Integer t) {  
		List<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i < t; i++) {  
			ls.add(rr.nextInt(t + 10000));  
		}
		list = ls;
	}
   
	private static void genDataMergeSortUmbral1() {
		String file = String.format("ficheros_generados/1.txt");
		Consumer<Integer> cons = t -> generaListaEnteros(t);   
		Function<Integer, Long> f1 = GenData.time(cons, t -> ProblemasDeListas.mergeSort(list, 1));
		GenData.tiemposEjecucionAritmetica(f1, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
      
	private static void genDataMergeSortUmbral4() {   
		String file = String.format("ficheros_generados/4.txt");   
		Consumer<Integer> cons = t -> generaListaEnteros(t);   
		Function<Integer, Long> f1 = GenData.time(cons, t -> ProblemasDeListas.mergeSort(list, 4));
		GenData.tiemposEjecucionAritmetica(f1, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}   
  
	private static void genDataMergeSortUmbral16() {  
		String file = String.format("ficheros_generados/16.txt");
		Consumer<Integer> cons = t -> generaListaEnteros(t);   
		Function<Integer, Long> f1 = GenData.time(cons, t -> ProblemasDeListas.mergeSort(list, 16));
		GenData.tiemposEjecucionAritmetica(f1, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}    
      
	private static void genDataMergeSortUmbral64() {
		String file = String.format("ficheros_generados/64.txt");   
		Consumer<Integer> cons = t -> generaListaEnteros(t);
		Function<Integer, Long> f1 = GenData.time(cons, t -> ProblemasDeListas.mergeSort(list, 64));
		GenData.tiemposEjecucionAritmetica(f1, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}   
  
	private static void genDataMergeSortUmbral256() {
		String file = String.format("ficheros_generados/256.txt");  
		Consumer<Integer> cons = t -> generaListaEnteros(t);
     
		Function<Integer, Long> f1 = GenData.time(cons, t -> ProblemasDeListas.mergeSort(list, 256));
		GenData.tiemposEjecucionAritmetica(f1, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}      
       
	public static void showGraph(String file, String label) {    
		List<WeightedObservedPoint> data = DataFile.points(file); 
		Fit pl = PowerLog.of(List.of(Pair.of(2, 0.), Pair.of(3, 0.)));    
		pl.fit(data);    
		System.out.println(pl.getExpression());   
		System.out.println(pl.getEvaluation().getRMS());   
		MatPlotLib.show(file, pl.getFunction(), String.format("%s %s", label, pl.getExpression()));
	}

	public static void showCombined() {   
		MatPlotLib.showCombined("Tiempos",
				List.of("ficheros_generados/1.txt", "ficheros_generados/4.txt", "ficheros_generados/16.txt",
						"ficheros_generados/64.txt", "ficheros_generados/256.txt"),
				List.of("Umbral 1", "Umbral 4", "Umbral 16", "Umbral 64", "Umbral 256"));
	}   
}
    