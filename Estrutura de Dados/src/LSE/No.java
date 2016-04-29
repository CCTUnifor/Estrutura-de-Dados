package LSE;

public class No <T> {
	private T element;
	private No<T> next;
	
	public No(T dado, No<T> prox) {
		this.element = dado;
		this.next = prox;
	}
	public T getElement() {
		return element;
	}
	public void setElement (T element) {
		this.element = element;
	}
	public No<T> getNext() {
		return next;
	}
	public void setNext(No<T> next) {
		this.next = next;
	}
}
