package votacaormi;

import java.awt.EventQueue;
import java.rmi.Naming;
import java.util.Scanner;
import java.util.Set;

/**
*
* Equipe: Filipe Gomes, Emerson Cayo Pinheiro, 
* Rodolfo Azevedo, Jo�o Pedro Cardoso, Aldemar Mendes.
*
*/

public class Cliente implements Runnable {

	private IUrna urna;


	@Override
	public void run() {
		try {
			this.urna = this.getUrnaService();
			System.out.println("cliente@localhost$> Urna localizada, pronto para votar!");
		} catch (Exception ex) {
			System.err.println(ex);
			System.exit(1);
		}

		this.capturarVotos();
	}


	public void capturarVotos() {

		boolean exit = false;

		try {
			final Scanner teclado = new Scanner(System.in);

			System.out.println("##########################################");
			System.out.println("## Escolha um candidato e em seguida    ##");
			System.out.println("## digite o numero correspondente a ele ##");
			System.out.println("## para contabilizar 1 voto             ##");
			System.out.println("## Ex:                                  ##");
			System.out.println("## Candidato fulano, numero 10          ##");
			System.out.println("## Digite 10 no console:                ##");
			System.out.println("## cliente@localhost$> 10 [enter]       ##");
			System.out.println("##########################################");

			while (!exit) {

				System.out.println("\n## Candidatos ##");
				this.mostrarCandidatos();
				System.out.println("################");

				System.out.print("cliente@localhost$> ");
				final String voto = Console.readCommand(teclado);

				try {
					Integer numero = Integer.parseInt(voto);
					this.urna.votar(numero);
				} catch (NumberFormatException ex) {
					System.err.println("cliente@localhost$> VOTO INVALIDO!");
				}
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	private void mostrarCandidatos() throws Exception {

		final Set<Candidato> candidatos = this.urna.getCandidatos();

		candidatos.stream().forEach((candidato) -> {
			System.out.println(String.format("-> Nome %s, n�mero %s", candidato.getNome(), candidato.getNumero()));
		});
	}

	/**
	 *
	 * @return @throws MalformedURLException
	 */
	private IUrna getUrnaService() throws Exception {
		return (IUrna) Naming.lookup("rmi://localhost/Urna");
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Cliente());
	}
}
