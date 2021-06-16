package ep1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Part extends Remote {
	
	int getCodigo() throws RemoteException;
	String getNome() throws RemoteException;
	String getDescricao() throws RemoteException;
	List<Part> getLista() throws RemoteException;
}
