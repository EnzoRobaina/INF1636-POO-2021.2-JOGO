package model;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class DadoTest {
	private static final int DEFAULT_TIMEOUT = 3000;
	private static Dado dado;
	
	@BeforeClass
	public static void addHelper() {
		dado = new Dado();
		dado.lanca();
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void testValorDadoNotNull() {
		assertNotNull("M�todo lanca() atualiza o atributo 'valor' do Dado",dado.getValorDado());
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testValorDadoRange() {
		boolean dentroDoRange = (dado.getValorDado()>=1) && (dado.getValorDado()<=6);
		assertTrue("M�todo lanca() retorna valor entre 1 e 6",dentroDoRange);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testCasoDadoColorido() {
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.lanca();
		dado2.lanca();
		
		String cor = dado.getDadoColorido(dado1.getValorDado(), dado2.getValorDado());
		
		if (dado1.getValorDado() == dado2.getValorDado())
			assertNotNull("Se os dados s�o iguais, dado colorido n�o pode ser nulo",cor);
		else
			assertNull("Se os dados s�o diferentes, dado colorido � nulo",cor);
	}

}
