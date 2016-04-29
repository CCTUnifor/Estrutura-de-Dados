package Main;

import LDE.LDE;
import Lista.ListaVetorCircular;

public class ListaVetorCircularMain {

	public static void main(String[] args) {
		
		ListaVetorCircular<Integer> l = new ListaVetorCircular<Integer>(10);
		l.add(0, 0);
		System.out.println("Add(0, 0): " + l);
		
		l.add(0, 1);
		System.out.println("Add(0, 1): " + l);
		
		l.add(0, 2);
		System.out.println("Add(0, 2): " + l);
		
		l.remove(0);
		System.out.println("Remove(0): " + l);
		
		l.set(1, 10);
		System.out.println("Set(1, 10): " + l);
		
		l.add(1, 8);
		System.out.println("Add(1, 8): " + l);
		
		l.add(9);
		System.out.println("Add(9): " + l);
		
		l.remove(1);
		System.out.println("Remove(1): " + l);
	}
	
}
