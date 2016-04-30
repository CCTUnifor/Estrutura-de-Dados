package Radix;

import java.util.Random;

import GeradorRandom.RandomTxt;
import LDE.LDESemSentinelas;
import LSE.No;
import Lista.ILista;

public class Sort {
	static ILista<Integer>[] vetor1;
	static int maxDigitos;
	static int currentDig = 1;
	static int numeroPassos = 1;
	
	
	public static void Radix(LDESemSentinelas<Integer> lista){
		maxDigitos = digitos(lista) - 1;
		vetor1 = formatarLista(lista);
		//System.out.println("Passo numero " + numeroPassos +": " + vetor1);
		
		while(maxDigitos != 0){
			vetor1 = formatarArray(vetor1, currentDig);
			//System.out.println("Passo numero " + numeroPassos +": " + vetor1);
			maxDigitos--;
			currentDig++;
			//grau++;
		}
		lista.removeAll();
		
		for (int i = 0; i < vetor1.length; i++) {
			for (int j = 0; j < vetor1[i].size(); j++) {
				lista.add(vetor1[i].get(j));
			}
		}
		new RandomTxt().GerarOrdenado(lista);
	}
	
	private static ILista<Integer>[] formatarLista(ILista<Integer> l){
		ILista<Integer>[] aux = new LDESemSentinelas[10];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = new LDESemSentinelas<Integer>();
		}
		int i = 0;
		while(i < l.size()){
			int flag = (l.get(i) % 10);
			aux[flag].add(l.get(i));
			i++;
		}
		
		return aux;
	}
	
	private static ILista<Integer>[] formatarArray(ILista<Integer>[] vetor, int grau){
		ILista<Integer>[] aux = new LDESemSentinelas[10];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = new LDESemSentinelas<Integer>();
		}
		
		//int flag = vetor1[i].get(j)/10;
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor[i].size(); j++) {
				
				int flag = getDigito(vetor[i].get(j), grau);
				
				//int flag = Integer.toString(vetor[i].get(j) % grau).charAt(0);
				aux[flag].add(vetor[i].get(j));
			}
		}
		
		return aux;
	}
	
	private static int digitos(LDESemSentinelas<Integer> l){
		int max = Integer.toString(l.get(0)).length();
		for (int i = 1; i < l.size(); i++) {
			int aux = Integer.toString(l.get(i)).length();
			if(aux > max){
				max = aux;
			}
		}
		return max;
	}
	
	private static int getDigito(int numero, int grau){
		int dig = Integer.toString(numero).length();
		if(dig <= currentDig){
			return 0;
		}
		for (int i = 0; i < grau; i++) {
			numero = numero/10;
		}
		String s = Integer.toString(numero);
		return Integer.parseInt(String.valueOf(s.charAt(s.length() - 1)));
		//return s.charAt(s.length() - 1);
	}
	
}
