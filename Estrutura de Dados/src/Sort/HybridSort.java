package Sort;

import java.util.ArrayList;
import java.util.List;

import Models.ListaOrdenadaViewModel;

public class HybridSort implements ISort{
	
	public void Start(ListaOrdenadaViewModel model){
		model.TipoDeSort = "Hybrid Sort";
		
		if(model.ListaOrdenada.size() > 5000){
			int lengthFor = model.ListaOrdenada.size() % 7; // decidi esse numero
			int quantidadeParaCadaParte = model.ListaOrdenada.size() / lengthFor;
			List<Integer> listaOrdenadaPorParte = new ArrayList<Integer>();
			
			for(int i = 0; i < lengthFor; i++ ){
				ListaOrdenadaViewModel aux = new ListaOrdenadaViewModel();
				
				for (int j = quantidadeParaCadaParte * i; j < quantidadeParaCadaParte * (i+1); j++) {
					listaOrdenadaPorParte.add(model.ListaOrdenada.get(j));
				}
				
				aux.ListaOrdenada = listaOrdenadaPorParte;
				
				switch (i) {
					case 0:
						ISort radix = new Radix();
						Runner r0 = new Runner(radix, aux);
						new Thread(r0).start();
						break;
					case 1:
						ISort selection = new Selection();
						Runner r1 = new Runner(selection, aux);
						new Thread(r1).start();
						break;
						
					case 2:
						ISort quick = new Quick();
						Runner r2 = new Runner(quick, aux);
						new Thread(r2).start();
						break;
						
					case 3:
						ISort javaSort = new JavaSort();
						Runner r3 = new Runner(javaSort, aux);
						new Thread(r3).start();
						break;
	
					default:
						ISort radix2 = new JavaSort();
						Runner r4 = new Runner(radix2, aux);
						new Thread(r4).start();
						break;
				}
			}
			
			model.ListaOrdenada = listaOrdenadaPorParte;
			new Quick().Start(model);
		}

	}
}
