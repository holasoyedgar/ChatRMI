import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;
import java.util.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class ClienteCliente extends UnicastRemoteObject implements InterfazCliente, Runnable {


	private static final long serialVersionUID = 1L;
	private String otroCliente;
    private String name = null;
    VentanaClienteCliente ventana;
    protected ClienteCliente(String name, String otroCliente) throws RemoteException {
        this.name = name;
        this.otroCliente = otroCliente;
        ventana = new VentanaClienteCliente(this, name);
    }
    
    @Override
    public void retriveMessage(String name, String message) throws RemoteException {
    	ventana.printToScreen(name, message);
    }

    @Override
    public void run() {
        ventana.setVisible(true);
    }
    
    public void enviarMensaje(String name, String mensaje) {
    	System.out.println(name + ": " + this.getRef());
        try {
            String urlServidor = "rmi://" + otroCliente + ":3000/RMIChatClienteCliente";
            System.out.println(urlServidor);
            InterfazClienteCliente cliente = (InterfazClienteCliente) Naming.lookup(urlServidor);
        	cliente.retriveMessage(name, mensaje);
        } catch (Exception ex) {
            Logger.getLogger(ClienteCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	@Override
	public String getName() throws RemoteException {
		// TODO Auto-generated method stub
		return this.name;
	}    
}
