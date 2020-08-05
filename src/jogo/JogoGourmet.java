package jogo;

import commons.Prato;
import resource.JogoGourmetResource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoGourmet {

    public static void main(String[] args) {
        JogoGourmetResource reource = new JogoGourmetResource();
        JFrame principal = getFramePrincipal(reource);
        principal.setVisible(true);
    }

    public static JFrame getFramePrincipal(JogoGourmetResource resource) {
        JFrame frame;
        JLabel label = new JLabel("Pense em um prato que você gosta.");
        label.setBounds(43, 10, 220, 50);
        JButton button = new JButton("OK");
        button.setBounds(105, 60, 80, 30);

        Prato lasanha = new Prato();
        lasanha.setDescricao("Lasanha");
        lasanha.setProximoPrato(null);
        lasanha.setPratoDiferente(null);

        Prato bolo = new Prato();
        bolo.setDescricao("Bolo de Chocolate");
        bolo.setProximoPrato(null);
        bolo.setPratoDiferente(null);

        Prato massa = new Prato();
        massa.setDescricao("Massa");
        massa.setProximoPrato(lasanha);
        massa.setPratoDiferente(bolo);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resource.iniciarJogo(massa);
            }
        });

        frame = new JFrame("Jogo Gourmet");
        frame.add(button);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        return frame;
    }

    public static void acertei() {
        JOptionPane.showMessageDialog(
                null,
                "Opa, Acertei! Daqui a pouco eu até consigo adivinhar os numeros da Mega-Sena hahaha",
                "Jogo Gourmet",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static int perguntarPrato(String descricao) {
        return JOptionPane.showConfirmDialog(
                null,
                "O prato que você pensou é " +descricao+ " ?",
                "Jogo Gourmet",
                JOptionPane.YES_NO_OPTION
        );
    }

    public static String perguntarNovoRamo(){
        return JOptionPane.showInputDialog(
                null,
                "Qual prato você pensou?",
                "Jogo Gourmet",
                JOptionPane.QUESTION_MESSAGE
        );
    }

    public static String perguntarDiferencaEntrePatros(String novoPrato, String pratoAtual){
        return JOptionPane.showInputDialog(
                null,
                novoPrato+ " é ________ mas " +pratoAtual+ " não.",
                "Jogo Gourmet",
                JOptionPane.QUESTION_MESSAGE
        );
    }
}
