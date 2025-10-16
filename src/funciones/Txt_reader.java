package funciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Txt_reader {

	public static List<String> readerStr(String file) {
		List<String> res = new ArrayList<>();
		String nombreArchivo = file;
	    try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
	    	String linea;
	    	while ((linea = br.readLine()) != null) {
	    		res.add(linea);
	    	}
	    	return res;
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
		}
	    return res;
	}
	
	
	public static List<List<Integer>> readerInt(String file) {
		List<String> lsi = readerStr(file);
		List<List<Integer>> res2 = new ArrayList<>();
		for (int i = 0; i < lsi.size(); i++) {
			String[] lss = lsi.get(i).split(",");
			List<Integer> res1 = new ArrayList<>();
			for (int j = 0; j < lss.length; j++) {
				res1.add(Integer.parseInt(lss[j]));
				
			}
			res2.add(res1);
		}
		return res2;
		
		
		
		
		
	}
	
	
	
//	public static List<Integer> readerInt(String file) {
//
//		List<List<Integer>> res = new ArrayList<>();
//		String nombreArchivo = file;
//	    try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
//	    	String linea;
//	    	while ((linea = br.readLine()) != null) {
//	    		String[] ls = linea.split(",");
//	    		res.add(ls);
//	    	}
//	    	return res;
//	    } 
//	    catch (IOException e) {
//	    	e.printStackTrace();
//		}
//	    return res;
//	}

	
	
	
	
}