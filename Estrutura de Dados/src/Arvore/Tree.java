package Arvore;

import LDE.LDESemSentinelas;
import Lista.ILista;

public class Tree<T> {
	private NodeElement<T> header;
	
	public Tree(){
		header = new NodeElement<T>(null);
	}
	
	public void AdicionarFilho(T element){
		header.AdicionarFilho(element);
	}
	
	public void SetFilhos(ILista<T> filhos){
		ILista<NodeElement<T>> filhosNode = new LDESemSentinelas<NodeElement<T>>();
		
		for (int i = 0; i < filhos.size(); i++) {
			filhosNode.add(new NodeElement<T>(filhos.get(i)));
		}
		header.SetFilhos(filhosNode);
	}
	
	public void PreOrdemEsquerda(){
		PreOrdemEsquerda(header);
	}
	
	private void PreOrdemEsquerda(NodeElement<T> n){
		System.out.println(header.GetElement());
		for (int i = 0; i < header.FilhosSize(); i++) {
			PreOrdemEsquerda(header.GetFilhos().get(i));
		}
	}
	
	public void PreOrdemDireita(){
		PreOrdemDireita(header);
	}
	
	private void PreOrdemDireita(NodeElement<T> n){
		System.out.println(header.GetElement());
		for (int i = header.FilhosSize() - 1; i >= 0; i++) {
			PreOrdemDireita(header.GetFilhos().get(i));
		}
	}
}	
