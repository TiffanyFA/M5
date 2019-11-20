import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComptadorTest {

	@Test
	public void countZeroMinMenysDeuMaxDeuCountMenysU() {
		//Arrage (set-up)
		Comptador comptador = new Comptador(0, -10, 10);//inicialitzar a 0, min i max
		//Act
		comptador.validaPositiu(-10, 10);
		//Assert
		assertEquals(new Integer(-1), comptador.getSaldo());
	}

	@Test
	public void countZeroMinUMaxDeuEntradaSetCountVuit() {
		//Arrage (set-up)
		Comptador comptador = new Comptador(0, 1, 10);//inicialitzar a 0, min i max
		//Act
		comptador.validaRang(7);
		//Assert
		assertEquals(new Integer(1), comptador.getSaldo());
	}

	@Test
	public void countZeroMinUMaxDeuEntradaVintCountZero() {
		//Arrage (set-up)
		Comptador comptador = new Comptador(0, 1, 10);//inicialitzar a 0, min i max
		//Act
		comptador.validaRang(20);
		//Assert
		assertEquals(new Integer(0), comptador.getSaldo());
	}
}