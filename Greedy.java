package tpe;

import java.util.ArrayList;
import java.util.Iterator;

public class Greedy {
    ComparadorArco comparador;
	private int metrica;
	private int mejorKm;

	public Greedy() {
		this.comparador = new ComparadorArco();
		this.metrica = 0; 
		this.mejorKm = 0;
	}
	
	public ArrayList<Arco<Integer>> greedy(GrafoDirigido<Integer> grafo){
		
		ArrayList<Arco<Integer>> solucion = new ArrayList<Arco<Integer>>();
		ArrayList<Arco<Integer>> arcos = ordenarArcos(grafo);
		ArrayList<Integer> vertices = obtenerVertices(grafo);
		
		UnionFind conjuntos = new UnionFind(grafo.cantidadVertices());
		
		while((conjuntos.count() > 1) && (!arcos.isEmpty())) {

			Arco<Integer> arco = arcos.get(0);
			arcos.remove(0);
			
			int repOrigen = conjuntos.find(vertices.indexOf(arco.getVerticeOrigen()));
			int repDestino = conjuntos.find(vertices.indexOf(arco.getVerticeDestino()));
			
			if(repOrigen != repDestino) {
				solucion.add(arco);
				conjuntos.union(repOrigen, repDestino);
			}
			metrica++;
		}
		if(conjuntos.count() == 1) {
			return solucion;
		}
		return null;
	}

	public String mostrarEstaciones(ArrayList<Arco<Integer>> solucion){
		String estaciones = "";
		if(solucion!=null) { 
			for(Arco<Integer> a: solucion){
				estaciones += "E"+a.getVerticeOrigen() +"-"+"E"+a.getVerticeDestino()+", ";
			}
		}
		return estaciones;			
	}

	public int calcularKm(ArrayList<Arco<Integer>> solucion){
		int distanciaTotal = 0;
		if(solucion!=null) {
			for(Arco<Integer> a: solucion){
				distanciaTotal += a.getEtiqueta(); 
			}
			this.setMejorKm(distanciaTotal);
			return distanciaTotal;			
		}
		return -1;
	}

	private ArrayList<Integer> obtenerVertices(GrafoDirigido<Integer> grafo){
		ArrayList<Integer> vertices = new ArrayList<>();
		Iterator<Integer> iter = grafo.obtenerVertices();
		while(iter.hasNext()){
			Integer v = iter.next();
			if(!vertices.contains(v)){
				vertices.add(v);
			}
		}
		return vertices;
	}

	private ArrayList<Arco<Integer>> ordenarArcos(GrafoDirigido<Integer> grafo){
		ArrayList<Arco<Integer>> arcos = new ArrayList<Arco<Integer>>();
		Iterator<Arco<Integer>> iter = grafo.obtenerArcos();

		while(iter.hasNext()){
			Arco<Integer> arco = iter.next();
			arcos.add(arco);
		}
		arcos.sort(comparador);
		return arcos;
	}
	
	public int getMetrica() {
		return metrica;
	}


	public void setMetrica(int metrica) {
		this.metrica = metrica;
	}


	public int getMejorKm() {
		return mejorKm;
	}


	public void setMejorKm(int mejorKm) {
		this.mejorKm = mejorKm;
	}
		
}