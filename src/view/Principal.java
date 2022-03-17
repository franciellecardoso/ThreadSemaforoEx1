package view;

import java.util.concurrent.Semaphore;

import controller.ThreadServidor;

public class Principal {

	public static void main(String[] args) {
		final int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		for (int id = 1; id <= 21; id++) {
			ThreadServidor t = new ThreadServidor(id, semaforo);
			t.start();
		}
	}
}
