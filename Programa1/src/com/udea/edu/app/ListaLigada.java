package com.udea.edu.app;

/**
 * Colecci�n de objetos enlazados entre si.
 * @author Fernando Sanabria
 * */

public class ListaLigada {
	private Nodo primerNodo;
	private Nodo ultimoNodo;
	private int tama�oLista;
	
	public ListaLigada(){
		this.primerNodo=null;
		this.ultimoNodo=null;
		this.tama�oLista=0;
	}

	public Nodo getPrimerNodo() {
		return primerNodo;
	}

	public void setPrimerNodo(Nodo primerNodo) {
		this.primerNodo = primerNodo;
	}

	public Nodo getUltimoNodo() {
		return ultimoNodo;
	}

	public void setUltimoNodo(Nodo ultimoNodo) {
		this.ultimoNodo = ultimoNodo;
	}

	public int getTama�oLista() {
		return tama�oLista;
	}

	public void setTama�oLista(int tama�oLista) {
		this.tama�oLista = tama�oLista;
	}
	
	public boolean esVacia(){
		return(this.primerNodo==null);
	}
	
	public ListaLigada insertarNodo(Object o){
		Nodo nuevoNodo = new Nodo(o);
		if(esVacia())
		{
			primerNodo=nuevoNodo;
			ultimoNodo=nuevoNodo;
		}else{
			ultimoNodo.setSigNodo(nuevoNodo);
			ultimoNodo=nuevoNodo;
		}
		this.tama�oLista++;
		return this;
	}
	
	public Nodo eliminarUltimoNodo() {
		Nodo eliminar =null;
		if(esVacia()){
			return null;
		}
		if(primerNodo == ultimoNodo){
			primerNodo=null;
			ultimoNodo=null;
		}
		else{
			Nodo actual = primerNodo;
			while(actual.getSigNodo()!= ultimoNodo){
				actual = actual.getSigNodo();
			}
			eliminar = actual.getSigNodo();
			actual.setSigNodo(null);
			ultimoNodo=actual;

			
		}
		this.tama�oLista--;
		return eliminar;
	}

}
