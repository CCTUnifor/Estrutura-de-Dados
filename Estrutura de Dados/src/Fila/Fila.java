package Fila;

import Pilha.No;

public class Fila<T> implements IFila<T> {

	private No<T> header;
	private No<T> footer;
	private int size;


	public Fila(){
		this.header = footer = null;
		this.size = 0;
	}

	//@Override
	public void add(T element) {
		if(isEmpty()){
			header = footer = new No<T>(element, null);
		}else{
			footer.setNext(new No<T>(element, null));
			footer = footer.getNext();
		}
		size++;
	}

	//@Override
	public T poll() {
		T element = header.getElement();
		
		header = header.getNext();
		size--;
		
		return element;
	}

	//@Override
	public T peek() {
		return header.getElement();
	}

	//@Override
	public int size() {
		return size;
	}

	//@Override
	public boolean isEmpty() {
		if(header == null){
			return true;
		}
		return false;
	}
	
	public void imprimir(){
		No<T> aux = header;
		while(aux != null){
			System.out.print(aux.getElement() + " ");
			aux = aux.getNext();
		}
	}
	
	public Fila<T> inverterFila(){
		Fila<T> filaAux = this.clone();
		
		this.header = null;
		this.footer = null;
		this.size = 0;
		
		int count = filaAux.size();// A\ B\ C A B
		
		for(int i = 0; i < count ; i++){
			int count2 = filaAux.size();
			for (int j = 0; j < count2 - 1; j++) {
				filaAux.add(filaAux.poll());
			}
			this.add(filaAux.poll());
			
		}
		
		return this;
		
	}
	
	public Fila<T> clone(){
		Fila<T> fila = new Fila<T>();
		
		No<T> aux = header;
		while(aux != null){
			fila.add(aux.getElement());
			aux = aux.getNext();
		}
		
		return fila;
	}

}
