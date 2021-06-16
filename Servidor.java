package ep1;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Servidor implements Part {
	
	private int codigo = 0;
	private String nome = "";
	private String descricao = "";
	private List <Part> subcomponentes = new ArrayList<Part>();
	
	private static int sequencia = 0;
	
	public Servidor(String nome, String descricao) {
		this.codigo = sequencia++;
		this.nome = nome;
		this.descricao = descricao;

	}
	
	public static void main (String args[]){
		try{
			//Criação e exportação do Objeto Remoto:
			String nome = "HD";
			String descricao = "1TB";
			Servidor obj = new Servidor(nome, descricao);
			Part stub = (Part) UnicastRemoteObject.exportObject(obj,0);

			//Registro do Objeto Remoto com Java RMI Registry:
			Registry registry = LocateRegistry.getRegistry();
			registry.bind(nome,stub);
			
			System.err.println("Servidor pronto . . .");
					
		}catch (Exception e){
		    	 
			System.err.println("Exceçao no servidor:  " + e.toString());
			e.printStackTrace();
			
		}
	
	}
	
	
	public void setCodigo (int codigo) {
		this.codigo = codigo;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public void setDescricao (String descricao) {
		this.descricao = descricao;
	}
	
	public void addSub (Part sub) {
		this.subcomponentes.add(sub);
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public List<Part> getLista() {
		return this.subcomponentes;
	}
}
