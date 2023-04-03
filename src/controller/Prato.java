/*
RESUMO      : Classe do prato, simulando o "backend" de um jogo de cozinha
PROGRAMADORA: Luiza Felix
DATA        : 02/04/2023
 */

package controller;

import java.util.concurrent.Semaphore;

public class Prato extends Thread {

	private int ID;
	private String nome;
	private static Semaphore entrega = new Semaphore(1);

	public Prato(int id) {
		this.ID = id;
	}

	@Override
	public void run() {
		if (ID%2!=0) {
			nome = "Sopa de cebola";
			System.out.println("O prato ID#"+ ID + " ("+ nome + ") comecou a ser preparado");
			cozimento(500, 301);
		} 
		if(ID%2==0) {
			nome = "Lasanha a bolonhesa";
			System.out.println("O prato ID#"+ ID + " ("+ nome + ")  comecou a ser preparado");
			cozimento(600, 601);
		}
		entrega();
	}

	private void cozimento(int min, int max) {
		int tempo = (int) (Math.random() * max + min);
		int processo = 0;
		while(processo < tempo) {
			try {
				sleep(100);
				System.out.println("O prato ID#"+ ID + " ("+ nome + ") esta " + processo/10 + "% cozido");
				processo += 100;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("O prato ID#"+ ID + " ("+ nome + ") esta pronto para entrega!");

	}
	
	private void entrega() {
		try {
			entrega.acquire();
			sleep(500);
			System.out.println("O prato ID#"+ ID + " ("+ nome + ") foi entregue.");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} finally {
			entrega.release();
		}
		
	}

}
