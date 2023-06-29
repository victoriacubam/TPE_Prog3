package tpe;

import java.util.ArrayList;
import java.util.Iterator;

public class Backtracking {
    private ArrayList<Arco<Integer>> solucion;
	private ArrayList<Arco<Integer>> arcos;
	private int mejorKM;
	private int metrica; // Las entradas que genera
	

	public Backtracking(int limiteGreedy) {
		this.arcos = new ArrayList<>();
		this.solucion = new ArrayList<>();
		this.mejorKM = limiteGreedy;
		this.metrica = 0;
	}
	
	public int getMejorKM() {
		return mejorKM;
	}
	
	public int getMetrica() {
		return metrica;
	}
	
	public ArrayList<Arco<Integer>> backtracking(GrafoDirigido<Integer>g){
		this.arcos = obtenerArcos(g);
		int sumaParcial = 0;
		ArrayList<Arco<Integer>> solucionParcial = new ArrayList<>();
		backtracking(solucionParcial, g, arcos, sumaParcial);
		return solucion;
	}		
	
	private void backtracking(ArrayList<Arco<Integer>> solucionParcial, GrafoDirigido<Integer> g, ArrayList<Arco<Integer>> arcos, int sumaParcial) {
		metrica++; //Veces que llamo a esta funcion
		// Condicion de corte
		if (arcos.isEmpty()|| (solucionParcial.size()==g.cantidadVertices()-1)) { //Si ya me quede sin arcos
            if(!solucionParcial.isEmpty()){ //Si tengo una solucion parcial
                if(this.esConexo(g, solucionParcial)){//chequeo sea conexo
                    if(sumaParcial <= this.mejorKM) {
                        this.mejorKM = sumaParcial;
                        this.solucion.clear();
                    	this.solucion.addAll(solucionParcial); //Mi solucion ahora es solucionParcial porque es mejor
                    } 
                }
            }
        } else { //tengo mas arcos
    		
			//LLAMADA A BACK 
        	Arco<Integer> arco = arcos.get(0);
			arcos.remove(arco);
			
			solucionParcial.add(arco);
			sumaParcial += arco.getEtiqueta();
				
			//PODA
			if(sumaParcial <= mejorKM){
				backtracking(solucionParcial, g, arcos, sumaParcial);
			}
				
			solucionParcial.remove(arco);
			sumaParcial -= arco.getEtiqueta();
			
			//PODA
			if(sumaParcial <= mejorKM){
				backtracking(solucionParcial, g, arcos, sumaParcial);
			}
			arcos.add(0, arco); //Lo vuelvo a agregar
        }
		
	}		

	public String mostrarEstaciones(ArrayList<Arco<Integer>> solucion){
		String estaciones = "";
		if(solucion!=null) {
			for(Arco<Integer> e: solucion){
				estaciones += "E"+e.getVerticeOrigen() +"-"+"E"+e.getVerticeDestino()+", ";
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
			return distanciaTotal;			
		}
		return -1;
	}
	
	public ArrayList<Arco<Integer>> obtenerArcos(GrafoDirigido<Integer> grafo){
		ArrayList<Arco<Integer>> arcos = new ArrayList<>();
		Iterator<Arco<Integer>> it = grafo.obtenerArcos();
		while(it.hasNext()){
			Arco<Integer> arco = it.next();
			arcos.add(arco);
		}
		return arcos;
	}
	
	public boolean esConexo(Grafo<Integer> grafo, ArrayList<Arco<Integer>> solucionParcial) {
		UnionFind componentes = new UnionFind(grafo.cantidadVertices());
		ArrayList<Integer> vertices = this.obtenerVertices(grafo);
		for(Arco<Integer> a: solucionParcial){
			int o = a.getVerticeOrigen();
			int d = a.getVerticeDestino();
			int representanteO = componentes.find(vertices.indexOf(o)); 
			int representanteD = componentes.find(vertices.indexOf(d));
			if(representanteO != representanteD) {
				componentes.union(representanteO, representanteD);
			}
		}
		return componentes.count() == 1; //Si solo queda un conjunto significa que es conexo, si queda <1 conjunto quiere decir que hay vertices que no pueden unirse
	}
	
	private ArrayList<Integer> obtenerVertices(Grafo<Integer> grafo){
		ArrayList<Integer> vertices = new ArrayList<>();
		Iterator<Integer> it = grafo.obtenerVertices();
		while(it.hasNext()){
			Integer v = it.next();
			if(!vertices.contains(v)){
				vertices.add(v);
			}
		}
		return vertices;
	}	 
	
}