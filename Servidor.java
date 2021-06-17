import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Servidor implements Part, PartRepository{
	
	private int codigo = 0;
	private String nome = "";
	private String descricao = "";
	private List <Part> subcomponentes = new ArrayList<Part>();
	
	private static int sequencia = 0;
	
	private List<Part> lista = new ArrayList<Part>();
	
	public Servidor() {}

	
	public static void main (String args[]){
		try{
			Servidor obj = new Servidor();
			//Servidor obj2 = new Servidor();
			Servidor oPart = new Servidor();
			Part stubPart = (Part) UnicastRemoteObject.exportObject(oPart,0);
			//Part stub = (Part) UnicastRemoteObject.exportObject(obj,0);
			PartRepository stub = (PartRepository) UnicastRemoteObject.exportObject(obj,0);
			//PartRepository stub2 = (PartRepository) UnicastRemoteObject.exportObject(obj2,0);
			
			//Registro do Objeto Remoto com Java RMI Registry:
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("PartRepository",stub);
			//registry.bind("PartRepository2", stub2);
			registry.rebind("Part", oPart);
			System.err.println("Servidor pronto . . .");
		
		}catch (Exception e){
		    	 
			System.err.println("Excecao no servidor:  " + e.toString());
			e.printStackTrace();
			
		}
	}
	//PARTREPOSITORY
	@Override
	public void inserirPart(Part part) throws RemoteException {
		this.lista.add(part);
		
	}

	@Override
	public Part getPart(int codigo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Part> getLista() throws RemoteException {
		// TODO Auto-generated method stub
		return this.lista;
	}
	//PART

	@Override
	public void setCodigo(int codigo) throws RemoteException {
		this.codigo = codigo;
		
	}

	@Override
	public int getCodigo() throws RemoteException {
		// TODO Auto-generated method stub
		return this.codigo;
	}

	@Override
	public void setNome(String nome) throws RemoteException {
		// TODO Auto-generated method stub
		this.nome = nome;
	}

	@Override
	public String getNome() throws RemoteException {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public void setDescricao(String descricao) throws RemoteException {
		// TODO Auto-generated method stub
		this.descricao = descricao;
	}

	@Override
	public String getDescricao() throws RemoteException {
		// TODO Auto-generated method stub
		return this.descricao;
	}

	@Override
	public void addSub(Part sub) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Part> getSubComps() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

