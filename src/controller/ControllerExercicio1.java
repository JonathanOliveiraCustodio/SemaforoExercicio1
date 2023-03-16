package controller;

import java.util.concurrent.Semaphore;

public class ControllerExercicio1 extends Thread {

	private int idCarro;
	private String Sentido;
	private double tempoInicial, tempoFinal, tempoTotal;
	private Semaphore semaforo;
	private static final int DISTANCIATOTAL = 150;

	public ControllerExercicio1(int idCarro, String direcao, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.Sentido = direcao;
		this.semaforo = semaforo;
	}

	
	public void run() {
		CarroAndando();
		try {
			CarroEsperando();
			semaforo.acquire();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		CarroCruzando();
	}

	private void CarroAndando() {
		int tempo = 1000;
		int distanciaPercorrida = 0;

		while (distanciaPercorrida < DISTANCIATOTAL) {
			int rodada = (int) (5 + Math.random() * 6);
			distanciaPercorrida += rodada;
			
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O Carro " + idCarro + " já andou " + distanciaPercorrida + " metros");
		}
	}
	
    
	
	

	private void CarroEsperando() {
		System.out.println("O Carro " + idCarro + " parou no cruzamento");
		tempoInicial = System.nanoTime();
	}

	private void CarroCruzando() {
		tempoFinal = System.nanoTime();
		tempoTotal = tempoFinal - tempoInicial;
		tempoTotal = tempoTotal / Math.pow(10, 9);
		System.out.println("O carro " + idCarro + " ficou aguardando no cruzamento: " + tempoTotal
				+ "segundos e cruzou da direção " + Sentido);
	}
}