package Radix;

import LDE.LDESemSentinelas;
import Lista.ILista;
import Models.ListaOrdenadaViewModel;
import Util.ArquivoManager;
import Util.PerformanceTest;

public class Sort {
	private static ILista<Integer>[] vetor1;
	private static int maxDigitos;
	private static int currentDigitos = 1;
	private static int numeroPassos = 1;
	
	
	public static void Radix(ListaOrdenadaViewModel model){
		long inicioRadix = System.currentTimeMillis(); // Pega os milisegundos
		long memoryStart = PerformanceTest.getMemoryUsedNow();
		
		maxDigitos = digitos(model.ListaOrdenada);
		//maxDigitos = 3;
		vetor1 = formatarLista(model.ListaOrdenada);
		
		while(maxDigitos != 0){
			vetor1 = formatarArray(vetor1);
			maxDigitos--;
			currentDigitos++;
		}
		
		int index = 0;
		for (int i = 0; i < vetor1.length; i++) {
			for (int j = 0; j < vetor1[i].size(); j++) {
				model.ListaOrdenada.set(index, vetor1[i].get(j));
				index++;
			}
		}
		
		long memoryFinal = PerformanceTest.getMemoryUsedNow();
		long finalRadix = System.currentTimeMillis();
		
		model.TotalTime = finalRadix - inicioRadix;
		model.TotalMemoryUsed = memoryFinal - memoryStart;
		
		new ArquivoManager().CriarArquivoOrdenado(model);
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
	
	private static ILista<Integer>[] formatarArray(ILista<Integer>[] vetor){
		ILista<Integer>[] aux = new LDESemSentinelas[10];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = new LDESemSentinelas<Integer>();
		}
		
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor[i].size(); j++) {
				int flag = getDigito(vetor[i].get(j));
				aux[flag].add(vetor[i].get(j));
			}
		}
		
		return aux;
	}
	
	private static int digitos(ILista<Integer> l){
		int max = Integer.toString(l.get(0)).length();
		for (int i = 1; i < l.size(); i++) {
			int aux = Integer.toString(l.get(i)).length();
			if(aux > max){
				max = aux;
			}
		}
		return max;
	}
	
	private static int getDigito(int numero){
		int digitos = Integer.toString(numero).length();
		if(digitos <= currentDigitos){
			return 0;
		}
		for (int i = 0; i < currentDigitos; i++) {
			numero = numero/10;
		}
		String s = Integer.toString(numero);
		return Integer.parseInt(String.valueOf(s.charAt(s.length() - 1)));
		//return s.charAt(s.length() - 1);
	}
	
}
