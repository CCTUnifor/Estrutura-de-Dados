package Main;

import Models.ListaOrdenadaViewModel;
import Radix.Sort;
import Util.ArquivoManager;

public class SortMain {

	public static void main(String[] args) {
		
		
		final String ARQUIVO = "NumerosRandoms";
		
		//ArquivoManager.CriarArquivoNumerosRandons(ARQUIVO); //Gerar arquivo Txt com os numeros Randoms
		
		ListaOrdenadaViewModel model = new ListaOrdenadaViewModel();
		
		
		model.ListaOrdenada = ArquivoManager.LerArquivo(ARQUIVO + 1);
		model.PathDaListaLida = ARQUIVO + 1;
		
		
		System.out.println("Antes do Radix Sort: " + model.ListaOrdenada);
		
		Sort.Radix(model);
		
		System.out.println("Depois do Radix Sort: " + model.ListaOrdenada);
	}
	

}
