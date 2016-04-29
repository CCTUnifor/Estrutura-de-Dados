package Pilha;

public abstract class IPilha<T> {
	protected No<T> header;
	protected No<T> footer;
	protected int size;
	
	public abstract void push(T element);
	public abstract T pop();
	public abstract T top();
	public abstract int size();
	public abstract boolean isEmpty();
}
