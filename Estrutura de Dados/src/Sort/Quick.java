package Sort;

import java.util.List;
import java.util.stream.Collectors;

import LDE.LDESemSentinelas;
import Models.ListaOrdenadaViewModel;

public class Quick implements ISort{
	
	public void Start(ListaOrdenadaViewModel model) {
	    model.TipoDeSort = "Quick Sort";
		ordenar(model.ListaOrdenada, 0, model.ListaOrdenada.size());
	}

	   private static void ordenar(List<Integer> vetor, int inicio, int fim)
	   {
	      if (inicio < fim)
	      {
	         int posicaoPivo = separar(vetor, inicio, fim);
	         ordenar(vetor, inicio, posicaoPivo - 1);
	         ordenar(vetor, posicaoPivo + 1, fim);
	      }
	   }

	   private static int separar(List<Integer> vetor, int inicio, int fim)
	   {
	      int pivo = vetor.get(inicio);
	      int i = inicio, f = fim - 1;
	      while (i <= f)
	      {
	         if (vetor.get(i) <= pivo)
	            i++;
	         else if (pivo < vetor.get(f))
	            f--;
	         else
	         {
	            int troca = vetor.get(i);
	            vetor.set(i, vetor.get(f));
	            vetor.set(f, troca);
	            i++;
	            f--;
	         }
	      }
	      vetor.set(inicio, vetor.get(f));
	      vetor.set(f, pivo);
	      return f;
	   }
}
