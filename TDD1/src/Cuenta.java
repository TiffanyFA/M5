/**
 * classe cuenta que gestiona ingresos, retirades i transferències
 * 
 * @author Tiffany
 * @version 18/11/19
 *
 */
//Ruta on es troba el javadoc
//C:\Program Files\Java\jdk1.8.0_91\bin
public class Cuenta {
	private double saldo;
	private final double LIMIT_TRANSFERENCIES = 3000;
	private double countTransf;
	
	public Cuenta() {
		this.saldo = 0.0;
		this.countTransf = 0;
	}

	/**
	 * retorna el saldo del compte
	 * @return Double 
	 */
	public Double getSaldo(){
		return this.saldo;
	}
	
	/**
	 * modifica el saldo 
	 * @param cantidad double quantitat que substitueix el saldo actual
	 */
	public void setSaldo(double cantidad) {
		this.saldo = cantidad;		
	}

	/**
	 * augmenta el saldo sempre que estigui validat
	 * @param cantidad double quantitat que s'afegeix al saldo si validarIngreso true
	 */
	public void ingresar(double cantidad) {
		if(validarIngreso(cantidad)) {
			this.saldo += cantidad;
		}
	}	
	
	/**
	 * decrementa el saldo sempre que estigui validat 
	 * @param cantidad double quantitat que farà decrementar el saldo si validarRetirada true
	 */
	public void retirar(double cantidad) {
		if(validarRetirada(cantidad)){
			this.saldo -= cantidad;
		}
	}	
	
	/**
	 * transferir quantitat d'un compte a un altre sempre que estigui validat
	 * @param cuenta2 Cuenta compte que rep la transferència
	 * @param cantidad double quantitat que es transfereix
	 */
	public void transfiere(Cuenta cuenta2, double cantidad) {
		countTransf += cantidad;
		if (validarTransferencia(cantidad) && LIMIT_TRANSFERENCIES >= countTransf){
			this.retirar(cantidad);
			cuenta2.ingresar(cantidad);			
		} else {
			countTransf -= cantidad;
		}
	}
	
	/**
	 * valida que l'ingrés cumpleix els requisits
	 * @param cantidad double quantitat a validar
	 * @return true si té dos decimals, és positiva i menor de 6000
	 */
	private boolean validarIngreso(double cantidad) {
		if(((double)Math.round(cantidad * 100d) / 100d == cantidad) &&
				(cantidad > 0) &&
				(cantidad <= 6000.00)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * valida que la retirada cumpleix els requisits
	 * @param cantidad double quantitat a validar
	 * @return true si té dos decimals, és positiva, menor de 6000 i menor que el saldo
	 */
	private boolean validarRetirada(double cantidad) {
		if(((double)Math.round(cantidad * 100d) / 100d == cantidad) &&
				(cantidad >	0) &&
				(cantidad <= 6000.00) &&
				(cantidad < this.saldo)) {
			return true;
		} else {
			return false;
		}
	}	
	
	/**
	 * valida que les transferencies cumpleixen els requisits
	 * @param cantidad double quantitat a validar
	 * @return true si té dos decimals, és positiva i menor de 3000
	 */
	private boolean validarTransferencia(double cantidad) {
		if(((double)Math.round(cantidad * 100d) / 100d == cantidad) &&
				(cantidad > 0) &&
				(cantidad <= 3000.00)) {
			return true;
		} else {
			return false;
		}
	}	

	

	
	
	
}