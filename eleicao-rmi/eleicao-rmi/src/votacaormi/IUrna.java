package votacaormi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;

/**
*
* Equipe: Filipe Gomes, Emerson Cayo Pinheiro, 
* Rodolfo Azevedo, João Pedro Cardoso, Aldemar Mendes.
*
*/

public interface IUrna extends Remote {

	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public HashSet<Candidato> getCandidatos() throws RemoteException;

	/**
	 * 
	 * @param numero
	 * @return
	 * @throws RemoteException
	 */
	public boolean votar(Integer numero) throws RemoteException;
}
