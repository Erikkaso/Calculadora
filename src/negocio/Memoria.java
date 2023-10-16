package negocio;

import java.util.ArrayList;

public class Memoria {

	private ArrayList<String> numeros;

	public Memoria() {
		numeros = new ArrayList<String>();
	}

	public String getNumeros() {
		String resultado = "";

		for (String num : numeros) {
			resultado += ""+ num;
		}
		return resultado;
	}
	
	
	public void setNumero(String numero) {
		
		if(numero.equals("="))
			calcular();
		else
		numeros.add(numero);
	}
	
	public void calcular() {
		String auxNumero="";
		ArrayList<String> auxOperador = new ArrayList<String>();
		ArrayList<Float> valores = new ArrayList<Float>();
		int j=0;
		float resultado=0;
		
		for (int i=0; i<numeros.size();i++) {
			if(numeros.get(i) != "+" && numeros.get(i) != "-" && numeros.get(i) != "*" && numeros.get(i) != "/" && numeros.get(i) != "=")
				auxNumero +=numeros.get(i);
			
			else {
				auxOperador.add(numeros.get(i));
				valores.add((float)Integer.parseInt(auxNumero)); 	
				auxNumero="";
				System.out.println("aaa"+valores);
			}
		}
		for (String operador : auxOperador) {
			if(operador.equals("+")) {
				System.out.println("tam "+valores.size());
				resultado = (float)valores.get(0) + valores.get(1);
			}
		}
		System.out.println(resultado);
	}
}
