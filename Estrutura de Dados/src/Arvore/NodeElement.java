package Arvore;

import LDE.LDESemSentinelas;
import Lista.ILista;

public class NodeElement<T> {
	private T Element;
	private ILista<NodeElement<T>> Filhos;
	
	
	public NodeElement(T element){
		this.Element = element;
		this.Filhos = new LDESemSentinelas<NodeElement<T>>();
	}
	
	public int FilhosSize(){
		return this.Filhos.size();
	}
	
	public ILista<NodeElement<T>> GetFilhos(){
		return this.Filhos;
	}
	
	public T GetElement(){
		return this.Element;
	}
	
	public void SetElement(T element){
		this.Element = element;
	}
	
	public NodeElement<T> AdicionarFilho(T element){
		NodeElement<T> filho = new NodeElement<T>(element);
		Filhos.add(filho);
		return filho;
	}
	
	public void SetFilhos(ILista<NodeElement<T>> filhos){
		this.Filhos = filhos;
	}
	
	public String toString(){
		String s = "[ " + this.Element + " ]";
		return s;
	}
}
