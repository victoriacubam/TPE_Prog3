package tpe;

public class Arco<T> {

	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}
	
	public boolean equals(Arco<T> a) {
		return 	a.getEtiqueta() == this.getEtiqueta() && 
				a.getVerticeOrigen()==this.getVerticeOrigen() && 
				a.getVerticeDestino() == this.getVerticeDestino();
	}
	
	public String toString() {
		return "(" + this.verticeOrigen + "," + this.verticeDestino + ")";
	}
}
