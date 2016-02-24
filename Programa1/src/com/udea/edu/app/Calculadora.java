package com.udea.edu.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.StringTokenizer;

public class Calculadora {
	private ListaLigada lista;
	private double media;
	private double desviacionEstandar;
	
	public ListaLigada getLista() {
		return lista;
	}
	public void setLista(ListaLigada lista) {
		this.lista = lista;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public double getDesviacionEstandar() {
		return desviacionEstandar;
	}
	public void setDesviacionEstandar(double desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}
	
	public void leerArchivo(String nombreArchivo) throws IOException{
		this.lista =new ListaLigada();
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo)); 
		String linea = br.readLine();
		while( linea  != null) {
			StringTokenizer token = new StringTokenizer(linea, ";"); 
			String numero;
		while(token.hasMoreTokens() ){
			numero = token.nextToken();
			this.lista.insertarNodo(Double.parseDouble(numero));
		}
		
		 linea = br.readLine();
		} 	
		br.close();
	}
	
	public double calcularMedia() {
		Double mediaAux=0.0;
		Nodo aux = lista.getPrimerNodo();
		
		mediaAux = mediaAux + (Double)aux.getDato();
		while(aux.getSigNodo() != null){
			aux = aux.getSigNodo();
			mediaAux = mediaAux + (Double)aux.getDato();
		}
		
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		DecimalFormat f = new DecimalFormat(".##",simbolos);
		String resultado = f.format(mediaAux/lista.getTamañoLista());
		this.media = Double.parseDouble(resultado);
		return Double.parseDouble(resultado);
	}
	
	public double calcularDesviacion(){
		
		double numerador = 0.0;
		double denominador = lista.getTamañoLista()-1;
		double auxiliar;
		double media = this.calcularMedia();
		Nodo aux = lista.getPrimerNodo();
		
		auxiliar = Math.pow((Double)aux.getDato()-media,2);
		numerador = numerador+auxiliar;
	
		while(aux.getSigNodo() != null){
			aux = aux.getSigNodo();
			auxiliar = Math.pow((Double)aux.getDato()-media,2);
			numerador = numerador+auxiliar;
		}
		
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		DecimalFormat f = new DecimalFormat(".##",simbolos);
		String resultado = f.format(Math.sqrt(numerador/denominador));
		this.desviacionEstandar=Double.parseDouble(resultado);
		
		return Double.parseDouble(resultado);
	}
}
