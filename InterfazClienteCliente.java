
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazClienteCliente extends Remote {
   // void enviarMensaje(String name, String message) throws RemoteException;
    void recibirMensaje(String name, String message) throws RemoteException;
}
