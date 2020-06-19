//package servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DriverClienteCliente {
	public DriverClienteCliente(String name, String otroCliente) throws RemoteException, MalformedURLException{
		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		new Thread(new ClienteCliente(name, otroCliente)).start();
        Naming.rebind("RMIChatClienteCliente", (Remote) new ClienteCliente(name, otroCliente));
	}
    public static void main(String[] args) throws RemoteException, MalformedURLException {
		//LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        //Naming.rebind("RMIChatClienteCliente", (Remote) new ClienteCliente());
    }        
}
