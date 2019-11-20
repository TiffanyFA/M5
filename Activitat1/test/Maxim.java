import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaximTest {

	@Test
	public void xEsTresYEsDosZEsUMaximTres() {
		//Arrage (set-up)
		Maxim max = new Maxim(3, 2, 1);
		//Act
		max.buscarMax();
		//Assert
		assertEquals(new Integer(3), max.getSaldo());
	}

	@Test
	public void xEsUYEsDosZEsTresMaximTres() {
		//Arrage (set-up)
		Maxim max = new Maxim(1, 2, 3);
		//Act
		max.buscarMax();
		//Assert
		assertEquals(new Integer(3), max.getSaldo());
	}

	@Test
	public void xEsUYEsDosZEsTresMaximTres() {
		//Arrage (set-up)
		Maxim max = new Maxim(1, 3, 2);
		//Act
		max.buscarMax();
		//Assert
		assertEquals(new Integer(3), max.getSaldo());
	}
}