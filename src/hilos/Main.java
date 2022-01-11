package hilos;

public class Main {

	public static void main(String[] args) {
		
		//Creacion del Objeto cuenta
		Cuentas cuenta = new Cuentas(1, 2000);
		
		
		//For para crear x hilos
		for(int i = 0; i < 2; i++) {
			new Persona("Hilo " + i, cuenta).start();
		}

	}

}
