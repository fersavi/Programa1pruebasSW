package com.udea.edu.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.udea.edu.app.Nodo;

public class NodoTest {

	@Test
	public void testCrearNodo() {
		Object esperado = 5;
		Object resultado;
		Nodo nuevoNodo = new Nodo(5);
		resultado = nuevoNodo.getDato();
		
		assertEquals(esperado, resultado);
	}

}
