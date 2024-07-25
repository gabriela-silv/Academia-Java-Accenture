package sef.module3.sample;

import javax.swing.JOptionPane;

public class JogoDaVelha {
    
    public static void main(String[] args) {
        
        String[][] tabuleiro = { 
                        {" ", " ", " "},
                        {" ", " ", " "},
                        {" ", " ", " "}
                    };
        int jogadorAtual = 1; 
        boolean jogoAtivo = true;
        
        JOptionPane.showMessageDialog(null, "Bem-vindo ao Jogo da Velha!");
        while (jogoAtivo) {
            
            imprimirTabuleiro(tabuleiro);
            
          
            String jogada = JOptionPane.showInputDialog("Jogador " + jogadorAtual + ", é sua vez.\nDigite a linha (0-2) e coluna (0-2) separados por espaço:");
            if (jogada == null) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, escolha uma posição válida.");
                continue;
            }
            String[] partes = jogada.split(" ");
            if (partes.length != 2) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira dois números separados por espaço.");
                continue;
            }
            
            int linha, coluna;
            try {
                linha = Integer.parseInt(partes[0]);
                coluna = Integer.parseInt(partes[1]);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira números válidos.");
                continue;
            }
            
         
            if (validarJogada(tabuleiro, linha, coluna)) {
                
                realizarJogada(tabuleiro, linha, coluna, jogadorAtual);
                
                String resultado = verificarResultado(tabuleiro);
                if (!resultado.equals(" ")) {
                    jogoAtivo = false;
                    imprimirTabuleiro(tabuleiro);
                    JOptionPane.showMessageDialog(null, "Parabéns, jogador " + resultado + "! Você venceu o jogo!");
                } else if (tabuleiroCompleto(tabuleiro)) {
                    jogoAtivo = false;
                    imprimirTabuleiro(tabuleiro);
                    JOptionPane.showMessageDialog(null, "Empate! O jogo terminou sem vencedores.");
                } else {
                    
                    jogadorAtual = (jogadorAtual == 1) ? 2 : 1;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Jogada inválida. Por favor, escolha uma posição válida.");
            }
        }
    }
    
    
    public static void imprimirTabuleiro(String[][] tabuleiro) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n  Tabuleiro:\n");
        sb.append("  0 1 2\n");
        for (int i = 0; i < 3; i++) {
            sb.append(i + " ");
            for (int j = 0; j < 3; j++) {
                sb.append(tabuleiro[i][j]);
                if (j < 2) {
                    sb.append("|");
                }
            }
            sb.append("\n");
            if (i < 2) {
                sb.append("  -----\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    
    public static boolean validarJogada(String[][] tabuleiro, int linha, int coluna) {
        return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna].equals(" ");
    }
    
  
    public static void realizarJogada(String[][] tabuleiro, int linha, int coluna, int jogador) {
        if (jogador == 1) {
            tabuleiro[linha][coluna] = "X";
        } else {
            tabuleiro[linha][coluna] = "O";
        }
    }
    
 
    public static String verificarResultado(String[][] tabuleiro) {
        
        for (int i = 0; i < 3; i++) {
          
            if (!tabuleiro[i][0].equals(" ") && tabuleiro[i][0].equals(tabuleiro[i][1]) && tabuleiro[i][0].equals(tabuleiro[i][2])) {
                return tabuleiro[i][0];
            }
           
            if (!tabuleiro[0][i].equals(" ") && tabuleiro[0][i].equals(tabuleiro[1][i]) && tabuleiro[0][i].equals(tabuleiro[2][i])) {
                return tabuleiro[0][i];
            }
        }
        
      
        if (!tabuleiro[0][0].equals(" ") && tabuleiro[0][0].equals(tabuleiro[1][1]) && tabuleiro[0][0].equals(tabuleiro[2][2])) {
            return tabuleiro[0][0];
        }
        if (!tabuleiro[0][2].equals(" ") && tabuleiro[0][2].equals(tabuleiro[1][1]) && tabuleiro[0][2].equals(tabuleiro[2][0])) {
            return tabuleiro[0][2];
        }
        
        
        return " ";
    }
    
    
    public static boolean tabuleiroCompleto(String[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j].equals(" ")) {
                    return false; 
                }
            }
        }
        return true; 
    }
}
