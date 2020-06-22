import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazCliente extends Remote {
    void recibirMensaje(String name, String message) throws RemoteException;
    String getName() throws RemoteException;
}
