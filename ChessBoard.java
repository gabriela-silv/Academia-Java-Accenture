package sef.module3.sample;

import javax.swing.JOptionPane;

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

        boolean jogoAtivo = true;
        int jogadorAtual = 1;

        while (jogoAtivo) {
            
            imprimirTabuleiro(board);

            String corJogador = (jogadorAtual == 1) ? "branca" : "preta";

            String entrada = JOptionPane.showInputDialog(null, "Jogador " + corJogador + ", é sua vez.\nDigite a posição de origem e destino do peão que deseja mover (por exemplo, 'b2 b3'):");

            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Entrada cancelada. Saindo do jogo.");
                break;
            }

            String[] partes = entrada.split(" ");
            if (partes.length != 2) {
                JOptionPane.showMessageDialog(null, "Formato de entrada inválido. Digite duas posições separadas por espaço (por exemplo, 'b2 b3').");
                continue;
            }

            String posicaoOrigem = partes[0];
            String posicaoDestino = partes[1];

            int colunaOrigem = posicaoOrigem.charAt(0) - 'a';
            int linhaOrigem = 8 - Character.getNumericValue(posicaoOrigem.charAt(1));

            int colunaDestino = posicaoDestino.charAt(0) - 'a';
            int linhaDestino = 8 - Character.getNumericValue(posicaoDestino.charAt(1));

            if (!board[linhaOrigem][colunaOrigem].equals("P") && !board[linhaOrigem][colunaOrigem].equals("p")) {
                JOptionPane.showMessageDialog(null, "Posição de origem não contém seu peão. Tente novamente.");
                continue;
            }

            if (!movimentoValidoParaPeao(board, linhaOrigem, colunaOrigem, linhaDestino, colunaDestino)) {
                JOptionPane.showMessageDialog(null, "Movimento inválido para o peão. Tente novamente.");
                continue;
            }

            board[linhaDestino][colunaDestino] = board[linhaOrigem][colunaOrigem];
            board[linhaOrigem][colunaOrigem] = " ";

            jogadorAtual = 2;
        }
    }

    public static void imprimirTabuleiro(String[][] board) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n  Tabuleiro de Xadrez:\n");
        sb.append("  a b c d e f g h\n");
        for (int i = 0; i < board.length; i++) {
            sb.append((8 - i) + " ");
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static boolean movimentoValidoParaPeao(String[][] board, int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        if (linhaDestino == linhaOrigem - 1 && colunaDestino == colunaOrigem && board[linhaDestino][colunaDestino].equals(" ")) {
            return true;
        } else if (linhaOrigem == 6 && linhaDestino == 4 && colunaDestino == colunaOrigem && board[4][colunaOrigem].equals(" ") && board[5][colunaOrigem].equals(" ")) {
            return true;
        } else if (linhaDestino == linhaOrigem - 1 && Math.abs(colunaDestino - colunaOrigem) == 1 && !board[linhaDestino][colunaDestino].equals(" ") && Character.isLowerCase(board[linhaDestino][colunaDestino].charAt(0))) {
            return true;
        }
        return false;
    }
}
