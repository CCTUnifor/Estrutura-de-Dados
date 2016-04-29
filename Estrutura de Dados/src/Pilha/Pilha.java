package Pilha;

public class Pilha<T> extends IPilha<T>{
	private No<T> base;
	
	public Pilha(){
		header = footer = null;
		base = null;
		size = 0;
	}
	
	public void push(T element) {
		No<T> noToPush = new No<T>(element, null);
		if(isEmpty()){
			header = footer = noToPush;
		}else{
			noToPush.setNext(header);
			header = noToPush;
			//footer = footer.getNext();
		}
		
		size++;
	}

	public void pushBase(T element){
		base = new No<T>(element, header);
		while(header != null){
			header = header.getNext();
		}
		header = new No<T>(element, header);
		
		size++;
	}
	
	public T pop() {
		T elementAux = null;
		if(header != null){
			elementAux = header.getElement();
			
			if(!isEmpty()){
				if(header != null){
					header = header.getNext();
				}else{
					header = footer = null;
				}
			}
			size--;
		}
		return elementAux;
	}

	public T top() {
		return header.getElement();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		return false;
	}

	public T base(){
		return base.getElement();
	}



	
	
}
