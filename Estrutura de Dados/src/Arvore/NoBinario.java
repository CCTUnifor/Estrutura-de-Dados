package Arvore;

public class NoBinario<T> {

	private T Element;
	private NoBinario<T> Left;
	private NoBinario<T> Right;

	public NoBinario() {
		Element = null;
		Left = null;
		Right = null;
	}

	public NoBinario(T x) {
		Element = x;
		Left = null;
		Right = null;
	}

	public T getElement() {
		return Element;
	}

	public void setElement(T element) {
		Element = element;
	}

	public NoBinario<T> getLeft() {
		return Left;
	}

	public void setLeft(NoBinario<T> left) {
		Left = left;
	}

	public NoBinario<T> getRight() {
		return Right;
	}

	public void setRight(NoBinario<T> right) {
		Right = right;
	}

	
	
}
