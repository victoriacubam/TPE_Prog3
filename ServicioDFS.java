package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class ServicioDFS {

	private Grafo<Integer> grafo;
	private HashMap<Integer, String> colores; // <Vertice, color> blanco: no visitado | amarillo: visitado | negro:ya no tiene mas a donde ir asi que vuelve en la recursion

	public ServicioDFS(Grafo<Integer> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();

	}
	
	public List<Integer> dfsForest() {
		Iterator<Integer> vertices = grafo.obtenerVertices(); 
		while(vertices.hasNext()) {
			int v = vertices.next();
			colores.put(v, "blanco");
		}
		Iterator<Integer> vertices1 = grafo.obtenerVertices(); 
		ArrayList<Integer> ordenVisitados = new ArrayList<>();
		while(vertices1.hasNext()) {
			int v = vertices1.next();
			if(colores.get(v)=="blanco") {
				ordenVisitados.add(v);
				dfsVisitar(v, ordenVisitados);
			}
		}
		
		return ordenVisitados;
	}
	
	private void dfsVisitar(int vertice, ArrayList<Integer> ordenVisitados) {
		colores.put(vertice, "amarillo"); //Visitado
		Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
		if(adyacentes!=null) {
			while(adyacentes.hasNext()) {
				int a = adyacentes.next();
				if(colores.get(a)=="blanco") {
					ordenVisitados.add(a);
					dfsVisitar(a, ordenVisitados);
				}
			}
		}
		colores.put(vertice, "negro");
	}

	


}