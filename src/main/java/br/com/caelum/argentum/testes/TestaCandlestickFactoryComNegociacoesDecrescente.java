package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactoryComNegociacoesDecrescente {
	public static void main(String[] args) {

		Calendar hoje = Calendar.getInstance(); // pega a data de hoje

		// cria 4 negociações
		Negociacao negociacao1 = new Negociacao(53.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(49.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(40.3, 100, hoje);
		// adiciona as negociações a uma lista
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

		// instancia a fabrica de candlesticks
		CandlestickFactory fabrica = new CandlestickFactory();
		// passa os dados para o novo candle
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		System.out.println(candle.getAbertura());
		System.out.println(candle.getFechamento());
		System.out.println(candle.getMinimo());
		System.out.println(candle.getMaximo());
		System.out.println(candle.getVolume());
		System.out.println(candle);
	}
}
