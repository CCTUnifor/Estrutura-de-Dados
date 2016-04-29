package Main;

import LDE.LDE;

public class LDEMain {

	public static void main(String[] args) {
		LDE<Integer> l = new LDE<Integer>();
		
		l.add(0, 0);
		System.out.println("add(0, 0): " + l);
		
		l.add(0, 1);
		System.out.println("add(0, 1): " + l);
		
		l.add(2);
		System.out.println("add(2): " + l);
	}

}
