package Main;

import Models.ListaOrdenadaViewModel;
import Sort.HybridSort;
import Sort.JavaSort;
import Sort.Quick;
import Sort.Radix;
import Sort.Selection;
import Util.ArquivoManager;
import Util.PerformanceTest;

public class SortMain {

	
	public static void main(String[] args) {
		
		System.out.println("Ordenando...");
		
		// Configurando o espa�o de Memoria Usado e o Tempo
			long inicioRadix = System.currentTimeMillis(); // Milisegundos now
			long memoryStart = PerformanceTest.getMemoryUsedNow(); // Mem�ria usada now
		
		ListaOrdenadaViewModel model = new ListaOrdenadaViewModel();

		final String ARQUIVO = "NumerosRandoms";
		
		//ArquivoManager.CriarArquivoNumerosRandons(ARQUIVO); //Gerar arquivo Txt com os numeros Randoms
		
		model.ListaOrdenada = ArquivoManager.LerArquivo(ARQUIVO + 1);
		model.PathDaListaLida = ARQUIVO + 1;
		
		
		//new Radix().Start(model);
		//new JavaSort().Start(model);
		//new Selection().Start(model);
		//new Quick().ordenar(model);
		new HybridSort().Start(model);
		
		// Terminando de Configurar o espa�o de Memoria Usado e o Tempo
			long memoryFinal = PerformanceTest.getMemoryUsedNow();
			long finalRadix = System.currentTimeMillis();
			
			model.TotalTime = finalRadix - inicioRadix;
			model.TotalMemoryUsed = memoryFinal - memoryStart;
		
		// Gerando o Arquivo com os n�meros ordenados
			new ArquivoManager().CriarArquivoOrdenado(model);
			
		System.out.println("Ordenado!");
		
	}
	

}
