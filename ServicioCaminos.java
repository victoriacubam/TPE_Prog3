package tpe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class ServicioCaminos {

	private Grafo<Integer> grafo;
	private int origen;
	private int destino;
	private int lim;
	private Set<Arco<Integer>> arcosVisitados; //Uso un hashSet para que al momento de hacer el .contains() tenga menor complejidad computacional, ademas al no poder existir elemntos duplicados es la mejor opcion
	private List<List<Integer>> caminos;

	
	// Servicio caminos
	public ServicioCaminos(Grafo<Integer> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
		this.arcosVisitados = new HashSet<>();
		this.caminos = new ArrayList<>();
	}

	/*
	 * Caminos: dado un origen, un destino y un límite “lim” retorna todos los caminos que, partiendo del vértice origen, 
	 * llega al vértice de destino sin pasar por más de “lim” arcos. 
	 * Aclaración importante: en un camino no se puede pasar 2 veces por el mismo arco.
	 */
	public List<List<Integer>> caminos() {
		List<Integer> camino = new ArrayList<>();
		camino.add(this.origen);
		this.arcosVisitados.clear();
		this.caminos.clear();
		buscarCaminos(this.origen, camino, 1);
		return caminos;
	}
	
	private void buscarCaminos(int verticeActual, List<Integer> caminoEncontrado, int saltos) {
		if(saltos<= this.lim && verticeActual == this.destino) {
			this.caminos.add(new ArrayList<>(caminoEncontrado)); //Si encuentra el destino agrega a la solucion final el camino encontrado hasta el momento
		
		} else if (saltos < this.lim) { // Si no es el destino pero esta dentro del limite de saltos sigue buscando entre los arcos los adyacentes
			Iterator<Arco<Integer>> iteradorArcos = grafo.obtenerArcos(verticeActual);
				
			while(iteradorArcos!=null && iteradorArcos.hasNext()) { //Mientra que mi vertice actual tenga arcos (o sea que tenga adyacentes)
					Arco<Integer> a = iteradorArcos.next();
					
					if(!arcosVisitados.contains(a)) { //Itero los arcos del vertice actual y si no fue visitado
						this.arcosVisitados.add(a); //Lo marco como visitado
						int verticeAdy =a.getVerticeDestino(); //Guardo el vertice adyacente de mi vertice actual (por el arco en el que estoy parado)
						caminoEncontrado.add(verticeAdy); //Agrego el vertice a mi camino
						buscarCaminos(verticeAdy, caminoEncontrado, saltos+1); // Llamo recursivamente a la funcion para encontrar el camino que sigue a traves del vertice adyacente
						caminoEncontrado.remove(caminoEncontrado.size() -1); // Una vez que hizo un recorrido entero y ya no hay mas arcos sin visitar que recorrer, retrocede para explorar otros adyacentes
						this.arcosVisitados.remove(a); // Cuando ya hizo un camino completo borra los visitados para buscar otros caminos
					}
				}
			}

	}
}