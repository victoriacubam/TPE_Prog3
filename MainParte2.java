package tpe;
import java.util.ArrayList;

public class MainParte2 {
    
    public static void main(String[] args) {
    	
		GrafoDirigido<Integer> g1 = new GrafoDirigido<>();
		GrafoDirigido<Integer> g2 = new GrafoDirigido<>();
		GrafoDirigido<Integer> g3 = new GrafoDirigido<>();
		
		// Cambiar rutas segun sea necesario
		String path1 = "/datasets/dataset1.txt";
		String path2 = "/datasets/dataset2.txt";
		String path3 = "/datasets/dataset3.txt";

		CSVReader reader = new CSVReader(path1);
		reader.read(g1);
		
		CSVReader reader2 = new CSVReader(path2);
		reader2.read(g2);
		
		CSVReader reader3 = new CSVReader(path3);
		reader3.read(g3);	
		
		
		// GREEDY DATASET 1
		
		System.out.println("Greedy Dataset 1");
		
		Greedy greedy = new Greedy();
		ArrayList<Arco<Integer>> solucionGreedy1 = greedy.greedy(g1);
		System.out.println(greedy.mostrarEstaciones(solucionGreedy1)
							+ "\n"+ greedy.calcularKm(solucionGreedy1)
							+ " kms" +"\n"+ "métrica: " + greedy.getMetrica());

		System.out.println("----------------------------------------------------------------------------");		
		
		
		// BACKTRACKING DATASET 1
		
		System.out.println("Backtracking Dataset 1");
		
		int kmGreedy1 = greedy.getMejorKm();
		Backtracking back = new Backtracking(kmGreedy1);
		ArrayList<Arco<Integer>> solBack1 = back.backtracking(g1);
		
		System.out.println(back.mostrarEstaciones(solBack1)
							+ "\n"+ back.calcularKm(solBack1)
							+ " kms" +"\n"+ "métrica: " + back.getMetrica());
		
		System.out.println("----------------------------------------------------------------------------");
		
		
		// GREEDY DATASET 2
		
		System.out.println("Greedy Dataset 2");

		Greedy greedy2 = new Greedy();
		ArrayList<Arco<Integer>> solGreedy2 = greedy2.greedy(g2);
		System.out.println(greedy2.mostrarEstaciones(solGreedy2)
							+ "\n"+ greedy2.calcularKm(solGreedy2)
							+ " kms" +"\n"+ "métrica: " + greedy2.getMetrica());
							
		System.out.println("----------------------------------------------------------------------------");

		
		// BACKTRACKING DATASET 2
		
		System.out.println("Backtracking Dataset 2");
		
		int kmGreedy2 = greedy2.getMejorKm();
		Backtracking back2 = new Backtracking(kmGreedy2);
		ArrayList<Arco<Integer>> solBack2 = back2.backtracking(g2);
		
		System.out.println(back2.mostrarEstaciones(solBack2)
							+ "\n"+ back2.calcularKm(solBack2)
							+ " kms" +"\n"+ "métrica: " + back2.getMetrica());
		
		System.out.println("----------------------------------------------------------------------------");

		
		// GREEDY DATASET 3
		
		System.out.println("Greedy Dataset 3");
		
		Greedy greedy3 = new Greedy();
		ArrayList<Arco<Integer>> solGreedy3 = greedy3.greedy(g3);
		
		System.out.println(greedy3.mostrarEstaciones(solGreedy3)
							+ "\n"+ greedy3.calcularKm(solGreedy3)
							+ " kms" +"\n"+ "métrica: " + greedy3.getMetrica());
		
		System.out.println("----------------------------------------------------------------------------");
		
		
		// BACKTRACKING DATASET 3
		
		System.out.println("Backtracking Dataset 3");

		int kmGreedy3 = greedy3.getMejorKm();
		Backtracking back3 = new Backtracking(kmGreedy3);		
		ArrayList<Arco<Integer>> solBack3 = back3.backtracking(g3);

		System.out.println(back3.mostrarEstaciones(solBack3)
							+ "\n"+ back3.calcularKm(solBack3)
							+ " kms" +"\n"+ "métrica: " + back3.getMetrica());
		
		System.out.println("----------------------------------------------------------------------------");
	}
}
