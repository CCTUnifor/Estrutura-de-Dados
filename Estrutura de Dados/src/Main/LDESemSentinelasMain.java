package Main;

import LDE.DNo;
import LDE.LDESemSentinelas;

public class LDESemSentinelasMain {

	public static void main(String[] args) {
		LDESemSentinelas<Integer> l = new LDESemSentinelas<Integer>();
		l.add(0);
		System.out.println("add(0): " + l);
		
		l.add(1);
		System.out.println("add(1): " + l);
		
		l.add(2);
		System.out.println("add(2): " + l);
		
		l.add(0, 3);
		System.out.println("add(0, 3): " + l);

		l.add(3, 4);
		System.out.println("add(3, 4): " + l);
		
		l.add(1, 5);
		System.out.println("add(1, 5): " + l);
	
		l.remove(0);
		System.out.println("remove(0): " + l);
		
		l.remove(2);
		System.out.println("remove(2): " + l);
		
		l.add(4);
		System.out.println("add(4): " + l);
		
		System.out.println("clonar(): " + l.clonar());
		
		l.excluirRepetidos();
		System.out.println("excluirRepetidos: " + l);
		
		l.add(3, 0);
		System.out.println("add(3, 0): " + l);
		
		l.excluirRepetidos();
		System.out.println("excluirRepetidos: " + l);
		
		
		
	}
}
