package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CandlestickFactory {

	/*
	 * Método para construir um candlestick
	 */
	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		double maximo = 0; // pegar o menor valor possivel para ser alterado logo na primeira iteração
		double minimo = negociacoes.isEmpty() ? 0 : Double.MAX_VALUE; // pegar o maior valor aceito pelo double para ser
																		// alterado logo na primeira iteração
		double volume = 0;

		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume(); // incrementa a variavel volume para obter o volume
												// total negociado
			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();// verifica se o valor de negociacao é maior que o maximo ja existente
			}
			if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();// verifica se o valor de negociacao é menor que o minimo ja existente
			}
		}

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco(); // pega o primeiro valor
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();// pega o
																											// ultimo
																											// valor

		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data); // retorna um novo candlestick com
																					// as informações calcualdas
	}

	public List<Candlestick> constroiCandles(List<Negociacao> todasNegociacoes) {
		Collections.sort(todasNegociacoes);

		List<Candlestick> candles = new ArrayList<Candlestick>();

		List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();

		Calendar dataAtual = todasNegociacoes.get(0).getData();

		for (Negociacao negociacao : todasNegociacoes) {
			// se n for no mesmo dia, fecha candle e reinicia variaveis
			if (!negociacao.isMesmoDia(dataAtual)) {
				Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
				candles.add(candleDoDia);
				negociacoesDoDia = new ArrayList<Negociacao>();
				dataAtual = negociacao.getData();
			}
			negociacoesDoDia.add(negociacao);
		}
		// adiciona último candle
		Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
		candles.add(candleDoDia);

		return candles;
	}
}