package br.com.caelum.argentum.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

public final class Negociacao {

	// atributos
	private final BigDecimal preco;
	private final int quantidade;
	private final Calendar data;

	// construtor
	public Negociacao(BigDecimal preco, int quantidade, Calendar data) {
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	// getters
	public BigDecimal getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return data;
	}

	/*
	 * Método para retornar o volume de dinheiro transferido em uma negociação.
	 */
	public BigDecimal getVolume() {
		return preco.multiply(new BigDecimal(quantidade));
	}
}