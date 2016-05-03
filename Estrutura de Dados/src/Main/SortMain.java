package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import GravarArquivo.ArquivoManager;
import LDE.LDESemSentinelas;
import Lista.ILista;
import Models.ListaOrdenadaViewModel;
import Radix.Sort;

public class SortMain {


	
	
	public static void main(String[] args) {
		
		final String ARQUIVO = "NumerosRandoms";
		
		//ArquivoManager.CriarArquivoNumerosRandons(ARQUIVO); //Gerar arquivo Txt com os numeros Randoms
		
		ListaOrdenadaViewModel model = new ListaOrdenadaViewModel();
		
		
		model.ListaOrdenada = new ArquivoManager().LerArquivo(ARQUIVO + 0);
		model.PathDaListaLida = ARQUIVO + 0;
		
		
		System.out.println("Antes do Radix Sort: " + model.ListaOrdenada);
		
		Sort.Radix(model);
		
		System.out.println("Depois do Radix Sort: " + model.ListaOrdenada);
	}
	

}
