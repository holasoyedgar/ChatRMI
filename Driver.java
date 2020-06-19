import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Driver {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        Naming.rebind("RMIChatServer", (Remote) new Servidor());
    }        
}
