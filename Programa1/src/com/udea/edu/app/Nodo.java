package com.udea.edu.app;
/**
 * Clase nodo, que contiene un campo para almacenar datos y
 * otro campo para indicar el nodo siguiente
 * @author Fernando Sanabria
 * */
public class Nodo {
	private Object dato;
	private Nodo sigNodo;
	
	public Nodo(Object o) {
		this.dato = o;
		this.sigNodo= null;
	}
	
	public void setDato(Object o){
		this.dato = o;
	}
	public void setSigNodo(Nodo n){
		this.sigNodo= n;
	}
	public  Object getDato (){
		return dato;
		
	}
	public Nodo getSigNodo(){
		return sigNodo;
	}
}
