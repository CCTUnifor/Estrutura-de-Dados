package Lista;

import Pilha.No;

public class Lista<T> implements ILista<T> {

	private No<T> header;
	private int size;
	
	public Lista(){
		this.header = null;
		this.size = 0;
	}
	
	public void add(int position, T element) {
		if(!isEmpty()){
			if(position < size){
				
			}
		}
		
	}

	public void add(T element) {
		// TODO Auto-generated method stub
		
	}

	public T remove(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public T get(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public T set(int position, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


}
