package view;

import java.util.concurrent.Semaphore;

import controller.Multiprocessamento;



public class Principal {

	public static void main(String[] args) {
		int permissoes =1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idThread =1; idThread <=21; idThread++)
		{
			
			Thread mProcessamento = new Multiprocessamento(idThread, semaforo);
			mProcessamento.start();
		}

	}

}
