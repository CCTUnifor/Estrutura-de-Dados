package GeradorRandom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import LDE.LDESemSentinelas;

public class RandomTxt {

	
	
	public static void GerarArquivoTxt(){
		FileWriter arq = null;
		
		try {
			arq = new FileWriter("RandomPrimeiro");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(arq != null){
			PrintWriter gravarArq = new PrintWriter(arq);
			Random gerador = new Random();
			
			for (int i = 0; i < 1000; i++) {
				gravarArq.println(gerador.nextInt(501));
			}
			
			gravarArq.close();
		}
	}
	
	public LDESemSentinelas<Integer> GetLista(){
		//GerarArquivoTxt();
		LDESemSentinelas<Integer> lista = new LDESemSentinelas<Integer>();
		
		try {
			FileReader arq = new FileReader("RandomPrimeiro");
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine();
			while(linha != null){
				lista.add(Integer.parseInt(linha));
				linha = lerArq.readLine();
			}
			
			arq.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void GerarOrdenado(LDESemSentinelas<Integer> lista){
		FileWriter arq = null;
		int cont = 0;
		File f = new File("ListaOrdenada");
		while(f.exists()){
			cont++;
			f = new File("ListaOrdenada" + cont);
		}
		
		try {
			arq = new FileWriter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(arq != null){
			PrintWriter gravarArq = new PrintWriter(arq);
			
			for (int i = 0; i < lista.size(); i++) {
				gravarArq.println(lista.get(i));
			}
			gravarArq.close();
		}
	}
}
