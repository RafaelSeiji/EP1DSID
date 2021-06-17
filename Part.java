import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Part extends Remote {
	
	void setCodigo(int codigo) throws RemoteException;
	int getCodigo() throws RemoteException;
	void setNome(String nome) throws RemoteException;
	String getNome() throws RemoteException;
	void setDescricao(String descricao) throws RemoteException;
	String getDescricao() throws RemoteException;
	void addSub(Part sub) throws RemoteException;
	List<Part> getSubComps() throws RemoteException;
}
