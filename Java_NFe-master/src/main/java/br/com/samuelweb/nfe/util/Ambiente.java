/**
 * 
 */
package br.com.samuelweb.nfe.util;

/**
 * @author Samuel Oliveira
 *
 */
/**
 * Enum que contém todos os estados brasileiros.
 * 
 * @author Jerônimo Nunes Rocha
 *
 */
public enum Ambiente {

	HOMOLOGACAO("2"), PRODUCAO("1");

	private final String ambiente;

	private Ambiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public String get() {
		return ambiente;
	}

	@Override
	public String toString() {
		return ambiente;
	}

}
