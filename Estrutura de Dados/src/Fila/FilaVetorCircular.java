package Fila;

public class FilaVetorCircular<T> implements IFila<T>{
	//Horario:
	//f = (f+1)%n
	//c = (c+1)%n
	//size = (n-f+c)
	
	//Anti-Horário:
	//f = (f-1+n)%n
	//c = (c-1+n)%n
	//size = (n-c+f)%n
	
	private int header;
	private int footer;
	private int size;
	private Object vector[];
	
	public FilaVetorCircular(int n){
		header = footer = 0;
		size = n+1;
		vector = new Object[size];
	}
	public void imprimir(){
		int n = (size-header+footer)%size;
		
		for(int i = header; i < footer; i++){
			System.out.print(vector[i] + " ");
		}
	}
	
	//@Override
	public void add(T element) {
		if(size() == (size-1)){
			throw new FilaVaziaException("Fila Cheia!!");
		}else{
			vector[footer] = element;
			footer = (footer + 1) % size;
		}
	}

	//@Override
	public T poll() {
		T aux = peek();
		vector[header] = null;
		header = (header + 1) % size;
		return aux;
	}

	//@Override
	public T peek() {
		if(isEmpty()){
			throw new FilaVaziaException("Fila Vazia!!");
		}
		return (T) vector[header];
	}

	//@Override
	public int size() {
		return (size-header+footer)%size;
	}

	//@Override
	public boolean isEmpty() {
		return (header == footer);
	}
	
	public T retornarCaudo(){
		return (T) vector[(footer - 1 + size) % size];
	}

	
}
