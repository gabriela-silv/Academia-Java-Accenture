package sef.module3.sample;

import java.util.Scanner;

public class ChessBoard {

    public static void main(String[] args) {
        String[][] board = {
            {"R", "N", "B", "Q", "K", "B", "N", "R"},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {"r", "n", "b", "q", "k", "b", "n", "r"}
        };

        Scanner scanner = new Scanner(System.in);
        boolean jogoAtivo = true;
        int jogadorAtual = 1; // Começa com as peças brancas

        while (jogoAtivo) {
            
            imprimirTabuleiro(board);

            // Determina a cor do jogador atual
            String corJogador = (jogadorAtual == 1) ? "branca" : "preta";

            // Solicita a jogada ao jogador
            System.out.println("\nJogador " + corJogador + ", é sua vez.");
            System.out.print("Digite a posição de origem e destino do peão que deseja mover (por exemplo, 'b2 b3'): ");
            String entrada = scanner.nextLine();

            // Extrai as posições de origem e destino da entrada
            String[] partes = entrada.split(" ");
            if (partes.length != 2) {
                System.out.println("Formato de entrada inválido. Digite duas posições separadas por espaço (por exemplo, 'b2 b3').");
                continue;
            }

            String posicaoOrigem = partes[0];
            String posicaoDestino = partes[1];

            // Converte as posições para índices de matriz
            int colunaOrigem = posicaoOrigem.charAt(0) - 'a';
            int linhaOrigem = 8 - Character.getNumericValue(posicaoOrigem.charAt(1));

            int colunaDestino = posicaoDestino.charAt(0) - 'a';
            int linhaDestino = 8 - Character.getNumericValue(posicaoDestino.charAt(1));

         // Verifica se a posição de origem contém um peão branco
            if (!board[linhaOrigem][colunaOrigem].equals("P") && !board[linhaOrigem][colunaOrigem].equals("p")) {
                System.out.println("Posição de origem não contém seu peão. Tente novamente.");
                continue;
            }

            // Verifica se o movimento é válido para um peão branco
            if (!movimentoValidoParaPeao(board, linhaOrigem, colunaOrigem, linhaDestino, colunaDestino)) {
                System.out.println("Movimento inválido para o peão. Tente novamente.");
                continue;
            }

            // Realiza o movimento do peão
            board[linhaDestino][colunaDestino] = board[linhaOrigem][colunaOrigem];
            board[linhaOrigem][colunaOrigem] = " ";

            
            jogadorAtual = 2; // Troca para as peças pretas
        }

     
        scanner.close();
    }

    // Método para imprimir o tabuleiro
    public static void imprimirTabuleiro(String[][] board) {
        System.out.println("\n  Tabuleiro de Xadrez:");
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < board.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para validar movimento de um peão branco
    public static boolean movimentoValidoParaPeao(String[][] board, int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
 
        if (linhaDestino == linhaOrigem - 1 && colunaDestino == colunaOrigem && board[linhaDestino][colunaDestino].equals(" ")) {
            return true;
        }
      
        else if (linhaOrigem == 6 && linhaDestino == 4 && colunaDestino == colunaOrigem && board[4][colunaOrigem].equals(" ") && board[5][colunaOrigem].equals(" ")) {
            return true;
        }

        else if (linhaDestino == linhaOrigem - 1 && Math.abs(colunaDestino - colunaOrigem) == 1 && !board[linhaDestino][colunaDestino].equals(" ") && Character.isLowerCase(board[linhaDestino][colunaDestino].charAt(0))) {
            return true;
        }
     
        return false;
    }
}
