package test.java.localizadorcep;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.localizadorcep.AdapterEndereco;
import main.java.localizadorcep.LocalizadorCEP;
import main.java.localizadorcep.TargetCEP;

public class LocalizadorCepTest {

	@Test
	public void testLocalizadorMassa() 
	{
		TargetCEP loc1 = new LocalizadorCEP();
		assertEquals("Rua dos Inválidos, Rio de Janeiro, RJ", loc1.buscarPorCEP(12345678L));	
		
		TargetCEP loc2 = new LocalizadorCEP();
		assertEquals("Rua 1 de Março, Rio de Janeiro, RJ", loc2.buscarPorCEP(22348327L));
		
		TargetCEP loc3 = new LocalizadorCEP();
		assertEquals("Largo do Arouche, São Paulo, SP", loc3.buscarPorCEP(82737362L));	
		
		TargetCEP loc4 = new LocalizadorCEP();
		assertEquals("Avenida Rio Branco, Minas Gerais, MG", loc4.buscarPorCEP(63547435L));	
	}

	@Test
	public void testCorreiosMassa()
	{
		TargetCEP loc1 = new AdapterEndereco();
		assertEquals("Rua dos Inválidos, Rio de Janeiro, RJ", loc1.buscarPorCEP(12345678L));
		
		TargetCEP loc2 = new AdapterEndereco();
		assertEquals("Rua 1 de Março, Rio de Janeiro, RJ", loc2.buscarPorCEP(22348327L));
		
		TargetCEP loc3 = new AdapterEndereco();
		assertEquals("Largo do Arouche, São Paulo, SP", loc3.buscarPorCEP(82737362L));
		
		TargetCEP loc4 = new AdapterEndereco();
		assertEquals("Avenida Rio Branco, Minas Gerais, MG", loc4.buscarPorCEP(63547435L));	
	}
	
	@Test
	public void testLocalizadorParametroInvalido()
	{
		TargetCEP loc = new LocalizadorCEP();
		assertEquals(null, loc.buscarPorCEP(-1L));
	}
	
	@Test
	public void testCorreiosParametroInvalido()
	{
		TargetCEP loc = new AdapterEndereco();
		assertEquals(null, loc.buscarPorCEP(-1L));
	}
	
	@Test
	public void testEspaçoDuplicado(){
		TargetCEP loc1 = new AdapterEndereco();
		assertNotEquals("Largo  do Arouche, São Paulo, SP", loc1.buscarPorCEP(82737362L));
		
		TargetCEP loc2 = new LocalizadorCEP();
		assertNotEquals("Largo  do Arouche, São Paulo, SP", loc2.buscarPorCEP(82737362L));
	}
	
	@Test
	public void testoutroEndereco(){
		TargetCEP loc1 = new AdapterEndereco();
		assertNotEquals("Largo do Arouche, São Paulo, SP", loc1.buscarPorCEP(12345678L));
		
		TargetCEP loc2 = new LocalizadorCEP();
		assertNotEquals("Largo do Arouche, São Paulo, SP", loc2.buscarPorCEP(12345678L));
	}

}
