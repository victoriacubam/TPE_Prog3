package tpe;


import java.util.Iterator;


public class Main {

	public static void main(String[] args) {
		
		GrafoDirigido<Integer> g = new GrafoDirigido<Integer>();
		
		g.agregarVertice(8);
		g.agregarVertice(7);
		g.agregarVertice(5);
		g.agregarVertice(4);
		g.agregarVertice(6);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(9);
		
		g.agregarArco(8, 5, null);
		g.agregarArco(8, 7, null);
		
		g.agregarArco(5, 7, null);
		g.agregarArco(5, 2, null);
		g.agregarArco(5, 3, null);
		
		g.agregarArco(7, 4, null);
		g.agregarArco(7, 5, null);
		g.agregarArco(7, 6, null);
		g.agregarArco(7, 8, null);
		
		g.agregarArco(2, 8, null);
		/*
		//System.out.println(g);
		//System.out.println(g.cantidadArcos());
		//System.out.println(g.cantidadVertices());
		//g.borrarArco(5, 2);
		//System.out.println(g);
		//g.borrarVertice(4);
		System.out.println(g);
		g.borrarVertice(7);
		System.out.println(g);
		System.out.println(g.cantidadArcos());
		System.out.println(g.cantidadVertices());
		*/
		System.out.println("Adyacentes");
		Iterator<Integer> i = g.obtenerAdyacentes(5);
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("Vertices");
		Iterator<Integer> e = g.obtenerVertices();
		while(e.hasNext()) {
			System.out.println(e.next());
		}
		
		ServicioDFS dfs = new ServicioDFS(g);
		System.out.println(dfs.dfsForest());
	}


}
