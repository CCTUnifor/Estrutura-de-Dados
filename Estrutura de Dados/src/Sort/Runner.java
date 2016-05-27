package Sort;

import Models.ListaOrdenadaViewModel;

public class Runner implements Runnable{

	private ISort Tipo;
	private ListaOrdenadaViewModel Model;
	
	public Runner(ISort tipo, ListaOrdenadaViewModel model){
		Tipo = tipo;
		Model = model;
	}
	
	@Override
	public void run() {
		Tipo.Start(Model);
	}

}
