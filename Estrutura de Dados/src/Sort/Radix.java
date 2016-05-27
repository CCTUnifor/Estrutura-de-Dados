package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import LDE.LDESemSentinelas;
import Lista.ILista;
import Models.ListaOrdenadaViewModel;

public class Radix implements ISort{
	private static List<Integer>[] vetor1;
	private static int maxDigitos;
	private static int currentDigitos = 1;
	
	static int index = 0;
	static int maiorLength;
	
	public void Start(ListaOrdenadaViewModel model){
		
		model.TipoDeSort = "Radix Sort";
		
		maxDigitos = digitos(model.ListaOrdenada);
		vetor1 = formatarLista(model.ListaOrdenada);
		
		while(maxDigitos != 0){
			vetor1 = formatarArray(vetor1);
			maxDigitos--;
			currentDigitos++;
		}
		
		Arrays.stream(vetor1).forEach(lista -> {
			lista.stream().forEach(number -> model.ListaOrdenada.set(index++, number));
		});
		
	}
	
	
	private static List<Integer>[] formatarLista(List<Integer> l){
		List<Integer>[] aux = new ArrayList[10];
		
		for (int i = 0; i < aux.length; i++) {
			aux[i] = new ArrayList<Integer>();
		}

		l.stream().forEach(number -> {
			aux[number % 10].add(number);
		});
		
		
		return aux;
	}
	
	private static List<Integer>[] formatarArray(List<Integer>[] vetor){
		List<Integer>[] aux = new ArrayList[10];
		
		for (int i = 0; i < aux.length; i++) {
			aux[i] = new ArrayList<Integer>();
		}
		
		Arrays.stream(vetor).forEach(lista -> {
			lista.stream().forEach(number -> aux[getDigito(number)].add(number));
		});
		
		return aux;
	}
	
	private static int digitos(List<Integer> l){
		maiorLength = Integer.toString(l.get(0)).length();
		
		l.stream().forEach(number -> {
			int lengthOfNumber = Integer.toString(number).length();
			if(lengthOfNumber > maiorLength){
				maiorLength = lengthOfNumber;
			}
		});
		
		return maiorLength;
	}
	
	private static int getDigito(int numero){
		int lengthNumber = Integer.toString(numero).length();
		
		if(lengthNumber <= currentDigitos){
			return 0;
		}
		for (int i = 0; i < currentDigitos; i++) {
			numero = numero/10;
		}
		String s = Integer.toString(numero);
		return Integer.parseInt(String.valueOf(s.charAt(s.length() - 1)));
	}
	
	
}
