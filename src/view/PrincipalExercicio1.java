package view;

import java.util.concurrent.Semaphore;

import controller.ControllerExercicio1;

public class PrincipalExercicio1 {

	public static void main(String[] args) {
		
		String[] Sentido = { "Norte Sentido Sul", "Leste Sentido Oeste", "Oeste Sentido Leste", "Sul Sentido Norte" };
		
		int permissoes = 1;
		
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int i = 1; i < 5; i++) {
			ControllerExercicio1 Carro = new ControllerExercicio1(i,Sentido[i-1], semaforo);
			Carro.start();
		}
	}
}