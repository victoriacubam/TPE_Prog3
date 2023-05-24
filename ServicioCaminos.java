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
	private Set<Arco<Integer>> arcosVisitados; 
	private List<List<Integer>> caminos;

	
	public ServicioCaminos(Grafo<Integer> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
		this.arcosVisitados = new HashSet<>();
		this.caminos = new ArrayList<>();
	}

	public List<List<Integer>> caminos() {
		List<Integer> caminoActual = new ArrayList<>();
		caminoActual.add(this.origen);
		this.arcosVisitados.clear();
		this.caminos.clear();
		buscarCaminos(this.origen, caminoActual, 0);
		return caminos;
	}
	
	private void buscarCaminos(int verticeActual, List<Integer> caminoActual, int saltos) {
		if(saltos<= this.lim && verticeActual == this.destino) {
			this.caminos.add(new ArrayList<>(caminoActual)); 
		
		} else if (saltos < this.lim) {
			Iterator<Arco<Integer>> iteradorArcos = grafo.obtenerArcos(verticeActual);
				
			while(iteradorArcos!=null && iteradorArcos.hasNext()) {
					Arco<Integer> a = iteradorArcos.next();
					
					if(!arcosVisitados.contains(a)) { 
						this.arcosVisitados.add(a);
						int verticeAdy =a.getVerticeDestino();
						caminoActual.add(verticeAdy);
						buscarCaminos(verticeAdy, caminoActual, saltos+1);
						caminoActual.remove(caminoActual.size() -1);
						this.arcosVisitados.remove(a);
					}
				}
			}

	}
}