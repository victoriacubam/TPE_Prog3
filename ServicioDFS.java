package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class ServicioDFS {

	private Grafo<Integer> grafo;
	private HashMap<Integer, String> colores;
	private String sinVisitar;
	private String visitado;
	private String adyVisitados;

	
	public ServicioDFS(Grafo<Integer> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.sinVisitar = "blanco";
		this.visitado = "amarillo";
		this.adyVisitados = "negro";
	}
	
	public List<Integer> dfsForest() {
		Iterator<Integer> iter1 = grafo.obtenerVertices(); 
		while(iter1.hasNext()) {
			int v = iter1.next();
			colores.put(v, this.sinVisitar);
		}
		Iterator<Integer> iter2 = grafo.obtenerVertices(); 
		List<Integer> ordenVisitados = new ArrayList<>();
		
		while(iter2.hasNext()) {
			int v = iter2.next();
			if(colores.get(v)==this.sinVisitar) {
				ordenVisitados.add(v);
				dfsVisitar(v, ordenVisitados);
			}
		}
		return ordenVisitados;
	}
	
	private void dfsVisitar(int vertice, List<Integer> ordenVisitados) { //Se puede pasar por parametro? o mejor hacerlo metodo q retorne y hacer un add all?
		colores.put(vertice, this.visitado);
		Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
		if(adyacentes!=null) {
			while(adyacentes.hasNext()) {
				int a = adyacentes.next();
				if(colores.get(a)==this.sinVisitar) {
					ordenVisitados.add(a);
					dfsVisitar(a, ordenVisitados);
				}
			}
		}
		colores.put(vertice, this.adyVisitados);
	}
}