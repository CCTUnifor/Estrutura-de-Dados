package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import LDE.LDE;
import LDE.LDESemSentinelas;
import Lista.ILista;
import Lista.Lista;
import Models.ListaOrdenadaViewModel;

public class ArquivoManager {

	public static void CriarArquivoNumerosRandons(String path){
		final String ARQUIVO_NOME = path;
		FileWriter arq = null;
		
		try {
			//Verificar quantos arquivos Random existe e criar outro com nome diferente
			int i = 0;
			File file = new File(ARQUIVO_NOME + i);
			while(file.exists()){
				i++;
				file = new File(ARQUIVO_NOME + i);
			}
			arq = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(arq != null){
			PrintWriter gravarArq = new PrintWriter(arq);
			Random gerador = new Random();
			
			gravarArq.println("-------------- Arquivo gerado automaticamente --------------");
			gravarArq.println("---------- 10000 n�meros randomicamente de 0 � 1000 ----------\n");
			
			for (int i = 0; i < 10000; i++) {
				gravarArq.println(gerador.nextInt(1001));
			}
			gravarArq.close();
		}
	}

	public static ILista<Integer> LerArquivo(String path){
		//GerarArquivoTxt();
		ILista<Integer> lista = new LDESemSentinelas<Integer>();
		
		try {
			FileReader arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine();
			linha = lerArq.readLine();
			linha = lerArq.readLine();
			linha = lerArq.readLine();
			
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
	
	public void CriarArquivoOrdenado(ListaOrdenadaViewModel model){
		final String ARQUIVO_NOME = "ListaOrdenada";
		
		FileWriter arq = null;
		
		int cont = 0;
		File f = new File(ARQUIVO_NOME + cont);
		while(f.exists()){
			cont++;
			f = new File(ARQUIVO_NOME + cont);
		}
		
		try {
			arq = new FileWriter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(arq != null){
			PrintWriter gravarArq = new PrintWriter(arq);
			
			gravarArq.println("---------- Lista ordenada do arquivo: " + model.PathDaListaLida + " -----------");
			gravarArq.println("-------- Tempo de dura��o da ordena��o : "+ model.TotalTime + " milisegundos --------");
			gravarArq.println("-------- Memoria usada aproximada: " + model.TotalMemoryUsed + " bytes -------------\n");
			
			for (int i = 0; i < model.ListaOrdenada.size(); i++) {
				gravarArq.println(model.ListaOrdenada.get(i));
			}
			gravarArq.close();
		}
	}
}
