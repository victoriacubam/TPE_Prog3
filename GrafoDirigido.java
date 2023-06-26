package tpe;

import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T>{
	
	private HashMap<Integer, ArrayList<Arco<T>>> vertices;
	
	private int cantidadVertices;
	private int cantidadArcos;
	
	/**
	 * Complejidad: O(1) ya que se supone una complejidad O(1) para el HashMap e inicializar dos variables de tipo entero tambien es O(1)
	 */
	public GrafoDirigido() {
		this.vertices = new HashMap<>();
		this.cantidadVertices = 0;
		this.cantidadArcos = 0;
	}
	
	/**
	* Complejidad: O(1) es constante, ya que consultar si contiene ese vertice es O(1) 
	* y agregarlo asumimos que es O(1) al ser un metodo de HashMap
	*/
	@Override
	public void agregarVertice(int verticeId) {
		if(!this.contieneVertice(verticeId)) {
			vertices.put(verticeId, new ArrayList<Arco<T>>());
			cantidadVertices++;			
		}
	}

	/**
	* Complejidad: O(n+m) donde n es la cantidad de vertices y m es la cantidad de arcos. Ya que al borrar un vertice se borran sus arcos asociados.
	*/
	@Override
	public void borrarVertice(int verticeId) {
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
		
		cantidadArcos-= vertices.get(verticeId).size();
		vertices.remove(verticeId);
		cantidadVertices--;
	}

	/**
	* Complejidad: O(n) ya que se supone una complejidad O(1) para los metodos de HashMap y O(n) con n como la cantidad de Arcos, ya que
	* en el peor de los casos recorreria todo el arraylist de arcos para chequear que no exista.
	*/
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if((vertices.containsKey(verticeId1)&&(vertices.containsKey(verticeId2)))) {
			if(!existeArco(verticeId1, verticeId2)) {
				vertices.get(verticeId1).add(new Arco<>(verticeId1, verticeId2, etiqueta));
				cantidadArcos++;				
			}
		}
	}

	/**
	* Complejidad: O(n) donde n es el tamaño del ArrayList de arcos debido a que 
	* en el peor de los casos encontraria (o no) el Arco al final de la lista.
	*/
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (this.existeArco(verticeId1, verticeId2)) {
			ArrayList<Arco<T>> arcos = vertices.get(verticeId1);
			arcos.remove(this.obtenerArco(verticeId1, verticeId2));
			cantidadArcos--;
		}
	}
	
	/**
	* Complejidad: O(1) es constante debido a que debe
	* acceder al HashMap para verificar si existe una clave especifica.
	*/
	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	/**
	* Complejidad: O(n) donde n es el tamaño del ArrayList de arcos del verticeId1 (origen) debido a que debe
	* recorrerlo hasta el ultimo elemento para verificar si existe un arco especifico entre el verticeId1 y el verticeId2.
	*/
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


	/**
	* Complejidad: O(n) donde n es el tamaño del ArrayList de arcos debido a que debe
	* buscar hasta la ultima posicion en el peor de los casos para encontrar el vertice destino.
	*/
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
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

	/**
	* Complejidad: O(1) debido a que es constante porque accede directamente
	* a la variable que va llevando la cuenta para retornar la cantidad de vertices.
	*/
	@Override
	public int cantidadVertices() {
		return this.cantidadVertices;
	}

	/**
	* Complejidad: O(1) debido a que es constante porque accede directamente
	* a la variable que va llevando la cuenta para retornar la cantidad de arcos.
	*/
	@Override
	public int cantidadArcos() {
		return this.cantidadArcos;
	}

	/**
	* Complejidad: O(1) ya que implementa un metodo de hashmap que asumimos O(1)
	*/
	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}
	
	/**
	* Complejidad: O(n) donde n es la cantidad de arcos que tiene el verticeId debido a que debe
	* recorrerlos para obtener cada vertice destino.
	*/
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Arco<T>> arcos = vertices.get(verticeId);
		if (arcos!=null && !arcos.isEmpty()) {
			ArrayList<Integer> aux = new ArrayList<>();
			for (Arco <T> a : arcos) {
				aux.add(a.getVerticeDestino());
			}
			return aux.iterator();
		}
		return null;
	}

	/**
	* Complejidad: O(n) donde n es la cantidad de elementos de nuestra estructura debido a que debe
	* recorrerlos a todos para obtener su valor (lista de arcos) y agregarlos al ArrayList auxiliar.
	*/
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		Set<Map.Entry<Integer, ArrayList<Arco<T>>>> lista = vertices.entrySet();
		if(!lista.isEmpty()) {
			ArrayList<Arco<T>> aux = new ArrayList<>();
			for (Map.Entry<Integer, ArrayList<Arco<T>>> l : lista)
				aux.addAll(l.getValue());		
			return aux.iterator();
		}
		return null;
	}

	/**
	* Complejidad: O(1) debido a que utiliza un metodo de HashMap que asumimos O(1)
	*/
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco<T>> arcos = vertices.get(verticeId);
		return arcos.iterator();
	}
	
	public void imprimirGrafo() {
		Iterator<Integer> it = this.obtenerVertices();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println("Vertice " + key + " --> Arcos: "+ vertices.get(key) );
		}
	}
	
	public void imprimirEtiquetaArco() {
		Iterator<Arco<T>> it = this.obtenerArcos();
		while(it.hasNext()) {
			Arco<T> key = it.next();
			System.out.println("Arco" + key + " --> etiqueta: "+key.getEtiqueta() );
		}
	}
	
	public String toString() {
		return this.vertices.toString() ;
	}
	
	public boolean isConexo() {
		UnionFind componentes = new UnionFind(this.cantidadVertices() - 1);
		Iterator<Arco<T>> it = this.obtenerArcos();
		if(it != null) {
			while(it.hasNext()) {
				Arco<T> arco = it.next();
				int u = arco.getVerticeOrigen();
				int v = arco.getVerticeDestino();
				int representanteU = componentes.find(u); 
				System.out.println("u:"+representanteU);
				int representanteV = componentes.find(v);
				System.out.println("v:"+representanteV);
				if(representanteU != representanteV) {
					componentes.union(representanteU, representanteV);
				}
			}
		}
		return componentes.count() == 1;
	}
	
	
	
}