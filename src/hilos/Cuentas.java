package hilos;
/**
 * 
 * @author Samir El Kharrat Martín
 *
 */
public class Cuentas {

	private double saldo;
	private double maximoSaldo;

    /**
     * 
     * Constructor de la clase
     * 
     * @param s parametro saldo
     * @param ms parametro maximoSaldo
     */
	public Cuentas(int s, int ms) {
		this.saldo = s;
		this.maximoSaldo = ms;
	}


	/**
	 * Método para mostrar el saldo
	 */
	public void impimirSaldo() {
		System.out.println("El saldo de su cuenta es: " + saldo);
	}
	
    /**
     * Método donde se ingresara el valor dado en la cuenta. Habrá una excepción si el saldo es mayor al saldo maximo, 
     * donde cancelara la transacción y quitara el dinero introducido
     * 
     * @param nuevoIngreso valor para sumar
     */
	public synchronized void ingresoCuenta(double nuevoIngreso) {
		System.out.println("hilo " + Thread.currentThread().getName() + " -----> Entra Incremento");
		System.out.println("El saldo de su cuenta es: " + saldo);
		saldo += nuevoIngreso;
		if (saldo > maximoSaldo) {
			System.out.println(
					"El saldo añadido supera en " + nuevoIngreso + " maximo permitido. Se le cancelara el movimiento");
		saldo -= nuevoIngreso;
		}

		System.out.println("El nuevo saldo de su cuenta es: " + saldo);
	}

	/**
     * Método donde se decrementa el valor dado en la cuenta. Habrá una excepción si el saldo es menor a 0, 
     * donde cancelara la transacción y devolvera el dinero introducido
	 * 
	 * @param nuevoDecremento valor para restar
	 */
	public synchronized void decrementarCuenta(double nuevoDecremento) {
		System.out.println("hilo " + Thread.currentThread().getName() + " ----> Entra Decremento");
		System.out.println("Es saldo de su cuenta es: " + saldo);
		saldo -= nuevoDecremento;
		if (saldo < 0) {
			System.out.println(
					"El saldo es menor a 0, se le cancelara el movimiento");
		saldo += nuevoDecremento;
		}
		
		System.out.println("El nuevo saldo de su cuenta es: " + saldo);
	}
}
