package tpe;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		GrafoDirigido<Integer> g1 = new GrafoDirigido<Integer>();
		
		g1.agregarVertice(8);
		g1.agregarVertice(7);
		g1.agregarVertice(5);
		g1.agregarVertice(4);
		g1.agregarVertice(6);
		g1.agregarVertice(2);
		g1.agregarVertice(3);
		g1.agregarVertice(9);
		
		g1.agregarArco(8, 5, null);
		g1.agregarArco(8, 7, null);
		
		g1.agregarArco(5, 7, null);
		g1.agregarArco(5, 2, null);
		g1.agregarArco(5, 3, null);
		
		g1.agregarArco(7, 4, null);
		g1.agregarArco(7, 6, null);
		g1.agregarArco(7, 5, null);
		
		g1.agregarArco(2, 4, null);
		
		
		GrafoDirigido<Integer> g2 = new GrafoDirigido<Integer>();
		g2.agregarVertice(1);
		g2.agregarVertice(2);
		g2.agregarVertice(3);
		g2.agregarVertice(4);
		g2.agregarVertice(5);
		g2.agregarVertice(6);
		g2.agregarVertice(7);
		
		g2.agregarArco(1, 2, null);
		g2.agregarArco(1, 3, null);
		g2.agregarArco(3, 5, null);
		g2.agregarArco(2, 4, null);
		g2.agregarArco(5, 4, null);
		g2.agregarArco(4, 1, null);
		g2.agregarArco(4, 6, null);
		g2.agregarArco(4, 7, null);
		
		System.out.println("Grafo 1: Servicio DFS: ");
		ServicioDFS dfs = new ServicioDFS(g1);
		System.out.println(dfs.dfsForest());
		
		System.out.println("Grafo 2: Servicio BFS: ");
		ServicioBFS bfs = new ServicioBFS(g2);
		System.out.println(bfs.bfsForest());
		
		System.out.println("Grafo 1: Servicio caminos, con origen 8 y destino 4 y limite 4: ");
		ServicioCaminos caminos = new ServicioCaminos(g1,8,4,5);
		System.out.println(caminos.caminos());
		
		System.out.println("Grafo 1: Cantidad de arcos: " + g1.cantidadArcos());
		System.out.println("Grafo 1: Cantidad de vertices: " + g1.cantidadVertices());
		
		System.out.println("Grafo 1: Adyacentes de: 5");
		Iterator<Integer> i1 = g1.obtenerAdyacentes(5);
		while(i1.hasNext()) {
			System.out.println(i1.next());
		}
		
		g1.borrarArco(5, 2);
		
		System.out.println("Grafo 1: Adyacentes de: 5 luego de eliminar el arco entre 5 y 2");
		Iterator<Integer> i2 = g1.obtenerAdyacentes(5);
		while(i2.hasNext()) {
			System.out.println(i2.next());
		}
		
		System.out.println("Grafo 1: Vertices: ");
		Iterator<Integer> i3 = g1.obtenerVertices();
		while(i3.hasNext()) {
			System.out.println(i3.next());
		}
		
		g1.borrarVertice(4);
		
		System.out.println("Grafo 1: Vertices despues de eliminar el vertice 4: ");
		Iterator<Integer> i4 = g1.obtenerVertices();
		while(i4.hasNext()) {
			System.out.println(i4.next());
		}
	}


}
