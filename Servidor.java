package servidor;

import cliente.InterfazCliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor extends UnicastRemoteObject implements Interfaz {

    private static final long serialVersionUID = 1L;
    private ArrayList<InterfazCliente> clientes;
    
    protected Servidor() throws RemoteException {
        clientes = new ArrayList<InterfazCliente>();
    }

    @Override
    public synchronized void registerChatClient(InterfazCliente cliente) throws RemoteException {
        this.clientes.add(cliente);
    }

    @Override
    public synchronized void broadcastMessage(String name, String message) throws RemoteException {
        int i = 0;
        while(i < clientes.size()) {
        	if(clientes.get(i).getName().equals(message.split("__")[0])) {
        		clientes.get(i).retriveMessage(name, message.split("__")[1]);
        	}
        	i++;
        }
    }
    
}
