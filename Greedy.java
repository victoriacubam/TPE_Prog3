package tpe;

import java.util.ArrayList;
import java.util.Iterator;

public class Greedy {
	
	 ComparadorArco comparador;

	 public Greedy() {
		 this.comparador = new ComparadorArco();
	}

	 public ArrayList<Arco<Integer>> greedy(GrafoDirigido<Integer> grafo){
			
		ArrayList<Arco<Integer>> solucion = new ArrayList<Arco<Integer>>();
		ArrayList<Arco<Integer>> arcos = ordenarArcos(grafo);

		System.out.println("Arcos: " + arcos);
			
		UnionFind conjuntos = new UnionFind(grafo.cantidadVertices());
		
		while((conjuntos.count() > 1) && (!arcos.isEmpty())) { //Mientras tenga mas de un conjunto y me queden arcos
			Arco<Integer> primero = arcos.get(0); //Guardo el primero
			arcos.remove(0);					  //Saco el primero de la lista (comportamiento de pila)
			
			int representanteOrigen = conjuntos.find(primero.getVerticeOrigen());   //Seteo como representantes los 
			int representanteDestino = conjuntos.find(primero.getVerticeDestino()); //vetices del primer arco que agarre
			
			System.out.println("Representante Origen: " + representanteOrigen + " - Representante Destino: "+ representanteDestino);
			
			if(representanteOrigen != representanteDestino) {
				solucion.add(primero);
				conjuntos.union(representanteOrigen, representanteDestino);
			}
		}
		if(conjuntos.count() == 1) {
			return solucion;
		}
		return null;
	}	
		
	public ArrayList<Arco<Integer>> ordenarArcos(GrafoDirigido<Integer> grafo){
		ArrayList<Arco<Integer>> arcos = new ArrayList<Arco<Integer>>();
		Iterator<Arco<Integer>> it = grafo.obtenerArcos();
		while(it.hasNext()){
			Arco<Integer> arco = it.next();
			arcos.add(arco);
		}
		arcos.sort(comparador); //Los ordena por etiqueta
		return arcos;
	}
}
