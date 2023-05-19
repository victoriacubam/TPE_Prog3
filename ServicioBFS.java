package tpe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServicioBFS {

	private Grafo<Integer> grafo;
	private Queue<Integer> fila;
	private HashMap<Integer, Boolean> visitados;
	
	public ServicioBFS(Grafo<Integer> grafo) {
		this.grafo = grafo;
		this.fila = new LinkedList<>();
		this.visitados = new HashMap<>(); 
	}
	
	public List<Integer> bfsForest() {
		this.fila.clear();
		Iterator<Integer> iter1 = grafo.obtenerVertices(); 
		while(iter1.hasNext()) {
			int v = iter1.next();
			visitados.put(v, false);
		}
		
		ArrayList<Integer> ordenVisitados = new ArrayList<>();
		Iterator<Integer> iter2 = grafo.obtenerVertices(); 
		while(iter2.hasNext()) {
			int v = iter2.next();
			if(visitados.get(v)==false) {
				bfsForest(v, ordenVisitados);
			}
		}
		
		return ordenVisitados;
	}

	private void bfsForest(int vertice, ArrayList<Integer> ordenVisitados) {
		visitados.put(vertice, true);
		this.fila.add(vertice);
		ordenVisitados.add(vertice);
		while (!this.fila.isEmpty()) {
			int x = this.fila.poll();
			Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(x);
			if(adyacentes!=null) {
				while (adyacentes.hasNext()) {
					int a = adyacentes.next();
					if(visitados.get(a)==false) {
						visitados.put(a, true);
						this.fila.add(a);
						ordenVisitados.add(a);
					}
				}
			}
		}
	}
	
}