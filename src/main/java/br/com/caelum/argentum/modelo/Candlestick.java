package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {

	/*
	 * atributos
	 */
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	/*
	 * construtor
	 */
	public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("data nao pode ser nula");
		}
		if (abertura < 0 || fechamento < 0 || minimo < 0 || maximo < 0 || volume < 0) {
			throw new IllegalArgumentException("o valor não pode ser negativo");
		}
		if (maximo < minimo) {
			throw new IllegalArgumentException("Valor maximo não pode ser menor que o minimo");
		}

		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	/*
	 * getters
	 */
	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	/*
	 * Método para retornar se o Candlestick é do tipo de alta
	 */
	public boolean isAlta() {
		return this.abertura < this.fechamento;
	}

	/*
	 * Método para retornar se o Candlestick é do tipo de baixa
	 */
	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		return "Abertura = [" + this.getAbertura() + "], Fechamento = [" + this.getFechamento() + "], Mínima = ["
				+ this.getMinimo() + "], Máxima = [" + this.getMaximo() + "], Volume = [" + this.getVolume()
				+ "], Data = [" + dateFormat.format(this.getData().getTime()) + "]";

	}
}