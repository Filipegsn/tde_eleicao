package votacaormi;

import java.io.Serializable;

/**
*
* Equipe: Filipe Gomes, Emerson Cayo Pinheiro, 
* Rodolfo Azevedo, João Pedro Cardoso, Aldemar Mendes.
*
*/

public class Candidato implements Serializable {

    
	private static final long serialVersionUID = 1L;
	private String nome;
    private Integer numero;

    /**
     * 
     * @param nome
     * @param numero 
     */
    public Candidato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }
}
