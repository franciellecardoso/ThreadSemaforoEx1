package controller;

import java.util.concurrent.Semaphore;

public class ThreadServidor extends Thread {

	private int id = 1;
	private Semaphore semaforo;

	public ThreadServidor(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		calculo();
		try {
			semaforo.acquire();
			transferencia();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void calculo() {
		if (id % 3 == 1) {
			int t = 200;
			for (int i = 0; i < 2; i++) {
				try {
					System.out.println("#" + id + " está realizando um cálculo");
					t = (int) ((Math.random() * 800) + t);
					sleep(t);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else if (id % 3 == 2) {
			for (int i = 0; i < 3; i++) {
				int t = 500;
				try {
					System.out.println("#" + id + " está realizando um cálculo");
					t = (int) (Math.random() * 1000 + t);
					sleep(t);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				int t = 1000;
				try {
					System.out.println("#" + id + " está realizando um cálculo");
					t = (int) Math.random() * 1000 + t;
					sleep(t);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("#" + id + " terminou de realizar os cálculos");
	}

	private void transferencia() {
		if (id % 3 == 1) {
			int t = 1000;
			for (int i = 0; i < 2; i++) {
				try {
					System.out.println("#" + id + " está realizando uma transferência");
					sleep(t);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else if (id % 3 == 2 || id % 3 == 0) {
			for (int i = 0; i < 3; i++) {
				int t = 1000;
				try {
					System.out.println("#" + id + " está realizando uma transferência");
					sleep(t);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(id + " terminou de realizar as transferências");
	}
}
