package controller;

import java.util.concurrent.Semaphore;

public class Multiprocessamento extends Thread {
	private int idThread;
	private int operacao;
	private Semaphore semaforo;

	public Multiprocessamento(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;

	}

	@Override
	public void run() {

		if (idThread % 3 == 1) {
			operacoesRestoUm();
		} else if (idThread % 3 == 2) {
			operacoesRestoDois();
		} else {
			operacoesRestoZero();
		}

	}

	private void operacoesRestoUm() {
		int resto;
		int tCalculo = (int) ((Math.random() * 801) + 200);
		;
		int tTransacaoBd = 1000;

		for (int i = 1; i <= 4; i++) {
			if (i % 2 == 0) {
				try {
					semaforo.acquire();
					System.out.println("#"+idThread+ " Transação de BD");
					sleep(tTransacaoBd);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}

				finally { // linha que ocorre ao final do try ou do catch
					semaforo.release();
				}

			}

			else {
				System.out.println("#"+idThread+" Transação de Cálculo");
				try {
					sleep(tCalculo);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}

		}

	}

	private void operacoesRestoDois() {
		int tCalculo = (int) ((Math.random() * 1001) + 500);
		;
		int tTransacaoBd = 1500;

		for (int i = 1; i <= 6; i++) {
			if (i % 2 == 0) {
				try {
					semaforo.acquire();
					System.out.println("#"+idThread+" Transação de BD");
					sleep(tTransacaoBd);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}

				finally { // linha que ocorre ao final do try ou do catch
					semaforo.release();
				}

			}

			else {
				System.out.println("#"+idThread+" Transação de Cálculo");
				try {
					sleep(tCalculo);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}

		}

	}

	private void operacoesRestoZero() {
		int tCalculo = (int) ((Math.random() * 1001) + 1000);
		;
		int tTransacaoBd = 1500;

		for (int i = 1; i <= 6; i++) {
			if (i % 2 == 0) {
				try {
					semaforo.acquire();
					System.out.println("#"+idThread+" Transação de BD");
					sleep(tTransacaoBd);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}

				finally { // linha que ocorre ao final do try ou do catch
					semaforo.release();
				}

			}

			else {
				System.out.println("#"+idThread+" Transação de Cálculo");
				try {
					sleep(tCalculo);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}

		}

	}

}
