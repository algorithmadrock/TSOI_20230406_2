/*
RESUMO      : Classe de execução do código
PROGRAMADORA: Luiza Felix
DATA        : 02/04/2023
 */

package view;

import javax.swing.JOptionPane;

import controller.Prato;

public class Principal {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Para iniciar a simulação do jogo pressione OK");
		iniciar();
	}
	private static void iniciar() {
		for(int i = 1;i<=5;i++) {
			Thread prato = new Prato(i);
			prato.start();
		}
	}
}
