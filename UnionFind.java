package tpe;

import java.util.ArrayList;

public class UnionFind {
	private ArrayList<Integer> representantes;
	private int count;
	
	public UnionFind(int cantVertices) {
		 this.representantes = new ArrayList<>();
		 
		 for(int i = 0; i < cantVertices; i++) {
			 representantes.add(i, i); // Con cantVertices = 4 ---> [0,1,2,3]
		 }
		 
		 System.out.println("representantes: "+ representantes);
		 
		 this.count = cantVertices;
	 }

	 public int count() {
		 return this.count;
	 }
	 
	 
	 public void union(int i, int j) {
		 int repI = this.find(i);
		 int repJ = this.find(j);
		 
		 if(repI != repJ) {
			 this.representantes.set(repI, repJ);
		 }
		 //System.out.println("representantes: "+ representantes);
		 this.count --;
		 //System.out.println("union"+vertices);
	 }
	 
	 public int find(int i) {
		 if(i == representantes.get(i)) {
			 return i;
		 }
		 int aux = this.find(representantes.get(i));
		 //System.out.println("ver:"+ representantes.set(i, aux));
		 return representantes.set(i, aux); // retorna el valor viejo?
	 }
	
}