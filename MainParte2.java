package tpe;
import java.util.ArrayList;

public class MainParte2 {
    
    public static void main(String[] args) {
		GrafoNoDirigido<Integer> g = new GrafoNoDirigido<>();
		GrafoDirigido<Integer> g2 = new GrafoDirigido<>();
		GrafoNoDirigido<Integer> g3 = new GrafoNoDirigido<>();
		
		String path1 = "C:/Users/Victoria/Documents/datasets/dataset1.txt";
		String path2 = "C:/Users/Victoria/Documents/datasets/dataset2.txt";
		String path3 = "C:/Users/Victoria/Documents/datasets/dataset3.txt";

		CSVReader reader = new CSVReader(path1);
		reader.read(g);
		CSVReader reader2 = new CSVReader(path2);
		reader2.read(g2);
		CSVReader reader3 = new CSVReader(path3);
		reader3.read(g3);	
		
		
		
		System.out.println("GREEDY D1");
		
		Greedy greedy = new Greedy();
		ArrayList<Arco<Integer>> solGreedy1 = greedy.greedy(g);
		System.out.println(greedy.mostrarEstaciones(solGreedy1)
		+ "\n"+ greedy.calcularKm(solGreedy1)
		+ "  kms" +"\n"+ "métrica: " + greedy.getMetrica());

		System.out.println("----------------------------------------------------------------------------");		
		
		System.out.println("BACKTRACKING D1");
		int kmGreedy1 = greedy.getMejorKm();
		Backtracking back = new Backtracking(kmGreedy1);
		ArrayList<Arco<Integer>> solBack1 = back.backtracking(g);
		System.out.println(back.mostrarEstaciones(solBack1)
		+ "\n"+ back.calcularKm(solBack1)
		+ "  kms" +"\n"+ "métrica: " + back.getMetrica());
		
		
		System.out.println("----------------------------------------------------------------------------");
		
		
		System.out.println("GREEDY D2");

		Greedy greedy2 = new Greedy();
		ArrayList<Arco<Integer>> solGreedy2 = greedy2.greedy(g2);
		System.out.println(greedy2.mostrarEstaciones(solGreedy2)
		+ "\n"+ greedy2.calcularKm(solGreedy2)
		+ "  kms" +"\n"+ "métrica: " + greedy2.getMetrica());
		
		System.out.println("----------------------------------------------------------------------------");

		System.out.println("BACKTRACKING D2");
		
		int kmGreedy2 = greedy2.getMejorKm();
		Backtracking back2 = new Backtracking(kmGreedy2);
		
		ArrayList<Arco<Integer>> solBack2 = back2.backtracking(g2);
		System.out.println(back2.mostrarEstaciones(solBack2)
		+ "\n"+ back2.calcularKm(solBack2)
		+ "  kms" +"\n"+ "métrica: " + back2.getMetrica());
		
		System.out.println("----------------------------------------------------------------------------");

		System.out.println("GREEDY D3");
		Greedy greedy3 = new Greedy();
		ArrayList<Arco<Integer>> solGreedy3 = greedy3.greedy(g3);
		System.out.println(greedy3.mostrarEstaciones(solGreedy3)
		+ "\n"+ greedy3.calcularKm(solGreedy3)
		+ "  kms" +"\n"+ "métrica: " + greedy3.getMetrica());
		System.out.println(greedy3.greedy(g3));
		
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("BACKTRACKING D3");

		//lo uso para que back tenga como referencia una solucion con bajo costo
		//que Greedy ya encontro, lo uso para inicializar mi mejorDistancia
		int kmGreedy3 = greedy3.getMejorKm();

		Backtracking back3 = new Backtracking(kmGreedy3);
		System.out.println(back3.backtracking(g3));
		
		ArrayList<Arco<Integer>> solBack3 = back3.backtracking(g3);
		System.out.println("Dataset 3");
		System.out.println( "Backtracking\n"+ back3.mostrarEstaciones(solBack3)
		+ "\n"+ back3.calcularKm(solBack3)
		+ "  kms" +"\n"+ "métrica: " + back3.getMetrica());
		System.out.println("----------------------------------------------------------------------------");


	}
}
/* 
 "Backtracking\n"+ this.mostrarEstaciones() 
		+ "\n"+ this.calcularKm()
		+ "  kms" +"\n"+ "métrica: " + this.getContador() ;

		GrafoNoDirigido<Integer> g4 = new GrafoNoDirigido<>();

		g4.agregarVertice(11);
		g4.agregarVertice(12);
		g4.agregarVertice(13);
		g4.agregarVertice(14);

		g4.agregarArco(11, 12, 20);
		g4.agregarArco(11, 13, 5);
		g4.agregarArco(11, 14,25);
		g4.agregarArco(12, 13, 35);
		g4.agregarArco(12, 14, 10);
		g4.agregarArco(13, 14, 30);
		System.out.println("g4:"+greedy.greedy(g4));
		esConexo conex = new esConexo();
		System.out.println(conex.esConexo(g4));
		*/