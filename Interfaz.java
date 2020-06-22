import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interfaz extends Remote {
    
    void registrarCliente(InterfazCliente cliente, String name) throws RemoteException;
    void broadcastMessage(String name, String message) throws RemoteException;
    void eliminarUsuario(String name) throws RemoteException;
}
