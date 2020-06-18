//package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazCliente extends Remote {
    void retriveMessage(String name, String message) throws RemoteException;
    String getName() throws RemoteException;
}
