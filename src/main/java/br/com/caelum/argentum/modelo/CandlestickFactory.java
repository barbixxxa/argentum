package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

	/*
	 * Método para construir um candlestick
	 */
	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		double maximo = negociacoes.get(0).getPreco();
		double minimo = negociacoes.get(0).getPreco();
		double volume = 0;

		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume(); // incrementa a variavel volume para obter o volume
												// total negociado
			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();// verifica se o valor de negociacao é maior que o maximo ja existente
			} else if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();// verifica se o valor de negociacao é menor que o minimo ja existente
			}
		}

		double abertura = negociacoes.get(0).getPreco(); // pega o primeiro valor
		double fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();// pega o ultimo valor

		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data); // retorna um novo candlestick com
																					// as informações calcualdas
	}
}