package com.udea.edu.test;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Test;
import com.udea.edu.app.Calculadora;
import com.udea.edu.app.ListaLigada;


public class CalculadoraTest {
	Calculadora cal = new Calculadora();
	@Test
	public void LeerArchivoTest() throws IOException {
	
		
		int tama�oEsperado = 10;
		int tama�oResultado;
		
		cal.leerArchivo("DevelopmentHours");
		ListaLigada lista = cal.getLista();
		tama�oEsperado = 10;
		tama�oResultado = lista.getTama�oLista();
		assertEquals(tama�oEsperado, tama�oResultado);
	}

	@Test
	public void calcularMediaTest() throws IOException {
		
		
		cal.leerArchivo("DevelopmentHours");
		Double mediaEsperada = 60.32;
		Double mediaResultado= cal.calcularMedia();
		assertEquals(mediaEsperada, mediaResultado);
	}
	
	@Test
	public void calcularDesviacionTest() throws IOException {
		
		
		cal.leerArchivo("DevelopmentHours");
		Double desviacionEsperada = 62.26;
		Double desviacionResultado= cal.calcularDesviacion();
		assertEquals(desviacionEsperada, desviacionResultado);
	}
	
	
	
}
