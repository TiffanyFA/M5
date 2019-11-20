import static org.junit.Assert.*;
import org.junit.Test;


public class CuentaTest {
	
	//crea cuenta
	@Test
	public void crearCuentaSaldoFinalCero() {
		Cuenta cuenta = new Cuenta();
		//asserSame per a que compari amb === (tipus i contingut)
		assertEquals(new Double(0.0), cuenta.getSaldo());
	}
	
	//INGRESOS
	@Test
	public void ingresarCienEurosSaldoFinalCienEuros() {
		Cuenta cuenta = new Cuenta();
		cuenta.ingresar(100.0);
		assertEquals(new Double(100.0), cuenta.getSaldo());
	}
	
	@Test
	public void ingresarTresMilEurosSaldoFinalTresMilEuros() {
		Cuenta cuenta = new Cuenta();
		cuenta.ingresar(3000.0);
		assertEquals(new Double(3000.0), cuenta.getSaldo());
	}
	
	@Test
	public void ingresarTresMilEurosConSaldo100SaldoFinalTresMilCienEuros() {
		//Arrage (set-up)
		Cuenta cuenta = new Cuenta();
		cuenta.setSaldo(100);
		//Act
		cuenta.ingresar(3000.00);
		//Assert
		assertEquals(new Double(3000.00 + 100), cuenta.getSaldo());
	}
	
	@Test
	public void ingresarCienEurosNegativosSaldoFinalCeroEuros() {
		//set-up
		Cuenta cuenta = new Cuenta();
		//act
		cuenta.ingresar(-100.0);
		//assert
		assertEquals(new Double(0.0), cuenta.getSaldo());
	}
	
	@Test
	public void ingresarConDosDecimales() {
		//set-up
		Cuenta cuenta = new Cuenta();
		//act
		cuenta.ingresar(100.45);
		//assert
		assertEquals(new Double(100.45), cuenta.getSaldo());
	}
	
	@Test
	public void ingresarConMasDecimalesSaldoCero() {
		//set-up
		Cuenta cuenta = new Cuenta();
		//act
		cuenta.ingresar(100.445);
		//assert
		assertEquals(new Double(0.0), cuenta.getSaldo());
	}
	
	@Test
	public void ingresarSeisMilUnoSaldoIguañ() {
		//set-up
		Cuenta cuenta = new Cuenta();
		//act
		cuenta.ingresar(6001.01);
		//assert
		assertEquals(new Double(0.0), cuenta.getSaldo());
	}
	
	//RETIRADES
	@Test
	public void retirar100ConSaldo500Resultado400() {
		//set-up
		Cuenta cuenta = new Cuenta();
		cuenta.setSaldo(500);
		//act
		cuenta.retirar(100);
		//assert
		assertEquals(new Double(400), cuenta.getSaldo());
	}
	
	@Test
	public void retirar500ConSaldo200Resultado200() {
		//set-up
		Cuenta cuenta = new Cuenta();
		cuenta.setSaldo(200);
		//act
		cuenta.retirar(500);
		//assert
		assertEquals(new Double(200), cuenta.getSaldo());
	}
	
	@Test
	public void retirar100NegativoConSaldo500Resultado500() {
		//set-up
		Cuenta cuenta = new Cuenta();
		cuenta.setSaldo(500);
		//act
		cuenta.retirar(-100);
		//assert
		assertEquals(new Double(500), cuenta.getSaldo());
	}	
	
	//transferencias
	@Test
	public void transferencia100De500a50() {
		//set-up
		Cuenta cuenta = new Cuenta();
		cuenta.setSaldo(500);
		Cuenta cuenta2 = new Cuenta();
		cuenta2.setSaldo(50);
		//act
		cuenta.transfiere(cuenta2, 100);
		//assert
		assertEquals(new Double(400), cuenta.getSaldo());
		assertEquals(new Double(150), cuenta2.getSaldo());
	}
	
	@Test
	public void transferencia100ConDemasiadosDecimalesDe500a50() {
		//set-up
		Cuenta cuenta = new Cuenta();
		cuenta.setSaldo(500);
		Cuenta cuenta2 = new Cuenta();
		cuenta2.setSaldo(50);
		//act
		cuenta.transfiere(cuenta2, 100.123);
		//assert
		assertEquals(new Double(500), cuenta.getSaldo());
		assertEquals(new Double(50), cuenta2.getSaldo());
	}
	
	@Test
	public void transferencia2000ConSaldo3500() {
		//set-up
		Cuenta cuenta = new Cuenta();
		cuenta.setSaldo(3500);
		Cuenta cuenta2 = new Cuenta();
		cuenta2.setSaldo(50);
		//act
		cuenta.transfiere(cuenta2, 2000);
		cuenta.transfiere(cuenta2, 1200);
		//assert
		assertEquals(new Double(1500), cuenta.getSaldo());
		assertEquals(new Double(2050), cuenta2.getSaldo());
	}
}
