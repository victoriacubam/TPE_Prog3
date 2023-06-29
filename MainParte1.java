package tpe;

import java.util.Iterator;

public class MainParte1 {

	public static void main(String[] args) {
		
		// PARTE 1
		
		GrafoDirigido<Integer> gD1 = new GrafoDirigido<Integer>();
		
		gD1.agregarVertice(8);
		gD1.agregarVertice(7);
		gD1.agregarVertice(5);
		gD1.agregarVertice(4);
		gD1.agregarVertice(6);
		gD1.agregarVertice(2);
		gD1.agregarVertice(3);
		gD1.agregarVertice(9);
		
		gD1.agregarArco(8, 5, null);
		gD1.agregarArco(8, 7, null);
		
		gD1.agregarArco(5, 7, null);
		gD1.agregarArco(5, 2, null);
		gD1.agregarArco(5, 3, null);
		
		gD1.agregarArco(7, 4, null);
		gD1.agregarArco(7, 6, null);
		gD1.agregarArco(7, 5, null);
		
		gD1.agregarArco(2, 4, null);
		
		
		GrafoDirigido<Integer> gD2 = new GrafoDirigido<Integer>();
		gD2.agregarVertice(1);
		gD2.agregarVertice(2);
		gD2.agregarVertice(3);
		gD2.agregarVertice(4);
		gD2.agregarVertice(5);
		gD2.agregarVertice(6);
		gD2.agregarVertice(7);
		
		gD2.agregarArco(1, 2, null);
		gD2.agregarArco(1, 3, null);
		gD2.agregarArco(3, 5, null);
		gD2.agregarArco(2, 4, null);
		gD2.agregarArco(5, 4, null);
		gD2.agregarArco(4, 1, null);
		gD2.agregarArco(4, 6, null);
		gD2.agregarArco(4, 7, null);
		
		System.out.println("Grafo 1: Servicio DFS: ");
		ServicioDFS dfs = new ServicioDFS(gD1);
		System.out.println(dfs.dfsForest());
		
		System.out.println("Grafo 2: Servicio BFS: ");
		ServicioBFS bfs = new ServicioBFS(gD2);
		System.out.println(bfs.bfsForest());
		
		System.out.println("Grafo 1: Servicio caminos, con origen 8 y destino 4 y limite 4: ");
		ServicioCaminos caminos = new ServicioCaminos(gD1,8,4,5);
		System.out.println(caminos.caminos());
		
		System.out.println("Grafo 1: Cantidad de arcos: " + gD1.cantidadArcos());
		System.out.println("Grafo 1: Cantidad de vertices: " + gD1.cantidadVertices());
		
		System.out.println("Grafo 1: Adyacentes de: 5");
		Iterator<Integer> itergD1 = gD1.obtenerAdyacentes(5);
		while(itergD1.hasNext()) {
			System.out.println(itergD1.next());
		}
		
		gD1.borrarArco(5, 2);
		
		System.out.println("Grafo 1: Adyacentes de: 5 luego de eliminar el arco entre 5 y 2");
		Iterator<Integer> iterGD2 = gD1.obtenerAdyacentes(5);
		while(iterGD2.hasNext()) {
			System.out.println(iterGD2.next());
		}
		
		System.out.println("Grafo 1: Vertices: ");
		Iterator<Integer> i3 = gD1.obtenerVertices();
		while(i3.hasNext()) {
			System.out.println(i3.next());
		}
		
		gD1.borrarVertice(4);
		
		System.out.println("Grafo 1: Vertices despues de eliminar el vertice 4: ");
		Iterator<Integer> i4 = gD1.obtenerVertices();
		while(i4.hasNext()) {
			System.out.println(i4.next());
		}
		
	}


}
