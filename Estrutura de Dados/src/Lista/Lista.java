package Lista;

import LDE.DNo;
import Pilha.No;

public class Lista<T> implements ILista<T> {

	private No<T> header;
	private int size;
	
	public Lista(){
		this.header = new No<T>(null, null);
		this.size = 0;
	}
	
	public void add(int position, T element) {
		if(position == 0){
			if(size == 0){
				header.setElement(element);
			}else{
				header = new No<T>(element, header);
			}
		}else if((position - 1) != size){
			No<T> aux = atRank(position);
			aux.setNext(new No<T>(element, aux.getNext()));
		}else{
			No<T> aux = atRank(position);
			aux.setNext(new No<T>(element, null));
		}
		size++;
	}

	public void add(T element) {
		No<T> aux = header;
		if(size > 0){
			aux = atRank(size - 1);
			aux.setNext(new No<T>(element, null));
		}else{
			aux.setElement(element);
		}
		size++;
	}

	public T remove(int position) {
		No<T> aux = atRank(position - 1);
		T elementRemoved = aux.getElement();
		
		aux.setNext(aux.getNext());
		
		return elementRemoved;
	}

	public T get(int position) {
		return atRank(position).getElement();
	}

	public T set(int position, T element) {
		No<T> aux = atRank(position);
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

	protected No<T> atRank(int pos){
		if(isValid(pos)){
			No<T> aux = header;
			for (int i = 0; i < pos; i++) {
				aux = aux.getNext();
			}
			return aux;
		}
		return null;
	}

	private boolean isValid(int pos){
		if(pos >= 0 && pos < size) 
			return true;
		return false;
	}
	
}
