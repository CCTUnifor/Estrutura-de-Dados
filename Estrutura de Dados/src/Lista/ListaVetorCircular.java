package Lista;

public class ListaVetorCircular<T> implements ILista<T> {

	private Object[] vector;
	private int footer, size, n;
	private boolean full;
	
	public ListaVetorCircular(int tamanho){
		vector = new Object[tamanho];
		footer = size = 0;
		n = tamanho;
		full = false;
	}
	
	public void add(int position, T element) {
		if(!isFull())
			if(isPositionValid(position)){
				int auxF = footer;
				while(auxF - 1 != position - 1){
					vector[auxF] = vector[auxF - 1];
					auxF = (auxF -1 + n)%n;
				}
				vector[position] = element;
				footer = (footer + 1)% n;
				size++;
			}
	}

	public void add(T element) {
		if(!isFull()){
			vector[footer] = element;
			footer = (footer+1) % n;
			size++;
		}
	}

	public T remove(int position) {
		if(position >= size || position < 0)return null;
		T elementRemoved = (T) vector[position];
		int i = 0;
		while(i != size - position - 1){
			vector[position+i] = vector[position + i+ 1];
			i++;
		}
		footer = (footer - 1+ n)%n;
		size = (size - 1 + n)%n;
		return elementRemoved;
	}

	public T get(int position) {
		return (T) vector[position];
	}

	public T set(int position, T element) {
		T elementUpdated = (T) vector[position];
		
		vector[position] = element;
		
		return elementUpdated;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	public boolean isPositionValid(int position){
		if(position < 0 || position > size){
			return false;
		}
		return true;
	}
	
	private boolean isFull(){
		return (size == n);
	}
	
	public String toString(){
		String s = "[ ";
		for (int i = 0; i < size; i++) {
			if(i == size-1){
				s += vector[i] + " ]";
			}else{
				s += vector[i].toString() + ", ";
			}
		}
		return s;
		
	}

}
