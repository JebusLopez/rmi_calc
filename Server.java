package rmi_calc_server;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmi_calc_interface.Interface;

public class Server extends UnicastRemoteObject implements Interface{
     private final int PUERTO = 5000;
    
    public Server() throws RemoteException{
    }
    
    public static void main(String[] args) throws RemoteException {
        (new Server()).iniciarServidor();
    }

    private void iniciarServidor() {
        try{
            String dirIP = (InetAddress.getLocalHost()).toString();
            System.out.println("Escuchando en.. "+dirIP+":"+PUERTO);
            Registry registry = LocateRegistry.createRegistry(PUERTO);
            registry.bind("operacionservidor", (Interface) this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public float sumar(float a, float b) throws RemoteException {
        float resultado=0;
        resultado = a + b;
        return resultado;
    }

    @Override
    public float restar(float a, float b) throws RemoteException {
        float resultado=0;
        resultado = a - b;
        return resultado;
    }

    @Override
    public float multiplicar(float a, float b) throws RemoteException {
        float resultado=0;
        resultado = a * b;
        return resultado;
    }

    @Override
    public float dividir(float a, float b) throws RemoteException {
        float resultado=0;
        resultado = a / b;
        return resultado;
    }
    
}
