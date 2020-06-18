//package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class DriverCliente {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        String urlServidor = "rmi://" + args[1] + "/RMIChatServer:3000";
        Interfaz servidor = (Interfaz) Naming.lookup(urlServidor);
        new Thread(new Cliente(args[0], servidor)).start();
    }
            
}
