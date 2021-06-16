package ep1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente{
	
	private Cliente(){}
	
	public static void main(String[] args){
		
		//hospedeiro(host) do servidor: (null representa host local)
	    String host = (args.length < 1) ? null: args[0];
	    
	    try{
	    	//obtém o stub para o registro
	    	Registry registry = LocateRegistry.getRegistry(host);
	    	
	    	//obtém o stub para o objeto remoto(Ola) do registro:
	    	Part stub = (Part) registry.lookup("HD");
	    	
	    	//Invoca o método remoto:
	    	String nome = stub.getNome();
	    	System.out.println("nome: " + nome);
	    	
	    }catch (Exception e) {
	    	
	    	System.err.println("Exceção no cliente" + e.toString());
	    	e.printStackTrace();
	    	}
	  	}
	}