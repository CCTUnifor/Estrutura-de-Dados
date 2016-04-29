package LSE;

public class Lista {

// a b c
// c b a
	public static No<String> criarListaString(String s) {
		No<String> inicio = null;
		for (int i = 0; i < s.length(); i++) {
			inicio = new No<String>(s.charAt(i) + "", inicio);
		}
		return inicio;
	}

	public static No<Integer> criarListaInt(String s) {
		No<Integer> inicio = null;
		for (int i = 0; i < s.length(); i++) {
			inicio = new No<Integer>(Integer.parseInt(s.charAt(i) + ""), inicio);
		}
		return inicio;
	}

	public void imprimir(No inicio) {
		No aux = inicio;

		while (aux != null) {
			System.out.print(aux.getElement() + " ");
			aux = aux.getNext();
		}
	}
	
	public static void imprimirContrario(No inicio){
		if(inicio != null && inicio.getNext() != null){
			imprimirContrario(inicio.getNext());
		}
		System.out.print(inicio.getElement() + " " );
	}

	public static int count(No inicio) {
		int i = 0;
		No aux = inicio;

		while (aux != null) {
			i++;
			aux = aux.getNext();
		}

		return i;
	}

	public static No clone(No inicio) {
		No clone = null;
		No aux = inicio;
		int size = count(inicio);
		
		clone = new No(aux.getElement(), null);
		aux = aux.getNext();
		for(int i = 0; i < size-1; i++){
			clone.setNext(new No(aux.getElement(), null));
		}
		/*while (aux != null) {
			clone = new No(aux.getElement(), clone);
			aux = aux.getNext();
		}*/

		return clone;
	}

	public static void circular(No inicio) {
		No start = inicio;
		while (inicio != null && inicio.getNext() != null) {
			inicio = inicio.getNext();
		}

		inicio.setNext(start);
	}

	public static void eliminaPares(No<Integer> inicio) {
		//1542792
		if(inicio.getElement() % 2 == 0){
			inicio = inicio.getNext();
		}
		while(inicio != null && inicio.getNext() != null){
			if(inicio.getNext().getElement() % 2 == 0 && inicio.getNext() != null){
				if (inicio.getNext().getNext() == null) {
					inicio.setNext(null);
				} else {
					inicio.setNext(inicio.getNext().getNext());
				}
			}else if(inicio.getNext() != null){
				inicio = inicio.getNext();
			}
		}
	}
	
	public static void inserirNoFinalStr(No<String> inicio, String s){
		while(inicio.getNext() != null){
			inicio = inicio.getNext();
		}
		inicio.setNext(new No<String>(s, null));
	}
	
	public static void inserirNoFinalInt(No<Integer> inicio, int i){
		while(inicio.getNext() != null){
			inicio = inicio.getNext();
		}
		inicio.setNext(new No<Integer>(i, null));
	}

	public static void inserirNoMeioStr(No<String> inicio, String s){
		//z i k a v u r u s s
		No<String> aux = inicio.getNext();
		while(aux != null && aux.getNext() != null){
			aux = aux.getNext().getNext();
			inicio = inicio.getNext();
		}
		inicio.setNext(new No<String>(s, inicio.getNext()));
	}
	
	public static void removerNoMeio(No inicio){
		No aux = inicio;
		while(aux != null && aux.getNext() != null){
			aux = aux.getNext().getNext().getNext();
			inicio = inicio.getNext();
		}
		inicio.setNext(inicio.getNext().getNext());
	}
	
	public static void inserir(No<Object> inicio, Object element, int position){
		if(position == 0){
			inicio = new No<Object>(element, inicio);
		}else{
			int count = 1;
			
			while(inicio != null){
				if(count == position){
					inicio.setNext(new No<Object>(element, inicio.getNext()));
				}
				inicio = inicio.getNext();
				count++;
			}
		}
	}
	
	public static void remover(No inicio, int position){
		if(position == 0){
			inicio = inicio.getNext();
		}else{
			int count = 1;
			
			while(inicio != null){
				if(count == position){
					inicio.setNext(inicio.getNext().getNext());
				}
				inicio = inicio.getNext();
				count++;
			}
		}
	}
	
	public static No intersecao(No n1, No n2){
		No intersecao = null;
		No aux2 = n2;

		while(n1 != null){
			n2 = aux2;
			while(n2 != null){
				if(n1.getElement().equals(n2.getElement())){
					intersecao = new No(n1.getElement(), intersecao);
				}
				n2 = n2.getNext();
			}
			n1 = n1.getNext();
		}
		return intersecao;
	}
	
	public static No uniao(No n1, No n2){
		No uniao = null;
		
		while(n1 != null){
			uniao = new No(n1.getElement(), uniao);
			n1 = n1.getNext();
		}
		while(n2 != null){
			uniao = new No(n2.getElement(), uniao);
			n2 = n2.getNext();
		}
		
		return uniao;
	}
	
	public static void removerRepetidos(No inicio){
		//zikaviruss
		Object[] repetidos = new Object[count(inicio)];
		
		int countRepetidos = 0;
		
		No auxInicio = null;
		while(inicio != null){
			auxInicio = inicio.getNext();
			while(auxInicio != null && auxInicio.getNext() != null){
				if(inicio.getNext().getElement().equals(auxInicio.getNext().getElement())){
					for(int i = 0; i < repetidos.length -1 ; i++){
						if(!repetidos[i].equals(inicio.getNext().getElement())){
							repetidos[countRepetidos] = inicio.getNext().getElement();
							countRepetidos++;
						}
					}
				}
				auxInicio = auxInicio.getNext();
			}
			inicio = inicio.getNext();
		}
		System.out.println(countRepetidos);
		
	}
}
