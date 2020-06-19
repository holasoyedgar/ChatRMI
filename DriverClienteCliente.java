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
		ClienteCliente cliente = new ClienteCliente(name, otroCliente);
		new Thread(cliente).start();
	/*	try{
			System.out.println(java.net.InetAddress.getLocalHost().getHostAddress());
		}catch(Exception e){
			e.printStackTrace();
		}*/
        Naming.rebind("//192.168.1.71/RMIChatClienteCliente:3000", (Remote) cliente);
	}
    public static void main(String[] args) throws RemoteException, MalformedURLException {
		//LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        //Naming.rebind("RMIChatClienteCliente", (Remote) new ClienteCliente());
    }        
}
