import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
public interface PartRepository extends Remote{
	void inserirPart(Part part) throws RemoteException;
	Part getPart(int codigo) throws RemoteException;
	List<Part> getLista() throws RemoteException;
}
