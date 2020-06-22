import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.Naming;

public class ClienteCliente extends UnicastRemoteObject implements InterfazClienteCliente, Runnable {


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
    public void recibirMensaje(String name, String message) throws RemoteException {
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
           // System.out.println(urlServidor);
            InterfazClienteCliente cliente = (InterfazClienteCliente) Naming.lookup(urlServidor);
            ventana.printToScreen(name, mensaje);
        	cliente.recibirMensaje(name, mensaje);
        } catch (Exception ex) {
            Logger.getLogger(ClienteCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
