package com.udea.edu.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.udea.edu.app.ListaLigada;
import com.udea.edu.app.Nodo;

public class ListaTest {

	
	public void insertTest() {
		ListaLigada lista = new ListaLigada();
		Nodo resultado;
		Object dato = 234;
		lista.insertarNodo(dato);
		resultado = lista.getPrimerNodo();
		assertNotEquals(null, resultado);
	}
	

	public void esVaciaTest() {
		ListaLigada lista = new ListaLigada();
		Boolean resultado;
		Boolean esperado = true;
		resultado = lista.esVacia();
		assertEquals(esperado, resultado);
	}
	

	public void noEsVaciaTest() {
		ListaLigada lista = new ListaLigada();
		Boolean resultado;
		Boolean esperado = false;
		Object dato = 234;
		lista.insertarNodo(dato);
		resultado = lista.esVacia();
		assertEquals(esperado, resultado);
	}
	
	public void eliminarTest() {
		ListaLigada lista = new ListaLigada();
		int tama�oEsperado =1;
		int resultado;
		Object dato = 234;
		lista.insertarNodo(dato);
		dato = 456;
		lista.insertarNodo(dato);
		lista.eliminarUltimoNodo();
		resultado = lista.getTama�oLista();
		
		assertEquals(tama�oEsperado, resultado);
	}
	@Test
	public void tama�oTest() {
		ListaLigada lista = new ListaLigada();
		int tama�oEsperado =2;
		int resultado;
		Object dato = 234;
		lista.insertarNodo(dato);
		dato = 456;
		lista.insertarNodo(dato);
		resultado = lista.getTama�oLista();
		
		assertEquals(tama�oEsperado, resultado);
	}
}
