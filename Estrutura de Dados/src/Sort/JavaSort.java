package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Models.ListaOrdenadaViewModel;

public class JavaSort implements ISort{
	public void Start(ListaOrdenadaViewModel model){
		model.TipoDeSort = "Java Sort";
		
		List<Integer> lista = new ArrayList<Integer>();
		
		for (Integer number : model.ListaOrdenada) {
			lista.add(number);
		}
		
		Collections.sort(lista);
	}
}
