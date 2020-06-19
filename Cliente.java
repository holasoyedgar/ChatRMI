//package cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;
import java.util.*;

public class Cliente extends UnicastRemoteObject implements InterfazCliente, Runnable {

	private static final long serialVersionUID = 1L;
	private Interfaz servidor;
    private String name = null;
    Ventana ventana;
    protected Cliente(String name, Interfaz servidor) throws RemoteException {
        /*
try{
        Enumeration Interfaces = NetworkInterface.getNetworkInterfaces();
while(Interfaces.hasMoreElements())
{
    NetworkInterface Interface = (NetworkInterface)Interfaces.nextElement();
    Enumeration Addresses = Interface.getInetAddresses();
    while(Addresses.hasMoreElements())
    {
        InetAddress Address = (InetAddress)Addresses.nextElement();
        System.out.println(Address.getHostAddress() + " " + Address.getHostName());
    }
 }}
  catch (Exception e)
        {
            e.printStackTrace();
        }*/
        this.name = name;
        this.servidor = servidor;
        servidor.registerChatClient(this, name);
        ventana = new Ventana(this, name);
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
        	servidor.broadcastMessage(name, mensaje);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarUsuario(String name){
        try {
            servidor.eliminarUsuario(name);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	@Override
	public String getName() throws RemoteException {
		// TODO Auto-generated method stub
		return this.name;
	}    
}
