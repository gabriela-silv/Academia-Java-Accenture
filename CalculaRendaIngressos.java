package sef.module3.sample;

import java.util.Scanner;

public class CalculaRendaIngressos {

	public static void main(String[] args) {
		
	      	final int PRECO_A = 50;
	        final int PRECO_B = 30;
	        final int PRECO_C = 20;

	        // Variáveis para armazenar a quantidade de bilhetes vendidos de cada categoria
	        int quantidadeA, quantidadeB, quantidadeC;
	        
	        Scanner sc = new Scanner(System.in);

	     
	        System.out.print("Quantidade de bilhetes vendidos na Classe A: ");
	        quantidadeA = sc.nextInt();

	        System.out.print("Quantidade de bilhetes vendidos na Classe B: ");
	        quantidadeB = sc.nextInt();

	        System.out.print("Quantidade de bilhetes vendidos na Classe C: ");
	        quantidadeC = sc.nextInt();

	        // Fecha o scanner após a leitura
	        sc.close();

	        // Cálculo da renda total
	        int rendaTotal = (quantidadeA * PRECO_A) + (quantidadeB * PRECO_B) + (quantidadeC * PRECO_C);

	        // Exibição da renda total gerada
	        System.out.println("\nRenda total gerada pela venda dos ingressos:");
	        System.out.println("R$ " + rendaTotal);
	    }

}
