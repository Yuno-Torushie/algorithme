package versions.v1;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import versions.Player;

public class Serveur {

    public static void main(String[] args) throws RemoteException, MalformedURLException, UnknownHostException {
        // A COMPLETER
        // mise en place du service de nommage
    	LocateRegistry.createRegistry(1099);


    	//System.setSecurityManager(new RMISecurityManager());


    	// instanciation d'un objet serveur
    	Player player = new PlayerImp(null);

    	// 5. publication auprès d'un service de nommage
    	System.out.println(InetAddress.getLocalHost().getHostAddress());
    	Naming.rebind("rmi://localhost/PFC", player);
    	System.out.println("player enregistré");

    	//Naming.unbind("rmi://localhost/PFC");
    	//System.out.println("Player désenregistré");
    }
}
