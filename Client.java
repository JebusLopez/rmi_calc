import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Client {
        private static Interface servidorOBJ;
    private static String serverAddress;
    private static int serverPort;

    private static int opc;
    private static float a,b;
    private static Scanner entrada;
    
    public Client(){
        serverAddress  = "localhost";
        serverPort = 5000;
        entrada = new Scanner(System.in);
        opc = 0;
        a = 0;
        b = 0;
    }
    
    public static void main(String[] args) throws RemoteException {
        Client client = new Client();
        
        try{
            Registry registry = LocateRegistry.getRegistry(serverAddress,serverPort);
            servidorOBJ = (Interface) (registry.lookup("operacionservidor"));
            
            do{
                menu();
                opc = entrada.nextInt();
                if(opc >= 5){
                    System.out.println("Elige una opcion valida");
                }
                else{
                    DecimalFormat df = new DecimalFormat("0.00");
                    switch(opc){
                        case 1:
                            System.out.println("Primer valor:");
                            a = entrada.nextFloat();
                            System.out.println("Segundo valor:");
                            b = entrada.nextFloat();
                            System.out.println("El resultado de la suma es =  "+ df.format(servidorOBJ.sumar(a, b)));
                            break;
                        case 2:
                            System.out.println("Primer valor:");
                            a = entrada.nextFloat();
                            System.out.println("Segundo valor:");
                            b = entrada.nextFloat();
                            System.out.println("El resultado de la resta es =  "+ df.format(servidorOBJ.restar(a, b)));
                            break;
                        case 3:
                            System.out.println("Primer valor:");
                            a = entrada.nextFloat();
                            System.out.println("Segundo valor:");
                            b = entrada.nextFloat();
                            System.out.println("El resultado de la multiplicacion es =  "+ df.format(servidorOBJ.multiplicar(a, b)));
                            break;
                        case 4:
                            System.out.println("Primer valor:");
                            a = entrada.nextFloat();
                            System.out.println("Segundo valor:");
                            b = entrada.nextFloat();
                            System.out.println("El resultado de la divicion es =  "+ df.format(servidorOBJ.dividir(a, b)));
                            break;                            
                    }
                }
                
            }while(opc != 0);
            System.out.println("saliendo...");
            
        }catch(NotBoundException ex){
           ex.printStackTrace();
        }
    }

    private static void menu() {
        System.out.println("0 - Salir");
        System.out.println("1 - Sumar");        
        System.out.println("2 - Restar");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");

    }
}
