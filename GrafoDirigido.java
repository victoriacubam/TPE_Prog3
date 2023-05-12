package tpe;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;

public class GrafoDirigido<T> implements Grafo<T> {
	
	private HashMap<Integer, ArrayList<Arco<T>>> vertices;
	private int cantidadVertices;
	private int cantidadArcos;
	
	public GrafoDirigido() {
		this.vertices = new HashMap<>();
		this.cantidadVertices = 0;
		this.cantidadArcos = 0;
	}

	@Override
	public void agregarVertice(int verticeId) {
		if(!this.contieneVertice(verticeId)) {
			vertices.put(verticeId, new ArrayList<Arco<T>>());
			cantidadVertices++;			
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		//Borrar los arcos del vertice
		//Investigar como iterar el hashmap
		// Borrar los arcos q me estan apuntado
		int aux = 0;
		boolean existe = false;
		for (int v : vertices.keySet()) {
			for (Arco<T> a : vertices.get(v)) {
				if(a.getVerticeDestino() == verticeId) {
					aux = a.getVerticeOrigen();
					existe = true;
				}
			}
			if (existe)
				this.borrarArco(aux, verticeId);
		}
		
		//Borrar el vertice (aca ya se borran mis arcos)
		cantidadArcos-= vertices.get(verticeId).size();
		vertices.remove(verticeId);
		cantidadVertices--;
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(vertices.containsKey(verticeId1)&&(vertices.containsKey(verticeId2))) {
			vertices.get(verticeId1).add(new Arco<>(verticeId1, verticeId2, etiqueta));
			//vertices.get(verticeId2).add(new Arco<>(verticeId1, verticeId2, etiqueta));	
			cantidadArcos++;
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (this.existeArco(verticeId1, verticeId2)) {
			ArrayList<Arco<T>> arcos = vertices.get(verticeId1);
			arcos.remove(this.obtenerArco(verticeId1, verticeId2));
			/*int i=0;
			while (i<arcos.size()) {
				if((arcos.get(i).getVerticeDestino()== verticeId2));//Redefinir equals en Arco
					arcos.remove(i); //Chequear complejidad remove si hace un recorrido o si es lineal
				i++;
			}*/
			/*for (Arco<T> a : arcos) {
				if(a.getVerticeDestino() == verticeId2) {
					arcos.remove(a);
				}	
			}*/
			cantidadArcos--;
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (this.contieneVertice(verticeId1) && (this.contieneVertice(verticeId2))) {
			ArrayList<Arco<T>> arcos = vertices.get(verticeId1);
			if (!arcos.isEmpty()) {
				for (Arco <T> a : arcos) {
					if(a.getVerticeDestino()==verticeId2)
						return true;
				}
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (this.contieneVertice(verticeId1) && (this.contieneVertice(verticeId2))) {
			ArrayList<Arco<T>> arcos = vertices.get(verticeId1);
			if (!arcos.isEmpty()) {
				for (Arco <T> a : arcos) {
					if(a.getVerticeDestino()==verticeId2)
						return a;
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.cantidadVertices;
	}

	@Override
	public int cantidadArcos() {
		return this.cantidadArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		return null;
	}
	

	public String toString() {
		return this.vertices.toString() ;
	}
}