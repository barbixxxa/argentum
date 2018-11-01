package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Negociacao {

	// atributos
	private final double preco;
	private final int quantidade;
	private final Calendar data;

	// construtor
	public Negociacao(double preco, int quantidade, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("data nao pode ser nula");
		}

		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	// getters
	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}

	/*
	 * Método para retornar o volume de dinheiro transferido em uma negociação.
	 */
	public double getVolume() {
		return preco * quantidade;
	}

	public boolean isMesmoDia(Calendar mesmoMomento) {
		return (data.get(Calendar.DAY_OF_MONTH) == mesmoMomento.get(Calendar.DAY_OF_MONTH))
				&& (data.get(Calendar.MONTH) == mesmoMomento.get(Calendar.MONTH))
				&& (data.get(Calendar.YEAR) == mesmoMomento.get(Calendar.YEAR));
	}
}