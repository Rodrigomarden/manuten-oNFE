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
public enum Tipo {

	NFE("NFe"), NFCE("NFCe");

	private final String tipo;

	private Tipo(String tipo) {
		this.tipo = tipo;
	}

	public String get() {
		return tipo;
	}

	@Override
	public String toString() {
		return tipo;
	}

}
