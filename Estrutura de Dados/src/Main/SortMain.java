package Main;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import LDE.LDESemSentinelas;
import Lista.ILista;
import Models.ListaOrdenadaViewModel;
import Sort.Radix;
import Util.ArquivoManager;

public class SortMain {

	
	private static ILista<Integer> users = new LDESemSentinelas<Integer>();
	
	
	public static void main(String[] args) {
		
		users.add(1);
		users.add(584);
		users.add(23483);
		
		LDESemSentinelas<Integer> s = (LDESemSentinelas<Integer>) users.stream()
				.filter(u -> u > 400).collect(Collectors.toList());
		
		for (Integer string : users) {
			System.out.println(string);
		}
		final String ARQUIVO = "NumerosRandoms";
		
		//ArquivoManager.CriarArquivoNumerosRandons(ARQUIVO); //Gerar arquivo Txt com os numeros Randoms
		
		ListaOrdenadaViewModel model = new ListaOrdenadaViewModel();
		
		
		model.ListaOrdenada = ArquivoManager.LerArquivo(ARQUIVO + 1);
		model.PathDaListaLida = ARQUIVO + 1;
		
		
		System.out.println("Antes do Radix Sort: " + model.ListaOrdenada);
		
		Radix.Start(model);
		
		System.out.println("Depois do Radix Sort: " + model.ListaOrdenada);
	}
	

}
