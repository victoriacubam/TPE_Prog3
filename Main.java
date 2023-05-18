package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		GrafoDirigido<Integer> g = new GrafoDirigido<>();
		
		g.agregarVertice(8);
		g.agregarVertice(7);
		g.agregarVertice(5);
		g.agregarVertice(4);
		g.agregarVertice(6);
		g.agregarVertice(2);
		g.agregarVertice(3);
		
		g.agregarArco(8, 5, null);
		g.agregarArco(8, 7, null);
		
		g.agregarArco(5, 7, null);
		g.agregarArco(5, 2, null);
		g.agregarArco(5, 3, null);
		
		g.agregarArco(7, 4, null);
		g.agregarArco(7, 6, null);
		g.agregarArco(7, 8, null);
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
		g.obtenerVertices();
	}


}
