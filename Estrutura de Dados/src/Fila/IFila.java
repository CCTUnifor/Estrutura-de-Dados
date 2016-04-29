package Fila;

public interface IFila <T>{
	public void add(T element);
	public T poll() throws FilaVaziaException;
	public T peek() throws FilaVaziaException;
	public int size();
	public boolean isEmpty();
}
