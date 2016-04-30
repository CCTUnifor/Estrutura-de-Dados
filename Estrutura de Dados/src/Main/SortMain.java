package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import GeradorRandom.RandomTxt;
import LDE.LDESemSentinelas;
import Lista.ILista;
import Radix.Sort;

public class SortMain {


	
	
	public static void main(String[] args) {
		
		
		//RandomTxt.GerarArquivoTxt(); Gerar arquivo Txt com os numeros Randoms
		
		LDESemSentinelas<Integer> lista = new RandomTxt().GetLista();
		
		
		/*lista.add(00);
		lista.add(13);
		lista.add(27);
		lista.add(05);
		lista.add(200);
		lista.add(02);
		lista.add(15);
		lista.add(350);
		lista.add(13);
		lista.add(285);*/
		
		System.out.println("Antes do Radix Sort: " + lista);
		
		Sort.Radix(lista);
		
		System.out.println("Depois do Radix Sort: " + lista);
	}
	

}
