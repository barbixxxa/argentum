package br.com.caelum.argentum.modelo;

import java.util.GregorianCalendar;

import org.junit.Test;

public class CandleBuilderTest {

	@Test(expected = IllegalStateException.class)
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
		CandleBuilder builder = new CandleBuilder();

		builder.comAbertura(10.5);
		builder.comFechamento(12.3);
		builder.comMinimo(19.8);
		builder.comMaximo(0);
		builder.comVolume(145234.20);
		builder.comData(new GregorianCalendar(2012, 8, 12, 0, 0, 0));

		Candlestick candle = builder.geraCandle();
	}
}
