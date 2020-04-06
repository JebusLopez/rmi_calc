import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote{
    
    public float sumar (float a, float b)
            throws RemoteException;
    
    public float restar(float a, float b)
            throws RemoteException;
    
    public float multiplicar(float a, float b)
            throws RemoteException;
    
    public float dividir(float a, float b)
            throws RemoteException;
}
