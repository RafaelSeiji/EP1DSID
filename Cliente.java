import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente{
	
	private Cliente(){}
	private int codigo = 0;
	private String nome = "";
	private String descricao = "";
	public static void main(String[] args){
		
		//hospedeiro(host) do servidor: (null representa host local)
	    String host = (args.length < 1) ? null: args[0];
	    
	    try{
	    	//obtm o stub para o registro
	    	Registry registry = LocateRegistry.getRegistry(host);
	    	
	    	//obtm o stub para o objeto remoto(Ola) do registro:
	    	for(int i=0; i<registry.list().length; i++) {
	    		System.out.println(registry.list()[i]);
	    	}
	    	PartRepository stub = (PartRepository) registry.lookup("PartRepository");
	    	
	    	System.out.println("Escreva comendao: ");
	    	System.out.println(" pipip popop");
	    	
	    	Scanner sc = new Scanner(System.in);
	    	
	    	if(sc.nextLine().equals("addp")) {
	    		Part stubPart = (Part) registry.lookup("Part");
	    		System.out.println("Nome da peca: ");
	    		stubPart.setNome(sc.nextLine());
	    		System.out.println("Descricao da peca: ");
	    		stubPart.setDescricao(sc.nextLine());
	    		stubPart.setCodigo(1);
	    		
	    		System.out.println("peca: ");
	    		System.out.println(stubPart.getCodigo());
	    		System.out.println(stubPart.getNome());
	    		System.out.println(stubPart.getDescricao());
	    		
	    		System.out.println("add peca");
	    		stub.inserirPart(stubPart);
	    		System.out.println(stubPart);
	    		
		    	for(int j=0; j<stub.getLista().size(); j++) {
		    		System.out.println(stub.getLista().get(j));
		    	}
	    		
	    	}
	    	//Invoca o mtodo remoto:
	    	/*
	    	System.out.println("Digite o nome: ");
	    	String nome = sc.nextLine();
	    	stub.setNome(nome);
	    	
	    	System.out.println("Digite a descricao: ");
	    	String descricao = sc.nextLine();
	    	stub.setDescricao(descricao);
	    	
	   
	    	
	    	nome = stub.getNome();
	    	System.out.println("nome: " + nome);
	    	descricao = stub.getDescricao();
	    	System.out.println("descricao: " + descricao);
	    	int codigo = stub.getCodigo();
	    	System.out.println("codigo: " + codigo);
	    	*/
	    }catch (Exception e) {
	    	
	    	System.err.println("Exceptiono no cliente" + e.toString());
	    	e.printStackTrace();
	    	}
	  	}
	public Part criarPart() {
		Part part = null;
		return part;
	}
	}