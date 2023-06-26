package tpe;

import java.util.ArrayList;
import java.util.Iterator;

public class Backtracking {
	private ArrayList<Arco<Integer>> solucion;
	private ArrayList<Arco<Integer>> arcos;
	private int distanciaMin;
	private int contador;
	

	public Backtracking() {
		this.arcos = new ArrayList<>();
		this.solucion = new ArrayList<>();
		this.distanciaMin = Integer.MAX_VALUE;
		this.contador = 0;
	}
	
	public int getDistanciaMin() {
		return distanciaMin;
	}
	
	public int getContador() {
		return contador;
	}
	
	public ArrayList<Arco<Integer>> backtracking(GrafoNoDirigido<Integer>g){
		int estaciones = g.cantidadVertices(); //La cantidad total de estaciones
		this.arcos = obtenerArcos(g);
		
		ArrayList<Arco<Integer>> solucionParcial = new ArrayList<>();
		ArrayList<Integer> visitados = new ArrayList<>(); //vertices
		//ArrayList<Arco<Integer>> visitados = new ArrayList<>();
		backtracking(solucionParcial, visitados, estaciones, g);
		System.out.println(this.distanciaMin);
		return solucion;
		
	}		
	
	private void backtracking(ArrayList<Arco<Integer>> solucionParcial, ArrayList<Integer> visitados, int estaciones, GrafoNoDirigido<Integer>g) {
		contador++;
		//condicion de corte: que ya haya visitado todas las estaciones
		if (visitados.size() == estaciones) {
			int distanciaTotal = calcularDistancia(solucionParcial);
			if(distanciaTotal < this.distanciaMin) { //Si la distancia de los tuneles es menor de la que tengo hasta el momento
				this.distanciaMin = distanciaTotal;
				this.solucion.addAll(solucionParcial);
			} 
			return;
		}
		Iterator<Arco<Integer>> iter = g.obtenerArcos();
		while (iter.hasNext()) {
			Arco<Integer> arco = iter.next();
			int origen = arco.getVerticeOrigen();
			int destino = arco.getVerticeDestino();
			if((!visitados.contains(origen))&&(!visitados.contains(destino))) {
			 
				solucionParcial.add(arco);
				visitados.add(origen);
				visitados.add(destino);
				//System.out.println(visitados);
				backtracking(solucionParcial, visitados, estaciones, g);
				solucionParcial.remove(solucionParcial.size()-1); //Remueve el ultimo arco
				visitados.remove(visitados.size()-1);
				visitados.remove(visitados.size()-1); //Remueve los ultimos dos vertices.
				//O podria ser:
				//verticesVisitados.remove(origen);
				//verticesVisitados.remove(destino);
				
			}
			if((!visitados.contains(origen))&&(!visitados.contains(destino))) {
				 
				solucionParcial.add(arco);
				
				visitados.add(origen);
				visitados.add(destino);
				//System.out.println(visitados);
				backtracking(solucionParcial, visitados, estaciones, g);
				solucionParcial.remove(solucionParcial.size()-1); //Remueve el ultimo arco
				visitados.remove(visitados.size()-1);
				visitados.remove(visitados.size()-1); //Remueve los ultimos dos vertices.
				//O podria ser:
				//verticesVisitados.remove(origen);
				//verticesVisitados.remove(destino);
				
			}
			
		}		
	}
	
	private int calcularDistancia(ArrayList<Arco<Integer>> solucionParcial)	{
		int distancia = 0;
		for (Arco<Integer> a : solucionParcial) {
			distancia += a.getEtiqueta();
		}
		return distancia;
	}
	
	public ArrayList<Arco<Integer>> obtenerArcos(GrafoDirigido<Integer> grafo){
		ArrayList<Arco<Integer>> arcos = new ArrayList<Arco<Integer>>();
		Iterator<Arco<Integer>> it = grafo.obtenerArcos();
		while(it.hasNext()){
			Arco<Integer> arco = it.next();
			arcos.add(arco);
		}
		return arcos;
	}
		
}
