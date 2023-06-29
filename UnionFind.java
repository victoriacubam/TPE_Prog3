package tpe;

import java.util.ArrayList;

public class UnionFind {
	
    private ArrayList<Integer> representantes;
	private int count;
	
	public UnionFind(int cantVertices) {//inicializo todos los vertices en -1, cada uno es un conjunto
		this.representantes = new ArrayList<>();
		for(int i = 0; i <= cantVertices; i++) {
			representantes.add(-1); //    [-1,-1,-1,-1]
		}                           // i=  0 , 1, 2, 3
		this.count = cantVertices;
	}

	public int count() {
		 return this.count;
	}
	 
	 
	 public void union(int i, int j) {
		this.representantes.set(i, j);
		this.count --;
		
	 }
	 
	 public int find(int i) {
		while(representantes.get(i) >= 0){ // Mientras que el representante de i no sea -1 
			i = representantes.get(i);
		}
		return i; // Retorno i o retorno null?
	}
	
}