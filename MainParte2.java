package tpe;

import java.util.HashSet;
import java.util.Set;

public class MainParte2 {
	
	public static void main(String[] args) {
		
		Set s = new HashSet<>();
		
		
		
		GrafoNoDirigido<Integer> g2 = new GrafoNoDirigido<>();
		

		String path = "C:/Users/Victoria/Documents/datasets/dataset1.txt";
		CSVReader reader = new CSVReader(path);
		reader.read(g2);
				
		//System.out.println("Greedy");
		
		//g2.imprimirGrafo();
		//g2.imprimirEtiquetaArco();
		//Greedy greedy = new Greedy();
		//greedy.greedy(g2);
		//System.out.println("Solucion: " + greedy.greedy(g2));
		
		
		Backtracking back = new Backtracking();
		back.backtracking(g2);
		System.out.println("Backtracking");
		System.out.println("Solucion: " + back.backtracking(g2));
		System.out.println("Distancia: " + back.getDistanciaMin());
		//System.out.println(g2.isConexo()); 
		//System.out.println(back.getContador());
		
	}

}