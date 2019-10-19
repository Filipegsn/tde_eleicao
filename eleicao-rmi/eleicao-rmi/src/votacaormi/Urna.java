package votacaormi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.HashSet;

/**
*
* Equipe: Filipe Gomes, Emerson Cayo Pinheiro, 
* Rodolfo Azevedo, João Pedro Cardoso, Aldemar Mendes.
*
*/

public class Urna extends UnicastRemoteObject implements IUrna {

	/**
	 * Urna implementa IUrna(registrado como objeto remoto)
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Candidato, Integer> votos;

	/**
	 * 
	 * @throws RemoteException
	 */
	public Urna() throws RemoteException {
	}

	/**
	 * 
	 * @return um Hash com os candidatos
	 * @throws RemoteException
	 * 
	 */
	@Override
	public HashSet<Candidato> getCandidatos() throws RemoteException {
		return new HashSet<>(this.votos.keySet());
	}

	/**
	 * Este método será executado pelo cliente ao selecionar a opção voto
	 * desejada
	 * 
	 * @param numero
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public boolean votar(Integer numero) throws RemoteException {

		this.votos.keySet().stream().filter((candidato) -> (candidato.getNumero().equals(numero)))
				.forEach((candidato) -> {
					this.votos.put(candidato, this.votos.get(candidato) + 1);
				});

		return true;
	}

	/**
	 * 
	 * @param candidato
	 */
	public void adicionaCandidato(Candidato candidato) {

		if (this.votos == null) {
			this.votos = new HashMap<>();
		}

		this.votos.put(candidato, 0);
	}

	/**
	 * 
	 */
	public void calcularParcial() {

		System.out.println("\nurna@localhost$> Resultados parciais: ");

		this.votos.keySet().stream().forEach((candidato) -> {
			System.out.println(String.format("Candidato %s " + "recebeu %s votos", candidato.getNome(),
					this.votos.get(candidato)));
		});
	}
}
