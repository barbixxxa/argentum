package br.com.caelum.argentum.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected = IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandleComDataNula() {
		new Candlestick(10, 20, 20, 10, 10000, null);
	}

	@Test
	public void quandoAberturaIgualFechamentoEhAlta() {
		Candlestick c = new Candlestick(15, 15, 20, 30, 10000, Calendar.getInstance());
		assertEquals(true, c.isAlta());
		assertEquals(false, c.isBaixa());
	}

}
