package hilos;

public class Persona extends Thread {

	private double aleatorio;
	private Cuentas cuenta;
	private String hilo;

	/**
	 * 
	 * Constructor de la clase
	 * 
	 * @param h parametro hilo
	 * @param c parametro cuenta
	 */
	public Persona(String h, Cuentas c) {
		this.hilo = h;
		this.cuenta = c;
	}

    /**
     * Método sobrescrito de Thread donde estan los 2 ingresos y drecrementos con sleeps
     */
	@Override
	public void run() {

		try {
			aleatorio = aleatorio();
			cuenta.ingresoCuenta(aleatorio);
			Thread.sleep(1000);
			aleatorio = aleatorio();
			cuenta.decrementarCuenta(aleatorio);
			Thread.sleep(1000);
			aleatorio = aleatorio();
			cuenta.ingresoCuenta(aleatorio);
			Thread.sleep(1000);
			aleatorio = aleatorio();
			cuenta.decrementarCuenta(aleatorio);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	
    /**
     * 
     * Método para generar el número aleatorio
     * 
     * @return retorna el número aleatorio
     */
	public double aleatorio() {
		double numero;

		numero = Math.random() * 500 + 1;

		return numero;
	}

}
