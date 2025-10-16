package tests;

import funciones.Txt_reader;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;
import funciones.Ejercicio1;
//import funciones.Ejercicio2;
import funciones.Ejercicio3;
import funciones.Ejercicio4;



public class Test {

	public static void main (String[] args) {
		
		System.out.println("lectura de ficheros:");
		System.out.println("ejercicio 3 Binary: " + Txt_reader.readerStr("src/ficheros/PI2Ej3DatosEntradaBinary.txt"));
		System.out.println("ejercicio 3 Nary: " + Txt_reader.readerStr("src/ficheros/PI2Ej3DatosEntradaNary.txt"));
		System.out.println("ejercicio 4 Binary: " + Txt_reader.readerStr("src/ficheros/PI2Ej4DatosEntradaBinary.txt"));
		System.out.println("ejercicio 4 Nary: " + Txt_reader.readerStr("src/ficheros/PI2Ej4DatosEntradaNary.txt"));
		
		System.out.println("\nPruebas de los tests del proyecto1:");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Pruebas de los tests del Ejercicio1:\n");
		Integer prueba_ej1 =  7;
		System.out.println(Ejercicio1.RecursivaDouble(prueba_ej1));
		System.out.println(Ejercicio1.IterativaDouble(prueba_ej1));
		System.out.println(Ejercicio1.RecursivaBigInteger(prueba_ej1));
		System.out.println(Ejercicio1.IterativaBigInteger(prueba_ej1));
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Pruebas de los tests del Ejercicio2:\n");

		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Pruebas de los tests del Ejercicio3:\n");
		
		System.out.println("Ejemplo de Binary:");
        BinaryTree<String> treeB = BinaryTree.parse("A(B,C)");
        System.out.println("Arbol a probar: " + treeB);
        System.out.println("Resultados: " + Ejercicio3.Binary(treeB));
        
        System.out.println("\nEjemplo de Nary:");
        Tree<String> treeN = Tree.parse("A(B(E(/_,J),F),C(M,/_),D(G,H(K,L(O,O)),I))");
        System.out.println("Arbol a probar: " + treeN);
        System.out.println("Resultados: " + Ejercicio3.Nary(treeN));
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Pruebas de los tests del Ejercicio4:\n");

		Integer arbol = 5;// introducir ejemplo a probar
        BinaryTree<String> tree_p1 = BinaryTree.parse( Txt_reader.readerStr("src/ficheros/PI2Ej4DatosEntradaBinary.txt")
        		.get(arbol));
        System.out.println("arbol de prueba Binario: " + tree_p1);
        System.out.println("resultados:");
		Ejercicio4.Binary(tree_p1).forEach(System.out::println);
		
		Integer Narbol = 1;// introducir ejemplo a probar
        Tree<String> Ntree_p1 = Tree.parse(Txt_reader.readerStr("src/ficheros/PI2Ej4DatosEntradaNary.txt").get(Narbol));
        System.out.println("\narbol de prueba Nario: " + Ntree_p1);
        System.out.println("resultados:");
		Ejercicio4.Nary(Ntree_p1).forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");	

	
	}

	
	
}
