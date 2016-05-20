package LDE;

import java.util.Iterator;
import java.util.stream.Stream;

import Lista.ILista;
import Lista.MyInterator;

public class LDE<T> implements ILista<T>, Iterable<T>{

	private DNo<T> header, footer;
	private int size;
	
	public LDE(){
		header = new DNo<T>(null, null, null);
		footer = new DNo<T>(null, header, null);
		header.setNext(footer);
		size = 0;
	}
	
	public void add(int position, T element) {
		DNo<T> aux = atRank(position);
		if(aux == null){
			header.setNext(new DNo<T>(element, header, footer));
			//header.getNext().setPrev(header);
		}else{
			aux.setPrev((new DNo<T>(element, aux.getPrev(), aux)));
			aux.getPrev().getPrev().setNext(aux.getPrev());
			size++;
		}
	}

	public boolean add(T element) {
		footer.setPrev(new DNo<T>(element, footer.getPrev(), footer));
		size++;
		return true;
	}

	public T remove(int position) {
		DNo<T> aux = atRank(position);
		T elementRemoved = aux.getElement();
		
		aux.getPrev().setNext(aux.getNext());
		aux.getNext().setPrev(aux.getPrev());
		size--;
		
		return elementRemoved;
	}

	public T get(int position) {
		return atRank(position).getElement();
	}

	public T set(int position, T element) {
		DNo<T> aux = atRank(position);
		T elementReplaced = aux.getElement();
		aux.setElement(element);
		
		return elementReplaced;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	protected DNo<T> atRank(int position){
		DNo<T> aux = header;
		if(position >= 0 && position < size){
			for(int i = 0; i < position; i++){
				aux = aux.getNext();
			}
			return aux;
		}
		return aux;
	}
	
	////////////////////////////////////////////////////////////////
	
	public T getMiddle(){
		DNo<T> inicio = header, fim = footer;
		while(inicio != fim){
			inicio = inicio.getNext();
			fim = fim.getNext();
		}
		return inicio.getElement();
	}
	
	public void imprimirContrario(){
		DNo<T> fim = footer;
		while(fim != null){
			System.out.println(fim.getElement());
			fim = fim.getPrev();
		}
	}

	public String toString(){
		String s = "[ ";
		
		DNo<T> aux = header.getNext();
		
		for (int i = 0; i < size; i++) {
			
			s += aux.getElement() + ", ";
			aux = aux.getNext();
		}
		
		s += aux.getElement() + " ]";
		
		return s;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyInterator<T>(this);
	}

	@Override
	public Stream<T> stream() {
		return Stream.of(header.getNext().getElement());
	}
	
}
