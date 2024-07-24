package sef.module3.sample;

import java.util.Scanner;

public class JogoDaVelha {
		
	public static void main(String[] args) {
		
		  Scanner scanner = new Scanner(System.in);
	        String[][] tabuleiro = { 
	                        {" ", " ", " "},
	                        {" ", " ", " "},
	                        {" ", " ", " "}
	                    };
	        int jogadorAtual = 1; // Começa com o jogador 1
	        boolean jogoAtivo = true;
	        
	        System.out.println("Bem-vindo ao Jogo da Velha!\n");
	        while (jogoAtivo) {
	            // Imprime o tabuleiro atualizado
	            imprimirTabuleiro(tabuleiro);
	            
	            // Obtém a jogada do jogador atual
	            System.out.println("Jogador " + jogadorAtual + ", é sua vez.");
	            System.out.print("Digite a linha (0-2) e coluna (0-2) separados por espaço: ");
	            int linha = scanner.nextInt();
	            int coluna = scanner.nextInt();
	            
	            // Verifica se a jogada é válida
	            if (validarJogada(tabuleiro, linha, coluna)) {
	                // Realiza a jogada
	                realizarJogada(tabuleiro, linha, coluna, jogadorAtual);
	                
	                // Verifica se há um vencedor
	                String resultado = verificarResultado(tabuleiro);
	                if (!resultado.equals(" ")) {
	                    jogoAtivo = false;
	                    imprimirTabuleiro(tabuleiro);
	                    System.out.println("Parabéns, jogador " + resultado + "! Você venceu o jogo!");
	                } else if (tabuleiroCompleto(tabuleiro)) {
	                    jogoAtivo = false;
	                    imprimirTabuleiro(tabuleiro);
	                    System.out.println("Empate! O jogo terminou sem vencedores.");
	                } else {
	                    // Troca para o próximo jogador
	                    jogadorAtual = (jogadorAtual == 1) ? 2 : 1;
	                }
	            } else {
	                System.out.println("Jogada inválida. Por favor, escolha uma posição válida.");
	            }
	        }
	        
	        scanner.close();
	    }
	    
	    // Método para imprimir o tabuleiro
	    public static void imprimirTabuleiro(String[][] tabuleiro) {
	        System.out.println("\n  Tabuleiro:");
	        System.out.println("  0 1 2");
	        for (int i = 0; i < 3; i++) {
	            System.out.print(i + " ");
	            for (int j = 0; j < 3; j++) {
	                System.out.print(tabuleiro[i][j]);
	                if (j < 2) {
	                    System.out.print("|");
	                }
	            }
	            System.out.println();
	            if (i < 2) {
	                System.out.println("  -----");
	            }
	        }
	        System.out.println();
	    }
	    
	    // Método para validar se a jogada é válida
	    public static boolean validarJogada(String[][] tabuleiro, int linha, int coluna) {
	        return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna].equals(" ");
	    }
	    
	    // Método para realizar a jogada
	    public static void realizarJogada(String[][] tabuleiro, int linha, int coluna, int jogador) {
	        if (jogador == 1) {
	            tabuleiro[linha][coluna] = "X";
	        } else {
	            tabuleiro[linha][coluna] = "O";
	        }
	    }
	    
	    // Método para verificar se há um vencedor
	    public static String verificarResultado(String[][] tabuleiro) {
	        // Verifica linhas e colunas
	        for (int i = 0; i < 3; i++) {
	            // Linhas
	            if (!tabuleiro[i][0].equals(" ") && tabuleiro[i][0].equals(tabuleiro[i][1]) && tabuleiro[i][0].equals(tabuleiro[i][2])) {
	                return tabuleiro[i][0];
	            }
	            // Colunas
	            if (!tabuleiro[0][i].equals(" ") && tabuleiro[0][i].equals(tabuleiro[1][i]) && tabuleiro[0][i].equals(tabuleiro[2][i])) {
	                return tabuleiro[0][i];
	            }
	        }
	        
	        // Verifica diagonais
	        if (!tabuleiro[0][0].equals(" ") && tabuleiro[0][0].equals(tabuleiro[1][1]) && tabuleiro[0][0].equals(tabuleiro[2][2])) {
	            return tabuleiro[0][0];
	        }
	        if (!tabuleiro[0][2].equals(" ") && tabuleiro[0][2].equals(tabuleiro[1][1]) && tabuleiro[0][2].equals(tabuleiro[2][0])) {
	            return tabuleiro[0][2];
	        }
	        
	        // Se não houver vencedor
	        return " ";
	    }
	    
	    // Método para verificar se o tabuleiro está completo (empate)
	    public static boolean tabuleiroCompleto(String[][] tabuleiro) {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (tabuleiro[i][j].equals(" ")) {
	                    return false; // Ainda há espaço vazio, o jogo não terminou em empate
	                }
	            }
	        }
	        return true; // O tabuleiro está completo (empate)
	    }
		
	}

