package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tpe.Grafo;
import tpe.*;

public class ServicioCaminos<T> {

	private Grafo<Integer> grafo;
	private int origen;
	private int destino;
	private int lim;
	private HashMap<ArrayList<Arco<T>>, Boolean> visitados;

	
	// Servicio caminos
	public ServicioCaminos(Grafo<Integer> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
		this.visitados = new HashMap<>(); 
	}

	/*
	 * Caminos: dado un origen, un destino y un límite “lim” retorna todos los caminos que, partiendo del vértice origen, 
	 * llega al vértice de destino sin pasar por más de “lim” arcos. 
	 * Aclaración importante: en un camino no se puede pasar 2 veces por el mismo arco.
	 */
	public List<List<Integer>> caminos() {
		// Resolver Caminos
		List<List<Integer>> caminos = new ArrayList<>();
		//Ponemos todos en no visitados
		Iterator<Arco<Integer>> iter1 = grafo.obtenerArcos(); 
		while(iter1.hasNext()) {
			Arco<Integer> v = iter1.next();
			ArrayList<Arco<T>> aux = new ArrayList<Arco<T>>();
			visitados.put(aux, false);
		}	
		
		caminos.add(camino(this.origen, this.destino, this.lim));
		return caminos; //Devolveria una lista de listas con todos los caminos posibles
	}
	
	private List<Integer> camino(int origen, int destino, int lim){
		List<Integer> camino = new ArrayList<>();
		camino.add(origen);
		Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(origen);
		int i = 0;
		if(adyacentes!=null) {
			while (adyacentes.hasNext() && i<lim) {
				int a = adyacentes.next();
				if(visitados.get(a)==false && a==destino) {
					camino.add(a);
					return camino;
				} else {
					ArrayList<Arco<T>> aux = new ArrayList<Arco<T>>();
					Arco<T> ar = (Arco<T>) grafo.obtenerArco(origen, a);
					aux.add(ar);
					visitados.put(aux, true);
					camino(a, destino, lim);
				}
					//ordenVisitados.add(a);
			}
			
		}
		return camino;
	}

	/*
	 * BFS (Grafo G):
		Vaciar la fila F.
		Para cada vértices v de G
			Marcar v como NO_VISITADO.
		BFS(G,origen)
		retornar la lista
	 */
	
	/*
	 * BFS (Grafo G, vértice origen):
	 * 	nivel 0
	 * 	Marcar el vértice origen como VISITADO.
		Agregar origen a la fila F.
		Mientras la fila F no esté vacía
			Tomamos vértice x de la fila,
			nivel++?
			Si x es destino :
			 	chequeo q nivel estoy si es menor al limite
			 		agrego x a la fila
			 		devuelvo la fila?
			sino :
				mientras q nivel sea menor al limite
					Para cada vértice y adyacente a x:
						Si y es NO_VISITADO e y no es destino:
							Marcar el vértice y como VISITADO.
							nivel++
							Agregar y a la fila F.
	 */
	

	
	
}