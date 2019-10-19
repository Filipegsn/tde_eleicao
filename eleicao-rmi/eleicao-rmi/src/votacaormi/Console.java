package votacaormi;

import java.util.Scanner;

/**
*
* Equipe: Filipe Gomes, Emerson Cayo Pinheiro, 
* Rodolfo Azevedo, Jo�o Pedro Cardoso, Aldemar Mendes.
*
*/

public class Console {

	/**
	 * 
	 * @param console
	 * @return
	 */
	public static String readCommand(Scanner console) {

		String command = "";
		boolean invalid = true;

		while (invalid) {
			command = console.nextLine();

			if (!command.isEmpty()) {
				invalid = false;
			}
		}
		return command;
	}
}
