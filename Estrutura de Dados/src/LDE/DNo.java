package LDE;

public class DNo <T> {
	
	private T element;
	private DNo<T> next, prev;
	
	public DNo(T element, DNo<T> prev, DNo<T> next){
		this.element = element;
		this.next = next;
		this.prev = prev;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public DNo<T> getNext() {
		return next;
	}

	public void setNext(DNo<T> next) {
		this.next = next;
	}

	public DNo<T> getPrev() {
		return prev;
	}

	public void setPrev(DNo<T> prev) {
		this.prev = prev;
	}
	
	public String toString(){
		String s = "[ ";
		
		DNo<T> aux = this;
		while(aux.getNext() != null){
			s += aux.getElement() + ", ";
			aux = aux.getNext();
		}
		s += aux.getElement() + " ]";
		
		return s;
	}

}
