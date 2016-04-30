package Lista;

public interface ILista<T>{
	public void add(int position, T element);
	public void add(T element);
	public T remove(int position);
	public T get(int position);
	public T set(int position, T element);
	public int size();
	public boolean isEmpty();
}
