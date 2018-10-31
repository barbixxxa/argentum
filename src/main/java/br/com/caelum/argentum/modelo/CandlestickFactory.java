package br.com.caelum.argentum.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

	/*
	 * Método para construir um candlestick
	 */
	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		BigDecimal maximo = negociacoes.get(0).getPreco();
		BigDecimal minimo = negociacoes.get(0).getPreco();
		BigDecimal volume = new BigDecimal("0");

		for (Negociacao negociacao : negociacoes) {
			volume = volume.add(negociacao.getVolume()); // incrementa a variavel volume para obter o volume
															// total negociado
			if (negociacao.getPreco().compareTo(maximo) > 0) {
				maximo = negociacao.getPreco();// verifica se o valor de negociacao é maior que o maximo ja existente
			} else if (negociacao.getPreco().compareTo(minimo) < 0) {
				minimo = negociacao.getPreco();// verifica se o valor de negociacao é menor que o minimo ja existente
			}
		}

		BigDecimal abertura = negociacoes.get(0).getPreco(); // pega o primeiro valor
		BigDecimal fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();// pega o ultimo valor

		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data); // retorna um novo candlestick com
																					// as informações calcualdas
	}
}