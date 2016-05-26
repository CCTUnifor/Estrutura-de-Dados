package LDE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;


import Lista.ILista;
import Lista.MyInterator;

public class LDESemSentinelas<T> implements ILista<T>, Iterable<T>, List<T>{

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

	public boolean add(T element) {
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
		return true;
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
		if(pos >= 0 && pos < size) 
			return true;
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
	
	
	@Override
	public Stream<T> stream(){
		return Stream.of(inicio.getElement());
	}

	@Override
	public Iterator<T> iterator() {
		return new MyInterator<T>(this);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}


}
