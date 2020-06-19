import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor extends UnicastRemoteObject implements Interfaz {

    private static final long serialVersionUID = 1L;
    private ArrayList<InterfazCliente> clientes;
    private ArrayList<String> nombres;
    
    protected Servidor() throws RemoteException {
        clientes = new ArrayList<InterfazCliente>();
        nombres = new ArrayList<String>();
    }

    @Override
    public synchronized void registerChatClient(InterfazCliente cliente, String name) throws RemoteException {
        this.clientes.add(cliente);
        this.nombres.add(name);
    }

    @Override
    public synchronized void broadcastMessage(String name, String message) throws RemoteException {
        int i = 0;
        System.out.println(name + ": " + message);
        while(i < clientes.size()) {
        		clientes.get(i).retriveMessage(name, message);
        	i++;
        }
    }

    @Override
    public synchronized void eliminarUsuario(String name) throws RemoteException {
        int indice = nombres.indexOf(name);
        clientes.remove(indice);
        nombres.remove(indice);
    }
}
