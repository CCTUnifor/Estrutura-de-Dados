package Lista;

import java.util.Iterator;

public class MyInterator<T> implements Iterator<T>{
	private ILista<T> Lista;
	
	public MyInterator(ILista<T> lista){
		this.Lista = lista;
	}
	
	 private int index = 0;

     public boolean hasNext() {
         return index < Lista.size();
     }

     public T next() {
         return Lista.get(index++);
     }

     public void remove() {
         throw new UnsupportedOperationException("not supported yet");

     }
}