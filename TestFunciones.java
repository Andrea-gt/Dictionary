import junit.framework.TestCase;

public class TestFunciones extends TestCase  {
	private Controlador ctr;
	
	private void Inicializador() {
		ctr = new Controlador();
	}
	
	public void testFind() {
		Inicializador();
		ctr.EstablishingWords();
		assertEquals("mujer", ctr.SearchWord("woman"));
	}
	
	public void testRemove() {
		Inicializador();
		ctr.EstablishingWords();
		ctr.eliminateWord("woman");
		assertEquals(null, ctr.SearchWord("woman"));
	}
	
	public void testAdd() {
		Inicializador();
		ctr.EstablishingWords();
		ctr.addWord("carro", "car", "i");
		assertEquals("carro", ctr.SearchWord("car"));
	}
	
	public void testMod() {
		Inicializador();
		ctr.EstablishingWords();
		ctr.editWord("homework", "deberes");
		assertEquals("deberes", ctr.SearchWord("homework"));
	}
}
