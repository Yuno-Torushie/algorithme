package versions.v2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//2. Implémentation de l'interface
public class PlayerDispenserImp extends UnicastRemoteObject implements PlayerDispenser {
	private static final long serialVersionUID = 1L;
	
	private String url = null; // url construite
	
	public PlayerDispenserImp() throws RemoteException {
		super();
	}

	/**
	 * obtention de l'URL sous laquelle un objet Player est enregistré
	 * @return
	 * retourne l'url
	 */
	public String getUrl() throws RemoteException {
        //TODO A COMPLETER
		return url;
    }

	/**
	 * définit la nouvelle URL pour délivrer un objet Player
	 * @param url
	 * url d'un objet Player
	 */
	public void setUrl(String url) throws RemoteException {
        //TODO A COMPLETER
		this.url = url;
	}

	/**
	 * informe le serveur qu'un nouvel objet Player doit être créé et une nouvelle URL générée
	 */
	public void nextUrl() throws RemoteException {
        //TODO A COMPLETER
		
	}

	
	/**
	 * attend de devoir générer une une nouvelle URL
	 */
	public void waitForNewUrl() throws RemoteException, InterruptedException {
        //TODO A COMPLETER
		
	}

}
