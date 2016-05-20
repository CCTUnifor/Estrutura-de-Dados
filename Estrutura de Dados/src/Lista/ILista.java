package Lista;

import java.util.stream.Stream;

public interface ILista<T> extends Iterable<T>{
	public void add(int position, T element);
	public boolean add(T element);
	public T remove(int position);
	public T get(int position);
	public T set(int position, T element);
	public int size();
	public boolean isEmpty();
	public Stream<T> stream();
}
