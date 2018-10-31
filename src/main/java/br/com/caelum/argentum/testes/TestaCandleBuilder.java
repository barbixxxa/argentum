package br.com.caelum.argentum.testes;

import java.util.GregorianCalendar;

import br.com.caelum.argentum.modelo.CandleBuilder;
import br.com.caelum.argentum.modelo.Candlestick;

public class TestaCandleBuilder {

	public static void main(String[] args) {
		CandleBuilder builder = new CandleBuilder();

		builder.comAbertura(10.5);
		builder.comFechamento(12.3);
		builder.comMinimo(19.8);
		builder.comMaximo(15.0);
		builder.comVolume(145234.20);
		builder.comData(new GregorianCalendar(2012, 8, 12, 0, 0, 0));

		Candlestick candle = builder.geraCandle();

		System.out.println("CANDLE 1 :" + candle);
		System.out.println(candle.getAbertura());
		System.out.println(candle.getFechamento());
		System.out.println(candle.getMinimo());
		System.out.println(candle.getMaximo());
		System.out.println(candle.getVolume());

		Candlestick candle2 = new CandleBuilder().comAbertura(40.5).comFechamento(42.3).comMinimo(39.8).comMaximo(45.0)
				.comVolume(145234.20).comData(new GregorianCalendar(2018, 0, 21, 0, 0, 0)).geraCandle();

		System.out.println("CANDLE2 ;" + candle2);
		System.out.println(candle2.getAbertura());
		System.out.println(candle2.getFechamento());
		System.out.println(candle2.getMinimo());
		System.out.println(candle2.getMaximo());
		System.out.println(candle2.getVolume());

	}

}
