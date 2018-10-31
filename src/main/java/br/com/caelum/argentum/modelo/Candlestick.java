package br.com.caelum.argentum.modelo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {

	/*
	 * atributos
	 */
	private final BigDecimal abertura;
	private final BigDecimal fechamento;
	private final BigDecimal minimo;
	private final BigDecimal maximo;
	private final BigDecimal volume;
	private final Calendar data;

	/*
	 * construtor
	 */
	public Candlestick(BigDecimal abertura, BigDecimal fechamento, BigDecimal minimo, BigDecimal maximo,
			BigDecimal volume, Calendar data) {
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
	public BigDecimal getAbertura() {
		return abertura;
	}

	public BigDecimal getFechamento() {
		return fechamento;
	}

	public BigDecimal getMinimo() {
		return minimo;
	}

	public BigDecimal getMaximo() {
		return maximo;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

<<<<<<< HEAD
	// /*
	// * Método para retornar se o Candlestick é do tipo de alta
	// */
	// public boolean isAlta() {
	// return this.abertura < this.fechamento;
	// }
	//
	// /*
	// * Método para retornar se o Candlestick é do tipo de baixa
	// */
	// public boolean isBaixa() {
	// return this.abertura > this.fechamento;
	// }
=======
//	/*
//	 * Método para retornar se o Candlestick é do tipo de alta
//	 */
//	public boolean isAlta() {
//		return this.abertura < this.fechamento;
//	}
//
//	/*
//	 * Método para retornar se o Candlestick é do tipo de baixa
//	 */
//	public boolean isBaixa() {
//		return this.abertura > this.fechamento;
//	}
>>>>>>> eff8824d9d1fe0b548695a98fe0a0df3cd59dcae

	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		return "Abertura = [" + this.getAbertura() + "], Fechamento = [" + this.getFechamento() + "], Mínima = ["
				+ this.getMinimo() + "], Máxima = [" + this.getMaximo() + "], Volume = [" + this.getVolume()
				+ "], Data = [" + dateFormat.format(this.getData().getTime()) + "]";

	}
}