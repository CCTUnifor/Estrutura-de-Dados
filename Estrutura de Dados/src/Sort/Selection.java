package Sort;


import Models.ListaOrdenadaViewModel;

public class Selection implements ISort{
	static int menor;
	static int indiceMenor;
	static int i = 0;
	//static int j = 0;
	
	public void Start(ListaOrdenadaViewModel model){
		model.TipoDeSort = "Selection Sort";
		
		model.ListaOrdenada.stream().forEach(first -> {
			menor = first;
			indiceMenor = i;
			for (int j = i + 1; j < model.ListaOrdenada.size(); j++) {
				if(model.ListaOrdenada.get(j) < menor){
					menor = model.ListaOrdenada.get(j);
					indiceMenor = j;
				}
				j++;
			}
			i++;
		});
		
		/*for (int i = 0; i < model.ListaOrdenada.size(); i++) {
			menor = model.ListaOrdenada.get(i);
			indiceMenor = i;
			
			for (int j = i + 1; j < model.ListaOrdenada.size(); j++) {
				if(model.ListaOrdenada.get(j) < menor){
					menor = model.ListaOrdenada.get(j);
					indiceMenor = j;
				}
			}
			
			model.ListaOrdenada.set(indiceMenor, model.ListaOrdenada.get(i));
			model.ListaOrdenada.set(i, menor);
			
		}*/
	}
}
