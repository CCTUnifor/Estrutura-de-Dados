package LDE;

import Lista.ILista;

public class LDESemSentinelas<T> implements ILista<T>{

	private DNo<T> inicio;
	private int size;
	
	public LDESemSentinelas(){
		inicio = new DNo<T>(null, null, null);
		size = 0;
	}
	
	public void add(int position, T element) {
		if(position == 0){
			if(size == 0){
				inicio.setElement(element);
			}else{
				inicio.setPrev(new DNo<T> (element, null, inicio));
				inicio = inicio.getPrev();
			}
		}else if((position - 1) != size){
			DNo<T> aux = atRank(position);
			aux.setPrev(new DNo<T>(element,aux.getPrev(), aux));
			aux.getPrev().getPrev().setNext(aux.getPrev());
		}else{
			DNo<T> aux = atRank(position);
			aux.setNext(new DNo<T>(element, aux, null));
		}
		size++;
	}

	public void add(T element) {
		DNo<T> aux = inicio;
		if(size == 0){
			aux.setElement(element);
		}else{
			while(aux.getNext() != null){
				aux = aux.getNext();
			}
			aux.setNext(new DNo<T>(element, aux, null));
		}
		size++;
		
	}

	public T remove(int position){
		DNo<T> aux = atRank(position);
		T elementRemoved = aux.getElement();
		if(position == 0){
			inicio = inicio.getNext();
			if (inicio != null) {
				inicio.setPrev(null);
			}
		}else if(aux.getNext() != null){
			aux.getPrev().setNext(aux.getNext());
			aux.getNext().setPrev(aux.getPrev());
			aux.setPrev(null);
			aux.setNext(null);
		}else{
			aux.getPrev().setNext(null);
			aux.setPrev(null);
		}
		size--;
		return elementRemoved;
	}
	
	public T get(int position) {
		return atRank(position).getElement();
	}

	public T set(int position, T element) {
		DNo<T> aux = atRank(position);
		T elementUpdated = aux.getElement();
		aux.setElement(element);
		return elementUpdated;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	protected DNo<T> atRank(int pos){
		if(isValid(pos)){
			DNo<T> aux = inicio;
			for (int i = 0; i < pos; i++) {
				aux = aux.getNext();
			}
			return aux;
		}
		return null;
		
	}
	
	private boolean isValid(int pos){
		if(pos >= 0 && pos < size) return true;
		
		return false;
	}
	
	public void removeAll(){
		while (inicio != null) {
			remove(0);
		}
		inicio = new DNo<T>(null, null, null);
	}
	
	public DNo<T> clonar(){
		DNo<T> aux = inicio;
		DNo<T> clonada = new DNo<T>(aux.getElement(), null, null);
		DNo<T> auxC = clonada;
		
		while(aux.getNext() != null){
			aux = aux.getNext();
			auxC.setNext(new DNo<T>(aux.getElement(), auxC, null));
			auxC = auxC.getNext();
		}
		
		return clonada;
	}
	
	public void excluirRepetidos(){
		DNo<T> aux1 = inicio;
		int cont = 0;
		
		while(aux1 != null){
			DNo<T> aux2 = aux1.getNext();
			while(aux2 != null){
				if(aux2.getElement().equals(aux1.getElement())){
					remove(cont);
				}
				aux2 = aux2.getNext();
			}
			cont++;
			aux1 = aux1.getNext();
		}
	}
	
	public String toString(){
		String s = "[ ";
		
		DNo<T> aux = inicio;
		if (aux != null) {
			while(aux.getNext() != null){
				s += aux.getElement() + ", ";
				aux = aux.getNext();
			}
			s += aux.getElement();
		}
		
		return s + " ]";
	}

}
