package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {

	/*
	 * atributos
	 */
	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;

	/*
	 * setters
	 */
	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		return this;
	}

	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		return this;
	}

	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		return this;
	}

	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		return this;
	}

	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		return this;
	}

	public CandleBuilder comData(Calendar data) {
		this.data = data;
		return this;
	}

	public Candlestick geraCandle() {

		if (this.data == null || this.abertura <= 0 || this.fechamento <= 0 || this.maximo <= 0 || this.minimo <= 0
				|| this.volume <= 0) {
			throw new IllegalStateException("Valor invalido");
		}
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}
}
