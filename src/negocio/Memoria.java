package negocio;

import java.util.ArrayList;

public class Memoria {

	private ArrayList<String> numeros;
	public float resultado;

	public Memoria() {
		numeros = new ArrayList<String>();
		resultado = 0;
	}

	public String getNumeros() {
		String resultado = "";

		for (String num : numeros) {
			resultado += "" + num;
		}
		return resultado;
	}

	public void setNumero(String numero) {

		if (numero.equals("="))
			calcular();
		else
			numeros.add(numero);
	}

	public void calcular() {
		String auxNumero = "";
		ArrayList<String> auxOperador = new ArrayList<String>();
		ArrayList<Float> valores = new ArrayList<Float>();
		

		for (int i = 0; i < numeros.size(); i++) {
			if (numeros.get(i) != "+" && numeros.get(i) != "-" && numeros.get(i) != "*" && numeros.get(i) != "/" && numeros.get(i) != "=")
				auxNumero += numeros.get(i);

			else {
				auxOperador.add(numeros.get(i));
				valores.add((float) Integer.parseInt(auxNumero));
				auxNumero = "";
			}
		}
		valores.add((float) Integer.parseInt(auxNumero));

		
		for (int i = 0; i <= auxOperador.size()-1; i++) {
			
			if (i==0 && auxOperador.get(i)!="-") 
			resultado += valores.get(0);
			
			 if (auxOperador.get(i).equals("+")) 
				resultado += valores.get(i+1);

			else if (auxOperador.get(i).equals("-"))
				resultado -= valores.get(i+1);
			
			else if (auxOperador.get(i).equals("*"))
				resultado *= valores.get(i+1);
			
			else if (auxOperador.get(i).equals("/"))
				resultado = resultado/valores.get(i+1);
			
		}
	//	System.out.println(resultado);
	}
}
